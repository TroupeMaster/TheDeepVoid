
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class RottenStairsBlock extends StairBlock {
	public RottenStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.BASALT).strength(2.2f, 16f));
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
