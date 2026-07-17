
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.LiquidVoidOnTickUpdateProcedure;
import net.mcreator.thedeepvoid.procedures.LiquidVoidBeforeReplacingABlockProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluids;

public class LiquidVoidBlock extends LiquidBlock {
	public LiquidVoidBlock() {
		super(() -> TheDeepVoidModFluids.LIQUID_VOID.get(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		LiquidVoidBeforeReplacingABlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
		super.animateTick(blockstate, world, pos, random);
		LiquidVoidOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
