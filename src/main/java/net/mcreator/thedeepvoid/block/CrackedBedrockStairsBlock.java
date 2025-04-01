
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class CrackedBedrockStairsBlock extends StairBlock {
	public CrackedBedrockStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(70f, 1200f).requiresCorrectToolForDrops().pushReaction(PushReaction.BLOCK).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 1200f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}
