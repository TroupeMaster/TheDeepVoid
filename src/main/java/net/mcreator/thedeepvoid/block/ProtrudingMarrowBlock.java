
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ProtrudingMarrowBlock extends SugarCaneBlock {
	public ProtrudingMarrowBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).randomTicks().sound(SoundType.TWISTING_VINES).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CAVE;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		if (world.isEmptyBlock(pos.above())) {
			int i = 1;
			for (; world.getBlockState(pos.below(i)).is(this); ++i);
			if (i < 14) {
				int j = blockstate.getValue(AGE);
				if (ForgeHooks.onCropsGrowPre(world, pos, blockstate, true)) {
					if (j == 15) {
						world.setBlockAndUpdate(pos.above(), defaultBlockState());
						world.setBlock(pos, blockstate.setValue(AGE, 0), 4);
					} else {
						world.setBlock(pos, blockstate.setValue(AGE, j + 1), 4);
					}
				}
			}
		}
	}
}
