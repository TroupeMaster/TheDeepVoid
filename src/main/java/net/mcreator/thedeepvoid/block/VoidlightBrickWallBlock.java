
package net.mcreator.thedeepvoid.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class VoidlightBrickWallBlock extends WallBlock {
	public VoidlightBrickWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SHROOMLIGHT).strength(1f, 2f).lightLevel(s -> 6).dynamicShape().forceSolidOn());
	}
}
