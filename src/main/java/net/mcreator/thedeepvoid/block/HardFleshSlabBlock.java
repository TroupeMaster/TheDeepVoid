
package net.mcreator.thedeepvoid.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.FleshBlockEntityWalksOnTheBlockProcedure;

public class HardFleshSlabBlock extends SlabBlock {
	public HardFleshSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.PACKED_MUD).strength(10f, 8f).friction(0.7f));
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		FleshBlockEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
