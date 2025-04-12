
package net.mcreator.thedeepvoid.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class VoidlightBrickSlabBlock extends SlabBlock {
	public VoidlightBrickSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SHROOMLIGHT).strength(1f, 2f).lightLevel(s -> 6));
	}
}
