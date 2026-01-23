package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.UUID;

public class HuntersBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("doubleJump") == true) {
			if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR)) {
				itemstack.getOrCreateTag().putBoolean("doubleJump", false);
			}
		}
		if (!(((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).getModifier(UUID.fromString("43e58095-0a95-4141-9302-f24c6b94b456")) != null)
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_BOOTS.get()) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get())
					.hasModifier((new AttributeModifier(UUID.fromString("43e58095-0a95-4141-9302-f24c6b94b456"), "hunterBoots_stepHeight", 0.4, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get())
						.addTransientModifier((new AttributeModifier(UUID.fromString("43e58095-0a95-4141-9302-f24c6b94b456"), "hunterBoots_stepHeight", 0.4, AttributeModifier.Operation.ADDITION)));
		}
	}
}
