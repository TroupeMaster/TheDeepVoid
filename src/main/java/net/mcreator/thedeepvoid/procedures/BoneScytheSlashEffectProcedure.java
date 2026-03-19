package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class BoneScytheSlashEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double radianArc = 0;
		double d = 0;
		double verticalOffset = 0;
		double sign = 0;
		double rollAngle = 0;
		double horizontalOffsetDir = 0;
		double i = 0;
		double dMajor = 0;
		double horizontalOffsetMag = 0;
		double circleDistanceConstant = 0;
		double radianSteps = 0;
		double arcStart = 0;
		double cooldown = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 0.85));
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 0.85), false);
			}
		}
		circleDistanceConstant = 3;
		rollAngle = 0;
		horizontalOffsetMag = 0;
		horizontalOffsetDir = 0;
		verticalOffset = 0.5;
		dMajor = circleDistanceConstant;
		d = circleDistanceConstant * Math.cos(Math.toRadians(rollAngle));
		i = (0 * Math.PI) / 1;
		radianArc = (1 * Math.PI) / 1;
		radianSteps = (1 * Math.PI) / 16;
		arcStart = Math.toRadians(entity.getYRot() + 0);
		while (i <= radianArc) {
			if (0 > Math.sin(i)) {
				sign = -1;
			} else {
				sign = 1;
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT,
						(dMajor * Math.cos(i) * Math.cos(arcStart) - d * Math.sin(i) * Math.sin(arcStart) + entity.getX() + horizontalOffsetMag * Math.sin(Math.toRadians(entity.getYRot() + 180 + horizontalOffsetDir))),
						(sign * Math.sqrt(Math.abs(Math.sin(Math.toRadians(rollAngle))) * (Math.pow(dMajor, 2) - Math.pow(dMajor * Math.cos(i), 2))) + entity.getY() + 1 + verticalOffset),
						(dMajor * Math.cos(i) * Math.sin(arcStart) + d * Math.sin(i) * Math.cos(arcStart) + entity.getZ() - horizontalOffsetMag * Math.cos(Math.toRadians(entity.getYRot() + 180 + horizontalOffsetDir))), 4,
						(Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.1), 0, (Math.cos(Math.toRadians(entity.getYRot())) * 0.1), 0.1);
			i = i + radianSteps;
		}
	}
}
