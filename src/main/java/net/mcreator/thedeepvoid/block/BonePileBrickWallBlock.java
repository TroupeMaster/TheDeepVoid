
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class BonePileBrickWallBlock extends WallBlock {
	public BonePileBrickWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).strength(0.8f, 8f).dynamicShape().forceSolidOn());
	}
}
