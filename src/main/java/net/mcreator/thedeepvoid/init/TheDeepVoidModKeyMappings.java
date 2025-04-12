
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.thedeepvoid.network.WeaverBootsNoGravityMessage;
import net.mcreator.thedeepvoid.network.MotherCallOutMessage;
import net.mcreator.thedeepvoid.network.ArmorToggleMessage;
import net.mcreator.thedeepvoid.network.ArmorAbilityMessage;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheDeepVoidModKeyMappings {
	public static final KeyMapping ARMOR_ABILITY = new KeyMapping("key.the_deep_void.armor_ability", GLFW.GLFW_KEY_V, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new ArmorAbilityMessage(0, 0));
				ArmorAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ARMOR_TOGGLE = new KeyMapping("key.the_deep_void.armor_toggle", GLFW.GLFW_KEY_C, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new ArmorToggleMessage(0, 0));
				ArmorToggleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOTHER_CALL_OUT = new KeyMapping("key.the_deep_void.mother_call_out", GLFW.GLFW_KEY_X, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new MotherCallOutMessage(0, 0));
				MotherCallOutMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping WEAVER_BOOTS_NO_GRAVITY = new KeyMapping("key.the_deep_void.weaver_boots_no_gravity", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new WeaverBootsNoGravityMessage(0, 0));
				WeaverBootsNoGravityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ARMOR_ABILITY);
		event.register(ARMOR_TOGGLE);
		event.register(MOTHER_CALL_OUT);
		event.register(WEAVER_BOOTS_NO_GRAVITY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ARMOR_ABILITY.consumeClick();
				ARMOR_TOGGLE.consumeClick();
				MOTHER_CALL_OUT.consumeClick();
				WEAVER_BOOTS_NO_GRAVITY.consumeClick();
			}
		}
	}
}
