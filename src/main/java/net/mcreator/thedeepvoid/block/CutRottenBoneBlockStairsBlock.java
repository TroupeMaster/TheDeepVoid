
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class CutRottenBoneBlockStairsBlock extends StairBlock {
	public CutRottenBoneBlockStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).strength(2.2f, 16f).requiresCorrectToolForDrops().dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 16f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}
