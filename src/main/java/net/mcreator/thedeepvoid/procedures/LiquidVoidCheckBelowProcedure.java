package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class LiquidVoidCheckBelowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.SOLID_VOID_BLOCK.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y - 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sculk.place")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, (y - 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sculk.place")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}
