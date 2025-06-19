package net.minecraft.network.protocol;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.network.ClientboundPacketListener;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.PacketListener;
import net.minecraft.network.ProtocolInfo;
import net.minecraft.network.ServerboundPacketListener;
import net.minecraft.network.codec.StreamCodec;

public class ProtocolInfoBuilder<T extends PacketListener, B extends ByteBuf> {
    private final ConnectionProtocol protocol;
    private final PacketFlow flow;
    private final List<ProtocolInfoBuilder.CodecEntry<T, ?, B>> codecs = new ArrayList<>();
    @Nullable
    private BundlerInfo bundlerInfo;

    public ProtocolInfoBuilder(ConnectionProtocol p_320213_, PacketFlow p_320424_) {
        this.protocol = p_320213_;
        this.flow = p_320424_;
    }

    public <P extends Packet<? super T>> ProtocolInfoBuilder<T, B> addPacket(PacketType<P> p_320673_, StreamCodec<? super B, P> p_319828_) {
        this.codecs.add(new ProtocolInfoBuilder.CodecEntry<>(p_320673_, p_319828_));
        return this;
    }

    public <P extends BundlePacket<? super T>, D extends BundleDelimiterPacket<? super T>> ProtocolInfoBuilder<T, B> withBundlePacket(
        PacketType<P> p_320954_, Function<Iterable<Packet<? super T>>, P> p_320241_, D p_320202_
    ) {
        StreamCodec<ByteBuf, D> streamcodec = StreamCodec.unit(p_320202_);
        PacketType<D> packettype = (PacketType<D>)(PacketType<?>)p_320202_.type();
        this.codecs.add(new ProtocolInfoBuilder.CodecEntry<>(packettype, streamcodec));
        this.bundlerInfo = BundlerInfo.createForPacket(p_320954_, p_320241_, p_320202_);
        return this;
    }

    private StreamCodec<ByteBuf, Packet<? super T>> buildPacketCodec(Function<ByteBuf, B> p_320922_, List<ProtocolInfoBuilder.CodecEntry<T, ?, B>> p_320733_) {
        ProtocolCodecBuilder<ByteBuf, T> protocolcodecbuilder = new ProtocolCodecBuilder<>(this.flow);

        for (ProtocolInfoBuilder.CodecEntry<T, ?, B> codecentry : p_320733_) {
            codecentry.addToBuilder(protocolcodecbuilder, p_320922_);
        }

        return protocolcodecbuilder.build();
    }

    public ProtocolInfo<T> build(Function<ByteBuf, B> p_319806_) {
        return new ProtocolInfoBuilder.Implementation<>(this.protocol, this.flow, this.buildPacketCodec(p_319806_, this.codecs), this.bundlerInfo);
    }

    public ProtocolInfo.Unbound<T, B> buildUnbound() {
        List<ProtocolInfoBuilder.CodecEntry<T, ?, B>> list = List.copyOf(this.codecs);
        BundlerInfo bundlerinfo = this.bundlerInfo;
        return p_320823_ -> new ProtocolInfoBuilder.Implementation<>(this.protocol, this.flow, this.buildPacketCodec(p_320823_, list), bundlerinfo);
    }

    private static <L extends PacketListener> ProtocolInfo<L> protocol(
        ConnectionProtocol p_319927_, PacketFlow p_320658_, Consumer<ProtocolInfoBuilder<L, FriendlyByteBuf>> p_320484_
    ) {
        ProtocolInfoBuilder<L, FriendlyByteBuf> protocolinfobuilder = new ProtocolInfoBuilder<>(p_319927_, p_320658_);
        p_320484_.accept(protocolinfobuilder);
        return protocolinfobuilder.build(FriendlyByteBuf::new);
    }

    public static <T extends ServerboundPacketListener> ProtocolInfo<T> serverboundProtocol(
        ConnectionProtocol p_319767_, Consumer<ProtocolInfoBuilder<T, FriendlyByteBuf>> p_320799_
    ) {
        return protocol(p_319767_, PacketFlow.SERVERBOUND, p_320799_);
    }

    public static <T extends ClientboundPacketListener> ProtocolInfo<T> clientboundProtocol(
        ConnectionProtocol p_320428_, Consumer<ProtocolInfoBuilder<T, FriendlyByteBuf>> p_320292_
    ) {
        return protocol(p_320428_, PacketFlow.CLIENTBOUND, p_320292_);
    }

    private static <L extends PacketListener, B extends ByteBuf> ProtocolInfo.Unbound<L, B> protocolUnbound(
        ConnectionProtocol p_320849_, PacketFlow p_320146_, Consumer<ProtocolInfoBuilder<L, B>> p_320140_
    ) {
        ProtocolInfoBuilder<L, B> protocolinfobuilder = new ProtocolInfoBuilder<>(p_320849_, p_320146_);
        p_320140_.accept(protocolinfobuilder);
        return protocolinfobuilder.buildUnbound();
    }

    public static <T extends ServerboundPacketListener, B extends ByteBuf> ProtocolInfo.Unbound<T, B> serverboundProtocolUnbound(
        ConnectionProtocol p_320741_, Consumer<ProtocolInfoBuilder<T, B>> p_320299_
    ) {
        return protocolUnbound(p_320741_, PacketFlow.SERVERBOUND, p_320299_);
    }

    public static <T extends ClientboundPacketListener, B extends ByteBuf> ProtocolInfo.Unbound<T, B> clientboundProtocolUnbound(
        ConnectionProtocol p_320864_, Consumer<ProtocolInfoBuilder<T, B>> p_320056_
    ) {
        return protocolUnbound(p_320864_, PacketFlow.CLIENTBOUND, p_320056_);
    }

    static record CodecEntry<T extends PacketListener, P extends Packet<? super T>, B extends ByteBuf>(PacketType<P> type, StreamCodec<? super B, P> serializer) {
        public void addToBuilder(ProtocolCodecBuilder<ByteBuf, T> p_320857_, Function<ByteBuf, B> p_320646_) {
            StreamCodec<ByteBuf, P> streamcodec = this.serializer.mapStream(p_320646_);
            p_320857_.add(this.type, streamcodec);
        }
    }

    static record Implementation<L extends PacketListener>(
        ConnectionProtocol id, PacketFlow flow, StreamCodec<ByteBuf, Packet<? super L>> codec, @Nullable BundlerInfo bundlerInfo
    ) implements ProtocolInfo<L> {
    }
}
