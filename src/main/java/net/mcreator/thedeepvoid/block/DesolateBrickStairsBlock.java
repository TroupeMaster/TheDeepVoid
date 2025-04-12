
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.common.IPlantable;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.DesolateSoilEntityWalksOnBlockProcedure;

public class DesolateBrickStairsBlock extends StairBlock {
	public DesolateBrickStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.SOUL_SOIL).strength(1.5f));
	}

	@Override
	public float getExplosionResistance() {
		return 1.5f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
		return true;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		DesolateSoilEntityWalksOnBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
