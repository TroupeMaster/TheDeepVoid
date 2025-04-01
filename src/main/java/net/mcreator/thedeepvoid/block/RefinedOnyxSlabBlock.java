
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class RefinedOnyxSlabBlock extends SlabBlock {
	public RefinedOnyxSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).strength(3f, 5f).requiresCorrectToolForDrops().dynamicShape());
	}
}
