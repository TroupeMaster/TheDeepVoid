package net.minecraft.client.multiplayer;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.logging.LogUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BooleanSupplier;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.CrashReportCategory;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.resources.server.DownloadedPackSource;
import net.minecraft.client.telemetry.WorldSessionTelemetryManager;
import net.minecraft.network.Connection;
import net.minecraft.network.ServerboundPacketListener;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketUtils;
import net.minecraft.network.protocol.common.ClientCommonPacketListener;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.ClientboundDisconnectPacket;
import net.minecraft.network.protocol.common.ClientboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ClientboundPingPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.protocol.common.ClientboundStoreCookiePacket;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ServerboundPongPacket;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket;
import net.minecraft.network.protocol.common.custom.BrandPayload;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.common.custom.DiscardedPayload;
import net.minecraft.network.protocol.cookie.ClientboundCookieRequestPacket;
import net.minecraft.network.protocol.cookie.ServerboundCookieResponsePacket;
import net.minecraft.realms.DisconnectedRealmsScreen;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.slf4j.Logger;

@OnlyIn(Dist.CLIENT)
public abstract class ClientCommonPacketListenerImpl implements ClientCommonPacketListener {
    private static final Component GENERIC_DISCONNECT_MESSAGE = Component.translatable("disconnect.lost");
    private static final Logger LOGGER = LogUtils.getLogger();
    protected final Minecraft minecraft;
    public final Connection connection;
    @Nullable
    protected final ServerData serverData;
    @Nullable
    protected String serverBrand;
    protected final WorldSessionTelemetryManager telemetryManager;
    @Nullable
    protected final Screen postDisconnectScreen;
    protected boolean isTransferring;
    @Deprecated(
        forRemoval = true
    )
    protected final boolean strictErrorHandling;
    private final List<ClientCommonPacketListenerImpl.DeferredPacket> deferredPackets = new ArrayList<>();
    protected final Map<ResourceLocation, byte[]> serverCookies;
    /**
     * Holds the current connection type, based on the types of payloads that have been received so far.
     */
    protected net.neoforged.neoforge.network.connection.ConnectionType connectionType = net.neoforged.neoforge.network.connection.ConnectionType.OTHER;

    protected ClientCommonPacketListenerImpl(Minecraft p_295454_, Connection p_294773_, CommonListenerCookie p_294647_) {
        this.minecraft = p_295454_;
        this.connection = p_294773_;
        this.serverData = p_294647_.serverData();
        this.serverBrand = p_294647_.serverBrand();
        this.telemetryManager = p_294647_.telemetryManager();
        this.postDisconnectScreen = p_294647_.postDisconnectScreen();
        this.serverCookies = p_294647_.serverCookies();
        this.strictErrorHandling = p_294647_.strictErrorHandling();
        // Neo: Set the connection type based on the cookie from the previous phase.
        this.connectionType = p_294647_.connectionType();
    }

    @Override
    public void onPacketError(Packet p_341624_, Exception p_341639_) {
        LOGGER.error("Failed to handle packet {}", p_341624_, p_341639_);
        if (this.strictErrorHandling) {
            this.connection.disconnect(Component.translatable("disconnect.packetError"));
        }
    }

    @Override
    public boolean shouldHandleMessage(Packet<?> p_341905_) {
        return ClientCommonPacketListener.super.shouldHandleMessage(p_341905_)
            ? true
            : this.isTransferring && (p_341905_ instanceof ClientboundStoreCookiePacket || p_341905_ instanceof ClientboundTransferPacket);
    }

    @Override
    public void handleKeepAlive(ClientboundKeepAlivePacket p_295361_) {
        this.sendWhen(new ServerboundKeepAlivePacket(p_295361_.getId()), () -> !RenderSystem.isFrozenAtPollEvents(), Duration.ofMinutes(1L));
    }

    @Override
    public void handlePing(ClientboundPingPacket p_295594_) {
        PacketUtils.ensureRunningOnSameThread(p_295594_, this, this.minecraft);
        this.send(new ServerboundPongPacket(p_295594_.getId()));
    }

    @Override
    public void handleCustomPayload(ClientboundCustomPayloadPacket p_295727_) {
        // Neo: Unconditionally handle register/unregister payloads.
        if (p_295727_.payload() instanceof net.neoforged.neoforge.network.payload.MinecraftRegisterPayload minecraftRegisterPayload) {
            net.neoforged.neoforge.network.registration.NetworkRegistry.onMinecraftRegister(this.getConnection(), minecraftRegisterPayload.newChannels());
            return;
        }

        if (p_295727_.payload() instanceof net.neoforged.neoforge.network.payload.MinecraftUnregisterPayload minecraftUnregisterPayload) {
            net.neoforged.neoforge.network.registration.NetworkRegistry.onMinecraftUnregister(this.getConnection(), minecraftUnregisterPayload.forgottenChannels());
            return;
        }

        // Neo: Handle modded payloads. Vanilla payloads do not get sent to the modded handling pass. Additional payloads cannot be registered in the minecraft domain.
        if (net.neoforged.neoforge.network.registration.NetworkRegistry.isModdedPayload(p_295727_.payload())) {
            net.neoforged.neoforge.network.registration.NetworkRegistry.handleModdedPayload(this, p_295727_);
            return;
        }

        CustomPacketPayload custompacketpayload = p_295727_.payload();
        if (!(custompacketpayload instanceof DiscardedPayload)) {
            PacketUtils.ensureRunningOnSameThread(p_295727_, this, this.minecraft);
            if (custompacketpayload instanceof BrandPayload brandpayload) {
                this.serverBrand = brandpayload.brand();
                this.telemetryManager.onServerBrandReceived(brandpayload.brand());
            } else {
                this.handleCustomPayload(custompacketpayload);
            }
        }
    }

    protected abstract void handleCustomPayload(CustomPacketPayload p_295776_);

    @Override
    public void handleResourcePackPush(ClientboundResourcePackPushPacket p_314606_) {
        PacketUtils.ensureRunningOnSameThread(p_314606_, this, this.minecraft);
        UUID uuid = p_314606_.id();
        URL url = parseResourcePackUrl(p_314606_.url());
        if (url == null) {
            this.connection.send(new ServerboundResourcePackPacket(uuid, ServerboundResourcePackPacket.Action.INVALID_URL));
        } else {
            String s = p_314606_.hash();
            boolean flag = p_314606_.required();
            ServerData.ServerPackStatus serverdata$serverpackstatus = this.serverData != null
                ? this.serverData.getResourcePackStatus()
                : ServerData.ServerPackStatus.PROMPT;
            if (serverdata$serverpackstatus != ServerData.ServerPackStatus.PROMPT
                && (!flag || serverdata$serverpackstatus != ServerData.ServerPackStatus.DISABLED)) {
                this.minecraft.getDownloadedPackSource().pushPack(uuid, url, s);
            } else {
                this.minecraft.setScreen(this.addOrUpdatePackPrompt(uuid, url, s, flag, p_314606_.prompt().orElse(null)));
            }
        }
    }

    @Override
    public void handleResourcePackPop(ClientboundResourcePackPopPacket p_314537_) {
        PacketUtils.ensureRunningOnSameThread(p_314537_, this, this.minecraft);
        p_314537_.id()
            .ifPresentOrElse(p_314401_ -> this.minecraft.getDownloadedPackSource().popPack(p_314401_), () -> this.minecraft.getDownloadedPackSource().popAll());
    }

    static Component preparePackPrompt(Component p_296200_, @Nullable Component p_295584_) {
        return (Component)(p_295584_ == null ? p_296200_ : Component.translatable("multiplayer.texturePrompt.serverPrompt", p_296200_, p_295584_));
    }

    @Nullable
    private static URL parseResourcePackUrl(String p_295495_) {
        try {
            URL url = new URL(p_295495_);
            String s = url.getProtocol();
            return !"http".equals(s) && !"https".equals(s) ? null : url;
        } catch (MalformedURLException malformedurlexception) {
            return null;
        }
    }

    @Override
    public void handleRequestCookie(ClientboundCookieRequestPacket p_320212_) {
        PacketUtils.ensureRunningOnSameThread(p_320212_, this, this.minecraft);
        this.connection.send(new ServerboundCookieResponsePacket(p_320212_.key(), this.serverCookies.get(p_320212_.key())));
    }

    @Override
    public void handleStoreCookie(ClientboundStoreCookiePacket p_320008_) {
        PacketUtils.ensureRunningOnSameThread(p_320008_, this, this.minecraft);
        this.serverCookies.put(p_320008_.key(), p_320008_.payload());
    }

    @Override
    public void handleTransfer(ClientboundTransferPacket p_320739_) {
        this.isTransferring = true;
        PacketUtils.ensureRunningOnSameThread(p_320739_, this, this.minecraft);
        if (this.serverData == null) {
            throw new IllegalStateException("Cannot transfer to server from singleplayer");
        } else {
            this.connection.disconnect(Component.translatable("disconnect.transfer"));
            this.connection.setReadOnly();
            this.connection.handleDisconnection();
            ServerAddress serveraddress = new ServerAddress(p_320739_.host(), p_320739_.port());
            ConnectScreen.startConnecting(
                Objects.requireNonNullElseGet(this.postDisconnectScreen, TitleScreen::new),
                this.minecraft,
                serveraddress,
                this.serverData,
                false,
                new TransferState(this.serverCookies)
            );
        }
    }

    @Override
    public void handleDisconnect(ClientboundDisconnectPacket p_296159_) {
        this.connection.disconnect(p_296159_.reason());
    }

    protected void sendDeferredPackets() {
        Iterator<ClientCommonPacketListenerImpl.DeferredPacket> iterator = this.deferredPackets.iterator();

        while (iterator.hasNext()) {
            ClientCommonPacketListenerImpl.DeferredPacket clientcommonpacketlistenerimpl$deferredpacket = iterator.next();
            if (clientcommonpacketlistenerimpl$deferredpacket.sendCondition().getAsBoolean()) {
                this.send(clientcommonpacketlistenerimpl$deferredpacket.packet);
                iterator.remove();
            } else if (clientcommonpacketlistenerimpl$deferredpacket.expirationTime() <= Util.getMillis()) {
                iterator.remove();
            }
        }
    }

    public void send(Packet<?> p_295097_) {
        // Neo: Validate modded payloads before sending.
        net.neoforged.neoforge.network.registration.NetworkRegistry.checkPacket(p_295097_, this);
        this.connection.send(p_295097_);
    }

    @Override
    public void onDisconnect(Component p_295485_) {
        this.telemetryManager.onDisconnect();
        this.minecraft.disconnect(this.createDisconnectScreen(p_295485_), this.isTransferring);
        if (!this.connection.isMemoryConnection()) {
            net.neoforged.neoforge.registries.RegistryManager.revertToFrozen();
        }
        LOGGER.warn("Client disconnected with reason: {}", p_295485_.getString());
    }

    @Override
    public void fillListenerSpecificCrashDetails(CrashReportCategory p_315011_) {
        p_315011_.setDetail("Server type", () -> this.serverData != null ? this.serverData.type().toString() : "<none>");
        p_315011_.setDetail("Server brand", () -> this.serverBrand);
    }

    protected Screen createDisconnectScreen(Component p_296470_) {
        Screen screen = Objects.requireNonNullElseGet(this.postDisconnectScreen, () -> new JoinMultiplayerScreen(new TitleScreen()));
        return (Screen)(this.serverData != null && this.serverData.isRealm()
            ? new DisconnectedRealmsScreen(screen, GENERIC_DISCONNECT_MESSAGE, p_296470_)
            : new DisconnectedScreen(screen, GENERIC_DISCONNECT_MESSAGE, p_296470_));
    }

    @Nullable
    public String serverBrand() {
        return this.serverBrand;
    }

    private void sendWhen(Packet<? extends ServerboundPacketListener> p_296259_, BooleanSupplier p_296086_, Duration p_294812_) {
        if (p_296086_.getAsBoolean()) {
            this.send(p_296259_);
        } else {
            this.deferredPackets.add(new ClientCommonPacketListenerImpl.DeferredPacket(p_296259_, p_296086_, Util.getMillis() + p_294812_.toMillis()));
        }
    }

    private Screen addOrUpdatePackPrompt(UUID p_314948_, URL p_315012_, String p_314981_, boolean p_315013_, @Nullable Component p_314960_) {
        Screen screen = this.minecraft.screen;
        return screen instanceof ClientCommonPacketListenerImpl.PackConfirmScreen clientcommonpacketlistenerimpl$packconfirmscreen
            ? clientcommonpacketlistenerimpl$packconfirmscreen.update(this.minecraft, p_314948_, p_315012_, p_314981_, p_315013_, p_314960_)
            : new ClientCommonPacketListenerImpl.PackConfirmScreen(
                this.minecraft,
                screen,
                List.of(new ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest(p_314948_, p_315012_, p_314981_)),
                p_315013_,
                p_314960_
            );
    }

    @OnlyIn(Dist.CLIENT)
    static record DeferredPacket(Packet<? extends ServerboundPacketListener> packet, BooleanSupplier sendCondition, long expirationTime) {
    }

    @OnlyIn(Dist.CLIENT)
    class PackConfirmScreen extends ConfirmScreen {
        private final List<ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest> requests;
        @Nullable
        private final Screen parentScreen;

        PackConfirmScreen(
            Minecraft p_314973_,
            @Nullable Screen p_315016_,
            List<ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest> p_314994_,
            boolean p_314923_,
            @Nullable Component p_314940_
        ) {
            super(
                p_315005_ -> {
                    p_314973_.setScreen(p_315016_);
                    DownloadedPackSource downloadedpacksource = p_314973_.getDownloadedPackSource();
                    if (p_315005_) {
                        if (ClientCommonPacketListenerImpl.this.serverData != null) {
                            ClientCommonPacketListenerImpl.this.serverData.setResourcePackStatus(ServerData.ServerPackStatus.ENABLED);
                        }

                        downloadedpacksource.allowServerPacks();
                    } else {
                        downloadedpacksource.rejectServerPacks();
                        if (p_314923_) {
                            ClientCommonPacketListenerImpl.this.connection.disconnect(Component.translatable("multiplayer.requiredTexturePrompt.disconnect"));
                        } else if (ClientCommonPacketListenerImpl.this.serverData != null) {
                            ClientCommonPacketListenerImpl.this.serverData.setResourcePackStatus(ServerData.ServerPackStatus.DISABLED);
                        }
                    }

                    for (ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest clientcommonpacketlistenerimpl$packconfirmscreen$pendingrequest : p_314994_) {
                        downloadedpacksource.pushPack(
                            clientcommonpacketlistenerimpl$packconfirmscreen$pendingrequest.id,
                            clientcommonpacketlistenerimpl$packconfirmscreen$pendingrequest.url,
                            clientcommonpacketlistenerimpl$packconfirmscreen$pendingrequest.hash
                        );
                    }

                    if (ClientCommonPacketListenerImpl.this.serverData != null) {
                        ServerList.saveSingleServer(ClientCommonPacketListenerImpl.this.serverData);
                    }
                },
                p_314923_ ? Component.translatable("multiplayer.requiredTexturePrompt.line1") : Component.translatable("multiplayer.texturePrompt.line1"),
                ClientCommonPacketListenerImpl.preparePackPrompt(
                    p_314923_
                        ? Component.translatable("multiplayer.requiredTexturePrompt.line2").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD)
                        : Component.translatable("multiplayer.texturePrompt.line2"),
                    p_314940_
                ),
                p_314923_ ? CommonComponents.GUI_PROCEED : CommonComponents.GUI_YES,
                p_314923_ ? CommonComponents.GUI_DISCONNECT : CommonComponents.GUI_NO
            );
            this.requests = p_314994_;
            this.parentScreen = p_315016_;
        }

        public ClientCommonPacketListenerImpl.PackConfirmScreen update(
            Minecraft p_314946_, UUID p_314980_, URL p_314930_, String p_315003_, boolean p_314916_, @Nullable Component p_314991_
        ) {
            List<ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest> list = ImmutableList.<ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest>builderWithExpectedSize(
                    this.requests.size() + 1
                )
                .addAll(this.requests)
                .add(new ClientCommonPacketListenerImpl.PackConfirmScreen.PendingRequest(p_314980_, p_314930_, p_315003_))
                .build();
            return ClientCommonPacketListenerImpl.this.new PackConfirmScreen(p_314946_, this.parentScreen, list, p_314916_, p_314991_);
        }

        @OnlyIn(Dist.CLIENT)
        static record PendingRequest(UUID id, URL url, String hash) {
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
