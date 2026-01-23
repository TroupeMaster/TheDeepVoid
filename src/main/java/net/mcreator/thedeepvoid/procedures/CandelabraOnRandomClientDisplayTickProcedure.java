package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class CandelabraOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:candelabra")))) {
			if (Math.random() < 0.2) {
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 0, 6); index0++) {
					world.addParticle(ParticleTypes.FLAME, (x + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)), (y + Mth.nextDouble(RandomSource.create(), 1, 1.1)), (z + Mth.nextDouble(RandomSource.create(), 0.1, 0.9)), 0, 0, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:candlestick")))) {
			if (Math.random() < 0.2) {
				world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.9), (z + 0.5), 0, 0, 0);
			}
		}
		if (Math.random() < 0.05) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.candle.ambient")), SoundSource.BLOCKS, (float) Mth.nextDouble(RandomSource.create(), 0.7, 2),
							(float) Mth.nextDouble(RandomSource.create(), 0.3, 1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.candle.ambient")), SoundSource.BLOCKS, (float) Mth.nextDouble(RandomSource.create(), 0.7, 2),
							(float) Mth.nextDouble(RandomSource.create(), 0.3, 1), false);
				}
			}
		}
	}
}
