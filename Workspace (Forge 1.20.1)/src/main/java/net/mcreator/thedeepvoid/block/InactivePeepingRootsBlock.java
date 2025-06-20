
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.common.PlantType;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.InactivePeepingRootsTickUpdateProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class InactivePeepingRootsBlock extends FlowerBlock {
	public InactivePeepingRootsBlock() {
		super(() -> MobEffects.MOVEMENT_SPEED, 100,
				BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().sound(SoundType.BASALT).strength(1.5f, 1f).noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(TheDeepVoidModBlocks.PEEPING_ROOTS.get());
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get()) || groundState.is(TheDeepVoidModBlocks.ROTTEN_LOG.get()) || groundState.is(TheDeepVoidModBlocks.INFESTED_ROTTEN_LOG.get())
				|| groundState.is(TheDeepVoidModBlocks.COBBLED_ANCIENT_DEEPSLATE.get()) || groundState.is(TheDeepVoidModBlocks.ANCIENT_DEEPSLATE.get()) || groundState.is(Blocks.DEEPSLATE) || groundState.is(Blocks.COBBLED_DEEPSLATE)
				|| groundState.is(TheDeepVoidModBlocks.ROTTEN_WOOD.get()) || groundState.is(TheDeepVoidModBlocks.ROTTEN_MOSS.get()) || groundState.is(TheDeepVoidModBlocks.MOSSY_BONE_PILE.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CAVE;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		InactivePeepingRootsTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
