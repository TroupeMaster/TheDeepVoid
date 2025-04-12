
package net.mcreator.thedeepvoid.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class VoidlightBrickStairsBlock extends StairBlock {
	public VoidlightBrickStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.SHROOMLIGHT).strength(1f, 2f).lightLevel(s -> 6));
	}

	@Override
	public float getExplosionResistance() {
		return 2f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}
