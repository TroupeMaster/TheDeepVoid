
package net.mcreator.thedeepvoid.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.world.inventory.UndertakerTradeGuiMenu;
import net.mcreator.thedeepvoid.procedures.UndertakerButton6ClickProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton5ClickProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton4ClickProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton3ClickProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton2ClickProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton1ClickProcedure;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UndertakerTradeGuiButtonMessage {
	private final int buttonID, x, y, z;

	public UndertakerTradeGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public UndertakerTradeGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(UndertakerTradeGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(UndertakerTradeGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = UndertakerTradeGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			UndertakerButton1ClickProcedure.execute(entity);
		}
		if (buttonID == 1) {

			UndertakerButton2ClickProcedure.execute(entity);
		}
		if (buttonID == 2) {

			UndertakerButton3ClickProcedure.execute(entity);
		}
		if (buttonID == 3) {

			UndertakerButton4ClickProcedure.execute(entity);
		}
		if (buttonID == 4) {

			UndertakerButton5ClickProcedure.execute(entity);
		}
		if (buttonID == 5) {

			UndertakerButton6ClickProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheDeepVoidMod.addNetworkMessage(UndertakerTradeGuiButtonMessage.class, UndertakerTradeGuiButtonMessage::buffer, UndertakerTradeGuiButtonMessage::new, UndertakerTradeGuiButtonMessage::handler);
	}
}
