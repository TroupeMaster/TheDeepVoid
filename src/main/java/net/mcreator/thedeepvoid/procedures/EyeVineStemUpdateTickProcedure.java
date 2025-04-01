package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class EyeVineStemUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() == false && ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.EYE_VINE_STEM.get()) == false
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.EYE_VINE.get()) == false
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.GREEN_EYE_VINE.get()) == false
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.RED_EYE_VINE.get()) == false
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.YELLOW_EYE_VINE.get()) == false) {
			if (Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.EYE_VINE_STEM.get().defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.grow")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.grow")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else {
				if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.GREEN_EYE_VINE.get().defaultBlockState(), 3);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				} else if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.RED_EYE_VINE.get().defaultBlockState(), 3);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				} else if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.YELLOW_EYE_VINE.get().defaultBlockState(), 3);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.EYE_VINE.get().defaultBlockState(), 3);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() == false && ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.EYE_VINE_STEM.get()) == false) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
