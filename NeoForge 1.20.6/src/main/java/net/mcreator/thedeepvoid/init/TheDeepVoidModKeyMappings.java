
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.thedeepvoid.network.WeaverBootsNoGravityMessage;
import net.mcreator.thedeepvoid.network.MountUpMessage;
import net.mcreator.thedeepvoid.network.MountFlyMessage;
import net.mcreator.thedeepvoid.network.MountDownMessage;
import net.mcreator.thedeepvoid.network.MountDashMessage;
import net.mcreator.thedeepvoid.network.MotherCallOutMessage;
import net.mcreator.thedeepvoid.network.ArmorToggleMessage;
import net.mcreator.thedeepvoid.network.ArmorAbilityMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheDeepVoidModKeyMappings {
	public static final KeyMapping ARMOR_ABILITY = new KeyMapping("key.the_deep_void.armor_ability", GLFW.GLFW_KEY_UNKNOWN, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ArmorAbilityMessage(0, 0));
				ArmorAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ARMOR_TOGGLE = new KeyMapping("key.the_deep_void.armor_toggle", GLFW.GLFW_KEY_UNKNOWN, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ArmorToggleMessage(0, 0));
				ArmorToggleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOTHER_CALL_OUT = new KeyMapping("key.the_deep_void.mother_call_out", GLFW.GLFW_KEY_UNKNOWN, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MotherCallOutMessage(0, 0));
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
				PacketDistributor.sendToServer(new WeaverBootsNoGravityMessage(0, 0));
				WeaverBootsNoGravityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOUNT_FLY = new KeyMapping("key.the_deep_void.mount_fly", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MountFlyMessage(0, 0));
				MountFlyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOUNT_UP = new KeyMapping("key.the_deep_void.mount_up", GLFW.GLFW_KEY_UNKNOWN, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MountUpMessage(0, 0));
				MountUpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MOUNT_UP_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MOUNT_UP_LASTPRESS);
				PacketDistributor.sendToServer(new MountUpMessage(1, dt));
				MountUpMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOUNT_DOWN = new KeyMapping("key.the_deep_void.mount_down", GLFW.GLFW_KEY_UNKNOWN, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MountDownMessage(0, 0));
				MountDownMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MOUNT_DOWN_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MOUNT_DOWN_LASTPRESS);
				PacketDistributor.sendToServer(new MountDownMessage(1, dt));
				MountDownMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOUNT_DASH = new KeyMapping("key.the_deep_void.mount_dash", GLFW.GLFW_KEY_UNKNOWN, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MountDashMessage(0, 0));
				MountDashMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MOUNT_DASH_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MOUNT_DASH_LASTPRESS);
				PacketDistributor.sendToServer(new MountDashMessage(1, dt));
				MountDashMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long MOUNT_UP_LASTPRESS = 0;
	private static long MOUNT_DOWN_LASTPRESS = 0;
	private static long MOUNT_DASH_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ARMOR_ABILITY);
		event.register(ARMOR_TOGGLE);
		event.register(MOTHER_CALL_OUT);
		event.register(WEAVER_BOOTS_NO_GRAVITY);
		event.register(MOUNT_FLY);
		event.register(MOUNT_UP);
		event.register(MOUNT_DOWN);
		event.register(MOUNT_DASH);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				ARMOR_ABILITY.consumeClick();
				ARMOR_TOGGLE.consumeClick();
				MOTHER_CALL_OUT.consumeClick();
				WEAVER_BOOTS_NO_GRAVITY.consumeClick();
				MOUNT_FLY.consumeClick();
				MOUNT_UP.consumeClick();
				MOUNT_DOWN.consumeClick();
				MOUNT_DASH.consumeClick();
			}
		}
	}
}
