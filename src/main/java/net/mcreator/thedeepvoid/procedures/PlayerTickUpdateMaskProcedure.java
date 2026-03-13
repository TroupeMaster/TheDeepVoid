package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class PlayerTickUpdateMaskProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).healthBoostLevel > 0) {
			if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get())) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.healthBoostLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).removeModifier(UUID.fromString("a2a1826b-7829-42ed-986e-984ebf45427b"));
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_HELMET.get())
				&& entity.getPersistentData().getBoolean("bloodstoneEquipHelmet") == true) {
			entity.getPersistentData().putBoolean("bloodstoneEquipHelmet", false);
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_CHESTPLATE.get())
				&& entity.getPersistentData().getBoolean("bloodstoneEquipChest") == true) {
			entity.getPersistentData().putBoolean("bloodstoneEquipChest", false);
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_LEGGINGS.get())
				&& entity.getPersistentData().getBoolean("bloodstoneEquipLeggings") == true) {
			entity.getPersistentData().putBoolean("bloodstoneEquipLeggings", false);
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_BOOTS.get())
				&& entity.getPersistentData().getBoolean("bloodstoneEquipBoots") == true) {
			entity.getPersistentData().putBoolean("bloodstoneEquipBoots", false);
		}
	}
}
