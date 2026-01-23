
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class AshBrickSlabBlock extends SlabBlock {
	public AshBrickSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SOUL_SOIL).strength(1.2f, 0f).dynamicShape());
	}
}
