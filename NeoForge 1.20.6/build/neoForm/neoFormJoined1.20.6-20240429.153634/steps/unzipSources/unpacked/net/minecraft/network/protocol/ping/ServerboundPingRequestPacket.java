package net.minecraft.network.protocol.ping;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketType;

public class ServerboundPingRequestPacket implements Packet<ServerPingPacketListener> {
    public static final StreamCodec<FriendlyByteBuf, ServerboundPingRequestPacket> STREAM_CODEC = Packet.codec(
        ServerboundPingRequestPacket::write, ServerboundPingRequestPacket::new
    );
    private final long time;

    public ServerboundPingRequestPacket(long p_320277_) {
        this.time = p_320277_;
    }

    private ServerboundPingRequestPacket(FriendlyByteBuf p_320208_) {
        this.time = p_320208_.readLong();
    }

    private void write(FriendlyByteBuf p_320674_) {
        p_320674_.writeLong(this.time);
    }

    @Override
    public PacketType<ServerboundPingRequestPacket> type() {
        return PingPacketTypes.SERVERBOUND_PING_REQUEST;
    }

    public void handle(ServerPingPacketListener p_320053_) {
        p_320053_.handlePingRequest(this);
    }

    public long getTime() {
        return this.time;
    }
}
