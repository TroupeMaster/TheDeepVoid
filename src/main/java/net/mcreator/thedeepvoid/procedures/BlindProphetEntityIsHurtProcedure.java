package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BlindProphetEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (Math.random() < 0.2) {
				if (Math.random() < 0.4) {
					entity.setDeltaMovement(new Vec3(0, 0.2, 1.5));
				} else if (Math.random() < 0.4) {
					entity.setDeltaMovement(new Vec3((-1.5), 0.2, 0));
				} else if (Math.random() < 0.4) {
					entity.setDeltaMovement(new Vec3(0, 0.2, (-1.5)));
				} else {
					entity.setDeltaMovement(new Vec3(1.5, 0.2, 0));
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, (float) 1.4, (float) 0.8);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, (float) 1.4, (float) 0.8, false);
					}
				}
			}
			if (Math.random() < 0.3) {
				if (entity.getPersistentData().getBoolean("deep_void:prophetSlam") == false) {
					entity.setDeltaMovement(new Vec3(0, 0.7, 0));
					entity.getPersistentData().putBoolean("deep_void:prophetSlam", true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, (float) 1.4, (float) 0.6);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, (float) 1.4, (float) 0.6, false);
						}
					}
				}
			}
		}
	}
}
