package net.minecraft.network.protocol.handshake;

import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.ProtocolInfo;
import net.minecraft.network.protocol.ProtocolInfoBuilder;

public class HandshakeProtocols {
    public static final ProtocolInfo<ServerHandshakePacketListener> SERVERBOUND = ProtocolInfoBuilder.serverboundProtocol(
        ConnectionProtocol.HANDSHAKING, p_319952_ -> p_319952_.addPacket(HandshakePacketTypes.CLIENT_INTENTION, ClientIntentionPacket.STREAM_CODEC)
    );
}
