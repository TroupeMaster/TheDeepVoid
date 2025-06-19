
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class AshBrickWallBlock extends WallBlock {
	public AshBrickWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SOUL_SOIL).strength(1.2f, 0f).forceSolidOn());
	}
}
