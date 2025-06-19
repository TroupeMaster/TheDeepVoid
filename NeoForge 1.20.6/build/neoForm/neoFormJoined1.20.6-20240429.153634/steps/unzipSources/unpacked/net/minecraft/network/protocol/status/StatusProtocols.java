package net.minecraft.network.protocol.status;

import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.ProtocolInfo;
import net.minecraft.network.protocol.ProtocolInfoBuilder;
import net.minecraft.network.protocol.ping.ClientboundPongResponsePacket;
import net.minecraft.network.protocol.ping.PingPacketTypes;
import net.minecraft.network.protocol.ping.ServerboundPingRequestPacket;

public class StatusProtocols {
    public static final ProtocolInfo<ServerStatusPacketListener> SERVERBOUND = ProtocolInfoBuilder.serverboundProtocol(
        ConnectionProtocol.STATUS,
        p_320512_ -> p_320512_.addPacket(StatusPacketTypes.SERVERBOUND_STATUS_REQUEST, ServerboundStatusRequestPacket.STREAM_CODEC)
                .addPacket(PingPacketTypes.SERVERBOUND_PING_REQUEST, ServerboundPingRequestPacket.STREAM_CODEC)
    );
    public static final ProtocolInfo<ClientStatusPacketListener> CLIENTBOUND = ProtocolInfoBuilder.clientboundProtocol(
        ConnectionProtocol.STATUS,
        p_320855_ -> p_320855_.addPacket(StatusPacketTypes.CLIENTBOUND_STATUS_RESPONSE, ClientboundStatusResponsePacket.STREAM_CODEC)
                .addPacket(PingPacketTypes.CLIENTBOUND_PONG_RESPONSE, ClientboundPongResponsePacket.STREAM_CODEC)
    );
}
