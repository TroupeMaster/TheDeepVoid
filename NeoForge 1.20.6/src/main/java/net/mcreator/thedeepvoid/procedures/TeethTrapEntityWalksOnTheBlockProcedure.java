package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TeethTrapEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() == false && ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.TEETH_TRAP_BLOCK.get()) == false) {
			world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.TEETH_TRAP_BLOCK.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.bone_block.break")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.bone_block.break")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			TheDeepVoidMod.queueServerWork(40, () -> {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.TEETH_TRAP_BLOCK.get()) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
			});
		}
	}
}
