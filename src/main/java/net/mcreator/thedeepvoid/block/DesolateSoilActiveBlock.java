
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.common.IPlantable;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.DesolateSoilEntityWalksOnBlockProcedure;
import net.mcreator.thedeepvoid.procedures.DesolateSoilActiveOnTickUpdateProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class DesolateSoilActiveBlock extends Block {
	public DesolateSoilActiveBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SOUL_SOIL).strength(1.5f).randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(TheDeepVoidModBlocks.DESOLATE_SOIL.get());
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
		return true;
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		DesolateSoilActiveOnTickUpdateProcedure.execute(world, x, y, z);
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		DesolateSoilEntityWalksOnBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
