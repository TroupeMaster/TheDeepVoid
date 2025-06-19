package net.minecraft.network.protocol.game;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.world.InteractionHand;

public class ServerboundUseItemPacket implements Packet<ServerGamePacketListener> {
    public static final StreamCodec<FriendlyByteBuf, ServerboundUseItemPacket> STREAM_CODEC = Packet.codec(
        ServerboundUseItemPacket::write, ServerboundUseItemPacket::new
    );
    private final InteractionHand hand;
    private final int sequence;

    public ServerboundUseItemPacket(InteractionHand p_238011_, int p_238012_) {
        this.hand = p_238011_;
        this.sequence = p_238012_;
    }

    private ServerboundUseItemPacket(FriendlyByteBuf p_179798_) {
        this.hand = p_179798_.readEnum(InteractionHand.class);
        this.sequence = p_179798_.readVarInt();
    }

    private void write(FriendlyByteBuf p_134719_) {
        p_134719_.writeEnum(this.hand);
        p_134719_.writeVarInt(this.sequence);
    }

    @Override
    public PacketType<ServerboundUseItemPacket> type() {
        return GamePacketTypes.SERVERBOUND_USE_ITEM;
    }

    public void handle(ServerGamePacketListener p_134716_) {
        p_134716_.handleUseItem(this);
    }

    public InteractionHand getHand() {
        return this.hand;
    }

    public int getSequence() {
        return this.sequence;
    }
}
