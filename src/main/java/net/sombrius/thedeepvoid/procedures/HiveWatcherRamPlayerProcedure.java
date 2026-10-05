package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.sombrius.thedeepvoid.entity.HiveWatcherEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class HiveWatcherRamPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof HiveWatcherEntity _datEntL0 && _datEntL0.getEntityData().get(HiveWatcherEntity.DATA_changeTexture)) == false) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_changeTexture, true);
			if (entity instanceof HiveWatcherEntity animatable)
				animatable.setTexture("hivewatcher");
		}
		entity.getPersistentData().putDouble("speedBuildUpTarget",
				(entity.getPersistentData().getDouble("speedBuildUpTarget") + ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 1.4 ? 0.025 : 0.015)));
		entity.getPersistentData().putDouble("stopRamming", (entity.getPersistentData().getDouble("stopRamming") + 1));
		if (entity.getPersistentData().getDouble("playerIsIn") == 1) {
			entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("speedBuildUpTarget")), 0, 0));
		} else if (entity.getPersistentData().getDouble("playerIsIn") == 2) {
			entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("speedBuildUpTarget") * (-1)), 0, 0));
		} else if (entity.getPersistentData().getDouble("playerIsIn") == 3) {
			entity.setDeltaMovement(new Vec3(0, 0, (entity.getPersistentData().getDouble("speedBuildUpTarget"))));
		} else if (entity.getPersistentData().getDouble("playerIsIn") == 4) {
			entity.setDeltaMovement(new Vec3(0, 0, (entity.getPersistentData().getDouble("speedBuildUpTarget") * (-1))));
		}
		if ((world.getBlockFloorHeight(BlockPos.containing(entity.getX() + 3, entity.getY(), entity.getZ())) > 0 || world.getBlockFloorHeight(BlockPos.containing(entity.getX() - 3, entity.getY(), entity.getZ())) > 0
				|| world.getBlockFloorHeight(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 3)) > 0 || world.getBlockFloorHeight(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 3)) > 0)
				&& entity.getPersistentData().getDouble("speedBuildUpTarget") >= 0.5 || entity.getPersistentData().getDouble("stopRamming") >= 60) {
			entity.getPersistentData().putBoolean("foundPlayer", false);
			entity.getPersistentData().putDouble("playerIsIn", 0);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
				entity.getPersistentData().putDouble("findPlayerCooldown", 40);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4) {
				entity.getPersistentData().putDouble("findPlayerCooldown", 5);
			} else {
				entity.getPersistentData().putDouble("findPlayerCooldown", 60);
			}
			entity.getPersistentData().putDouble("speedBuildUpTarget", 0);
			entity.getPersistentData().putDouble("stopRamming", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, (float) 0.9);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, (float) 0.9, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.TREMBLE.get(), 20, 1, false, false));
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 1.2) {
				HiveWatcherSpawnTeethProcedure.execute(world, x, y, z, entity);
			}
			if ((entity instanceof HiveWatcherEntity _datEntL61 && _datEntL61.getEntityData().get(HiveWatcherEntity.DATA_changeTexture)) == true) {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_changeTexture, false);
				if (entity instanceof HiveWatcherEntity animatable)
					animatable.setTexture("hivewatchernoeyes");
			}
		}
	}
}
