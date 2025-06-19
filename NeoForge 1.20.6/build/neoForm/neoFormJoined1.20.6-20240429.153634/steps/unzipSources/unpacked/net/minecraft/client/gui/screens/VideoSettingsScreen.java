package net.minecraft.client.gui.screens;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Monitor;
import com.mojang.blaze3d.platform.VideoMode;
import com.mojang.blaze3d.platform.Window;
import java.util.List;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.renderer.GpuWarnlistManager;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VideoSettingsScreen extends OptionsSubScreen {
    private static final Component TITLE = Component.translatable("options.videoTitle");
    private static final Component FABULOUS = Component.translatable("options.graphics.fabulous").withStyle(ChatFormatting.ITALIC);
    private static final Component WARNING_MESSAGE = Component.translatable("options.graphics.warning.message", FABULOUS, FABULOUS);
    private static final Component WARNING_TITLE = Component.translatable("options.graphics.warning.title").withStyle(ChatFormatting.RED);
    private static final Component BUTTON_ACCEPT = Component.translatable("options.graphics.warning.accept");
    private static final Component BUTTON_CANCEL = Component.translatable("options.graphics.warning.cancel");
    private OptionsList list;
    private final GpuWarnlistManager gpuWarnlistManager;
    private final int oldMipmaps;

    private static OptionInstance<?>[] options(Options p_232812_) {
        return new OptionInstance[]{
            p_232812_.graphicsMode(),
            p_232812_.renderDistance(),
            p_232812_.prioritizeChunkUpdates(),
            p_232812_.simulationDistance(),
            p_232812_.ambientOcclusion(),
            p_232812_.framerateLimit(),
            p_232812_.enableVsync(),
            p_232812_.bobView(),
            p_232812_.guiScale(),
            p_232812_.attackIndicator(),
            p_232812_.gamma(),
            p_232812_.cloudStatus(),
            p_232812_.fullscreen(),
            p_232812_.particles(),
            p_232812_.mipmapLevels(),
            p_232812_.entityShadows(),
            p_232812_.screenEffectScale(),
            p_232812_.entityDistanceScaling(),
            p_232812_.fovEffectScale(),
            p_232812_.showAutosaveIndicator(),
            p_232812_.glintSpeed(),
            p_232812_.glintStrength(),
            p_232812_.menuBackgroundBlurriness()
        };
    }

    public VideoSettingsScreen(Screen p_96806_, Options p_96807_) {
        super(p_96806_, p_96807_, TITLE);
        this.gpuWarnlistManager = p_96806_.minecraft.getGpuWarnlistManager();
        this.gpuWarnlistManager.resetWarnings();
        if (p_96807_.graphicsMode().get() == GraphicsStatus.FABULOUS) {
            this.gpuWarnlistManager.dismissWarning();
        }

        this.oldMipmaps = p_96807_.mipmapLevels().get();
    }

    @Override
    protected void init() {
        this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
        int i = -1;
        Window window = this.minecraft.getWindow();
        Monitor monitor = window.findBestMonitor();
        int j;
        if (monitor == null) {
            j = -1;
        } else {
            Optional<VideoMode> optional = window.getPreferredFullscreenVideoMode();
            j = optional.map(monitor::getVideoModeIndex).orElse(-1);
        }

        OptionInstance<Integer> optioninstance = new OptionInstance<>(
            "options.fullscreen.resolution",
            OptionInstance.noTooltip(),
            (p_302145_, p_302146_) -> {
                if (monitor == null) {
                    return Component.translatable("options.fullscreen.unavailable");
                } else if (p_302146_ == -1) {
                    return Options.genericValueLabel(p_302145_, Component.translatable("options.fullscreen.current"));
                } else {
                    VideoMode videomode = monitor.getMode(p_302146_);
                    return Options.genericValueLabel(
                        p_302145_,
                        Component.translatable(
                            "options.fullscreen.entry",
                            videomode.getWidth(),
                            videomode.getHeight(),
                            videomode.getRefreshRate(),
                            videomode.getRedBits() + videomode.getGreenBits() + videomode.getBlueBits()
                        )
                    );
                }
            },
            new OptionInstance.IntRange(-1, monitor != null ? monitor.getModeCount() - 1 : -1),
            j,
            p_232803_ -> {
                if (monitor != null) {
                    window.setPreferredFullscreenVideoMode(p_232803_ == -1 ? Optional.empty() : Optional.of(monitor.getMode(p_232803_)));
                }
            }
        );
        this.list.addBig(optioninstance);
        this.list.addBig(this.options.biomeBlendRadius());
        this.list.addSmall(options(this.options));
        super.init();
    }

    @Override
    public void onClose() {
        this.minecraft.getWindow().changeFullscreenVideoMode();
        super.onClose();
    }

    @Override
    protected void repositionElements() {
        super.repositionElements();
        this.list.updateSize(this.width, this.layout);
    }

    @Override
    public void removed() {
        if (this.options.mipmapLevels().get() != this.oldMipmaps) {
            this.minecraft.updateMaxMipLevel(this.options.mipmapLevels().get());
            this.minecraft.delayTextureReload();
        }

        super.removed();
    }

    @Override
    public boolean mouseClicked(double p_96809_, double p_96810_, int p_96811_) {
        if (super.mouseClicked(p_96809_, p_96810_, p_96811_)) {
            if (this.gpuWarnlistManager.isShowingWarning()) {
                List<Component> list = Lists.newArrayList(WARNING_MESSAGE, CommonComponents.NEW_LINE);
                String s = this.gpuWarnlistManager.getRendererWarnings();
                if (s != null) {
                    list.add(CommonComponents.NEW_LINE);
                    list.add(Component.translatable("options.graphics.warning.renderer", s).withStyle(ChatFormatting.GRAY));
                }

                String s1 = this.gpuWarnlistManager.getVendorWarnings();
                if (s1 != null) {
                    list.add(CommonComponents.NEW_LINE);
                    list.add(Component.translatable("options.graphics.warning.vendor", s1).withStyle(ChatFormatting.GRAY));
                }

                String s2 = this.gpuWarnlistManager.getVersionWarnings();
                if (s2 != null) {
                    list.add(CommonComponents.NEW_LINE);
                    list.add(Component.translatable("options.graphics.warning.version", s2).withStyle(ChatFormatting.GRAY));
                }

                this.minecraft
                    .setScreen(
                        new UnsupportedGraphicsWarningScreen(
                            WARNING_TITLE, list, ImmutableList.of(new UnsupportedGraphicsWarningScreen.ButtonOption(BUTTON_ACCEPT, p_280839_ -> {
                                this.options.graphicsMode().set(GraphicsStatus.FABULOUS);
                                Minecraft.getInstance().levelRenderer.allChanged();
                                this.gpuWarnlistManager.dismissWarning();
                                this.minecraft.setScreen(this);
                            }), new UnsupportedGraphicsWarningScreen.ButtonOption(BUTTON_CANCEL, p_280840_ -> {
                                this.gpuWarnlistManager.dismissWarningAndSkipFabulous();
                                this.minecraft.setScreen(this);
                            }))
                        )
                    );
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean mouseScrolled(double p_278332_, double p_278334_, double p_278285_, double p_296453_) {
        if (Screen.hasControlDown()) {
            OptionInstance<Integer> optioninstance = this.options.guiScale();
            if (optioninstance.values() instanceof OptionInstance.ClampingLazyMaxIntRange optioninstance$clampinglazymaxintrange) {
                int k = optioninstance.get();
                int i = k == 0 ? optioninstance$clampinglazymaxintrange.maxInclusive() + 1 : k;
                int j = i + (int)Math.signum(p_296453_);
                if (j != 0 && j <= optioninstance$clampinglazymaxintrange.maxInclusive() && j >= optioninstance$clampinglazymaxintrange.minInclusive()) {
                    CycleButton<Integer> cyclebutton = (CycleButton<Integer>)this.list.findOption(optioninstance);
                    if (cyclebutton != null) {
                        optioninstance.set(j);
                        cyclebutton.setValue(j);
                        this.list.setScrollAmount(0.0);
                        return true;
                    }
                }
            }

            return false;
        } else {
            return super.mouseScrolled(p_278332_, p_278334_, p_278285_, p_296453_);
        }
    }
}
