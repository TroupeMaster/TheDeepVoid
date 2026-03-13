package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class FlyWingsChestplateTickEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack components = ItemStack.EMPTY;
		if (itemstack.getOrCreateTag().getBoolean("flying") == true && entity.getPersistentData().getBoolean("flyWingsTouchGround") == true) {
			if (itemstack.getOrCreateTag().getDouble("time") > 0) {
				if (itemstack.getOrCreateTag().getBoolean("up") == true) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.6, (entity.getDeltaMovement().z())));
				} else if (itemstack.getOrCreateTag().getBoolean("down") == true) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.6), (entity.getDeltaMovement().z())));
				} else if (itemstack.getOrCreateTag().getBoolean("foward") == true) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.6), 0, (Math.cos(Math.toRadians(entity.getYRot())) * 0.6)));
				} else if (itemstack.getOrCreateTag().getBoolean("backward") == true) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-0.6)), 0, (Math.cos(Math.toRadians(entity.getYRot())) * (-0.6))));
				} else {
					entity.setDeltaMovement(new Vec3(0, 0, 0));
				}
				if (Math.random() < 0.001) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("time", (itemstack.getOrCreateTag().getDouble("time") - 1));
			} else if (entity.getPersistentData().getBoolean("flyWingsTouchGround") == true) {
				itemstack.getOrCreateTag().putBoolean("foward", false);
				itemstack.getOrCreateTag().putBoolean("backward", false);
				itemstack.getOrCreateTag().putBoolean("up", false);
				itemstack.getOrCreateTag().putBoolean("down", false);
				if (!(entity instanceof LivingEntity _livEnt41 && _livEnt41.hasEffect(MobEffects.SLOW_FALLING))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
				}
				if (entity.onGround()) {
					components = (itemstack.copy());
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack(TheDeepVoidModItems.FLY_WINGS_CHESTPLATE.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TheDeepVoidModItems.FLY_WINGS_CHESTPLATE.get()));
						}
					}
					{
						CompoundTag _nbtTag = components.getTag();
						if (_nbtTag != null)
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).setTag(_nbtTag.copy());
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem(), 140);
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putBoolean("flying", false);
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("time", 0);
					entity.getPersistentData().putBoolean("flyWingsTouchGround", false);
				}
			}
		}
	}
}
