
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class PolishedLavenditeSlabBlock extends SlabBlock {
	public PolishedLavenditeSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.AMETHYST).strength(1.8f, 3f));
	}
}
