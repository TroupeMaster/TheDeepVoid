package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.ExecutionerEntity;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ExecutionerGrabProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ExecutionerEntity _datEntSetL)
			_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_attacking, true);
		if (entity instanceof ExecutionerEntity) {
			((ExecutionerEntity) entity).setAnimation("empty");
		}
		if (entity instanceof ExecutionerEntity) {
			((ExecutionerEntity) entity).setAnimation("animation.executioner_grab");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 99, false, false));
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.6),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			entity.setDeltaMovement(
					new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 1 : 0.8)), 0.1,
							(Math.cos(Math.toRadians(entity.getYRot())) * ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 1 : 0.8))));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.6);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.6, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(24, () -> {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if ((entityiterator instanceof LivingEntity _entUseItem29 ? _entUseItem29.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
							if (entityiterator instanceof Player _player)
								_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem31 ? _entUseItem31.getUseItem() : ItemStack.EMPTY).getItem(), 100);
							{
								ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem33 ? _entUseItem33.getUseItem() : ItemStack.EMPTY);
								if (_ist.hurt(10, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.stopUsingItem();
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")),
											SoundSource.PLAYERS, (float) 0.4, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")), SoundSource.PLAYERS,
											(float) 0.4, 1, false);
								}
							}
						}
						entityiterator.getPersistentData().putBoolean("grabbedByExecutioner", true);
						entityiterator.getPersistentData().putDouble("executionerStab", 0);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 100, 0));
						if (entity instanceof ExecutionerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_grabbed, true);
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(25, () -> {
			if ((entity instanceof ExecutionerEntity _datEntL46 && _datEntL46.getEntityData().get(ExecutionerEntity.DATA_grabbed)) == false
					&& (entity instanceof ExecutionerEntity _datEntL47 && _datEntL47.getEntityData().get(ExecutionerEntity.DATA_attacking)) == true) {
				if (entity instanceof ExecutionerEntity) {
					((ExecutionerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof ApostleBossEntity) {
					((ApostleBossEntity) entity).setAnimation("animation.executioner_grabMiss");
				}
				if (entity instanceof ExecutionerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_attacking, false);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			}
		});
		TheDeepVoidMod.queueServerWork(90, () -> {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getPersistentData().getBoolean("grabbedByExecutioner") == true) {
						entityiterator.getPersistentData().putBoolean("grabbedByExecutioner", false);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(60, () -> {
			if ((entity instanceof ExecutionerEntity _datEntL62 && _datEntL62.getEntityData().get(ExecutionerEntity.DATA_grabbed)) == true) {
				if (entity instanceof ExecutionerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_attacking, false);
				if (entity instanceof ExecutionerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_grabbed, false);
			}
		});
	}
}
