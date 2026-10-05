package net.sombrius.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class HiveWatcherTickUpdateNewProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 && entity.getPersistentData().getDouble("moveRandomlyFrequency") != 12) {
			entity.getPersistentData().putDouble("moveRandomlyFrequency", 12);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 && entity.getPersistentData().getDouble("moveRandomlyFrequency") != 8) {
			entity.getPersistentData().putDouble("moveRandomlyFrequency", 8);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4 && entity.getPersistentData().getDouble("moveRandomlyFrequency") != 0) {
			entity.getPersistentData().putDouble("moveRandomlyFrequency", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:everhunger_scream")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:everhunger_scream")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity.getPersistentData().getBoolean("foundPlayer") == false) {
				if (entity.getPersistentData().getDouble("findPlayerCooldown") <= 0) {
					HiveWatcherFindPlayerProcedure.execute(world, entity);
				}
				if (entity.getPersistentData().getBoolean("moveInPos") == false) {
					if (entity.getPersistentData().getDouble("moveRandomly") >= entity.getPersistentData().getDouble("moveRandomlyFrequency")) {
						entity.getPersistentData().putDouble("moveRandomly", 0);
						entity.getPersistentData().putBoolean("moveInPos", true);
						HiveWatcherMoveRandomlyProcedure.execute(world, entity);
					} else {
						entity.getPersistentData().putDouble("moveRandomly", (entity.getPersistentData().getDouble("moveRandomly") + 1));
					}
				} else if (entity.getPersistentData().getBoolean("moveInPos") == true) {
					if (entity.getPersistentData().getDouble("stopMove") < ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 30 : 35)) {
						HiveWatcherWhileMovingProcedure.execute(world, x, y, z, entity);
						entity.getPersistentData().putDouble("stopMove", (entity.getPersistentData().getDouble("stopMove") + 1));
					} else {
						HiveWatcherResetTagsProcedure.execute(entity);
						HiveWatcherShootIchorProcedure.execute(world, entity);
					}
				}
			} else if (entity.getPersistentData().getBoolean("foundPlayer") == true) {
				HiveWatcherRamPlayerProcedure.execute(world, x, y, z, entity);
				HiveWatcherResetTagsProcedure.execute(entity);
			}
		} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putBoolean("foundPlayer", false);
			HiveWatcherResetTagsProcedure.execute(entity);
		}
		if (entity.getPersistentData().getDouble("findPlayerCooldown") > 0) {
			entity.getPersistentData().putDouble("findPlayerCooldown", (entity.getPersistentData().getDouble("findPlayerCooldown") - 1));
		}
		if (entity.getPersistentData().getDouble("shieldCooldown") > 0) {
			entity.getPersistentData().putDouble("shieldCooldown", (entity.getPersistentData().getDouble("shieldCooldown") - 1));
		}
		HiveWatcherTickAdditionsProcedure.execute(world, x, y, z, entity);
	}
}
