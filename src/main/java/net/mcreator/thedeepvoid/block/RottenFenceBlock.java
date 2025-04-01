
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class RottenFenceBlock extends FenceBlock {
	public RottenFenceBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.BASALT).strength(2.2f, 16f).dynamicShape().forceSolidOn());
	}
}
