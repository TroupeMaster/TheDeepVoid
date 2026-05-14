package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ApostleBossPlayerCollidesWithThisEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof ApostleBossEntity _datEntL0 && _datEntL0.getEntityData().get(ApostleBossEntity.DATA_runGrab)) == true) {
			if (entity instanceof ApostleBossEntity) {
				((ApostleBossEntity) entity).setAnimation("empty");
			}
			if (entity instanceof ApostleBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_runGrab, false);
			if (entity instanceof ApostleBossEntity) {
				((ApostleBossEntity) entity).setAnimation("animation.apostle_grab");
			}
			if (entity instanceof ApostleBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_grabbedPlayer, true);
			sourceentity.getPersistentData().putBoolean("grabbedByApostle", true);
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity), 4);
			if (!(sourceentity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(TheDeepVoidModMobEffects.BROKEN_ARMOR.get()))) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 400, 0));
			}
			if ((sourceentity instanceof LivingEntity _entUseItem10 ? _entUseItem10.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _entUseItem12 ? _entUseItem12.getUseItem() : ItemStack.EMPTY).getItem(), 100);
				{
					ItemStack _ist = (sourceentity instanceof LivingEntity _entUseItem14 ? _entUseItem14.getUseItem() : ItemStack.EMPTY);
					if (_ist.hurt(10, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.stopUsingItem();
			}
			TheDeepVoidMod.queueServerWork(13, () -> {
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_upMotion, true);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
			});
			TheDeepVoidMod.queueServerWork(18, () -> {
				if (!entity.onGround()) {
					if (entity instanceof ApostleBossEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_jumpGrab, true);
				}
			});
			TheDeepVoidMod.queueServerWork(25, () -> {
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_upMotion, false);
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_downMotion, true);
			});
		}
	}
}
