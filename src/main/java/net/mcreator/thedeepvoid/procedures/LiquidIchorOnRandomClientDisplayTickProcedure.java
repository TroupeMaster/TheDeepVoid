package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

public class LiquidIchorOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.0025) {
			if (world instanceof Level _level) {
				if (_level.isClientSide()) {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, (float) Mth.nextDouble(RandomSource.create(), 0.2, 0.4),
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.05), false);
				}
			}
			if (world instanceof Level _level) {
				if (_level.isClientSide()) {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.BLOCKS, (float) Mth.nextDouble(RandomSource.create(), 0.2, 0.4),
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.05), false);
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 12, 24); index0++) {
				world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_LAVA.get()), (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), y, (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)),
						(Mth.nextDouble(RandomSource.create(), -0.02, 0.02)), (Mth.nextDouble(RandomSource.create(), 0.4, 0.8)), (Mth.nextDouble(RandomSource.create(), -0.02, 0.02)));
			}
			for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 20, 32); index1++) {
				world.addParticle(ParticleTypes.SMOKE, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), y, (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
						(Mth.nextDouble(RandomSource.create(), 0.2, 0.6)), (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)));
			}
		}
		if (Math.random() < 0.006) {
			if (world instanceof Level _level) {
				if (_level.isClientSide()) {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.BLOCKS, (float) Mth.nextDouble(RandomSource.create(), 0.2, 0.4),
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.05), false);
				}
			}
		}
		if (Math.random() < 0.002) {
			if (world instanceof Level _level) {
				if (_level.isClientSide()) {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.BLOCKS, (float) Mth.nextDouble(RandomSource.create(), 0.2, 0.4),
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.05), false);
				}
			}
			for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 1, 2); index2++) {
				world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_LAVA.get()), (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), y, (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)),
						(Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), 0.14, 0.36)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
			}
		}
	}
}
