
package net.mcreator.thedeepvoid.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.world.inventory.SoulForgeGUIMenu;
import net.mcreator.thedeepvoid.procedures.TakenSoulFusedIngotProcedure;
import net.mcreator.thedeepvoid.procedures.TakenItemFromSlotSoulForgeProcedure;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SoulForgeGUISlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final Type<SoulForgeGUISlotMessage> TYPE = new Type<>(new ResourceLocation(TheDeepVoidMod.MODID, "soul_forge_gui_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SoulForgeGUISlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SoulForgeGUISlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new SoulForgeGUISlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SoulForgeGUISlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final SoulForgeGUISlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SoulForgeGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			TakenItemFromSlotSoulForgeProcedure.execute(entity);
		}
		if (slot == 1 && changeType == 1) {

			TakenItemFromSlotSoulForgeProcedure.execute(entity);
		}
		if (slot == 2 && changeType == 1) {

			TakenSoulFusedIngotProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheDeepVoidMod.addNetworkMessage(SoulForgeGUISlotMessage.TYPE, SoulForgeGUISlotMessage.STREAM_CODEC, SoulForgeGUISlotMessage::handleData);
	}
}
