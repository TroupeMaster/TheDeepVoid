package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

public class MadnessLanternTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.LUNATIC_EYE.get()), (x + Mth.nextInt(RandomSource.create(), -15, 15)), (y + Mth.nextInt(RandomSource.create(), -5, 5)),
					(z + Mth.nextInt(RandomSource.create(), -15, 15)), 1, 0, 0, 0, 0);
		if (Math.random() < 0.1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:quiet_slow_whisper")), SoundSource.BLOCKS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:quiet_slow_whisper")), SoundSource.BLOCKS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
				}
			}
		}
	}
}
