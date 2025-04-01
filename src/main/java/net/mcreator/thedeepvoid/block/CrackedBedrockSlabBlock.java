
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CrackedBedrockSlabBlock extends SlabBlock {
	public CrackedBedrockSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(70f, 1200f).requiresCorrectToolForDrops().pushReaction(PushReaction.BLOCK).dynamicShape());
	}
}
