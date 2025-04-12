
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class AshBrickStairsBlock extends StairBlock {
	public AshBrickStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.SOUL_SOIL).strength(1.2f, 0f));
	}

	@Override
	public float getExplosionResistance() {
		return 0f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}
