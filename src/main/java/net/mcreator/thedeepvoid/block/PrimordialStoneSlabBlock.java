
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class PrimordialStoneSlabBlock extends SlabBlock {
	public PrimordialStoneSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHERRACK).strength(70f, 1200f).requiresCorrectToolForDrops().pushReaction(PushReaction.BLOCK));
	}
}
