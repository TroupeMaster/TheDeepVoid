package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class SulfurPowderNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.FIRE) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.FIRE.defaultBlockState(), 3);
			world.addParticle(ParticleTypes.LAVA, x, y, z, 0, 0.1, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1, (float) 1.4);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1, (float) 1.4, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SOUL_FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SOUL_FIRE
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SOUL_FIRE || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SOUL_FIRE
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SOUL_FIRE || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_FIRE) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			world.addParticle(ParticleTypes.LAVA, x, y, z, 0, 0.1, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1, (float) 1.4);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 1, (float) 1.4, false);
				}
			}
		}
	}
}
