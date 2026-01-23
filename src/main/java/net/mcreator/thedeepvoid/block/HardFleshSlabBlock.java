
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class HardFleshSlabBlock extends SlabBlock {
	public HardFleshSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.PACKED_MUD).strength(10f, 8f).friction(0.7f).dynamicShape());
	}
}
