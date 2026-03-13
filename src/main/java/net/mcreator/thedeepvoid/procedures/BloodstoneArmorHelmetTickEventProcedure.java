package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class BloodstoneArmorHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_HELMET.get()) {
			if (entity.getPersistentData().getBoolean("bloodstoneEquipHelmet") == false) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
				entity.getPersistentData().putBoolean("bloodstoneEquipHelmet", true);
			}
		} else if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_CHESTPLATE.get()) {
			if (entity.getPersistentData().getBoolean("bloodstoneEquipChest") == false) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
				entity.getPersistentData().putBoolean("bloodstoneEquipChest", true);
			}
		} else if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_LEGGINGS.get()) {
			if (entity.getPersistentData().getBoolean("bloodstoneEquipLeggings") == false) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
				entity.getPersistentData().putBoolean("bloodstoneEquipLeggings", true);
			}
		} else if (itemstack.getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_BOOTS.get()) {
			if (entity.getPersistentData().getBoolean("bloodstoneEquipBoots") == false) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
				entity.getPersistentData().putBoolean("bloodstoneEquipBoots", true);
			}
		}
	}
}
