
package net.mcreator.thedeepvoid.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.common.PlantType;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class GoreStemsBlock extends FlowerBlock {
	public GoreStemsBlock() {
		super(MobEffects.MOVEMENT_SPEED, 100,
				BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_place")),
								() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_step")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_place")),
								() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.slime_block.hit")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:flesh_block_step"))))
						.instabreak().noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(TheDeepVoidModBlocks.FLESH_BLOCK.get()) || groundState.is(TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get()) || groundState.is(TheDeepVoidModBlocks.FLESH_BRICKS.get())
				|| groundState.is(TheDeepVoidModBlocks.PUSTULENT_FLESH_BRICKS.get()) || groundState.is(TheDeepVoidModBlocks.HARD_FLESH_BLOCK.get()) || groundState.is(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get())
				|| groundState.is(TheDeepVoidModBlocks.MOSSY_BONE_PILE.get()) || groundState.is(TheDeepVoidModBlocks.ANCIENT_DEEPSLATE.get()) || groundState.is(TheDeepVoidModBlocks.COBBLED_ANCIENT_DEEPSLATE.get())
				|| groundState.is(TheDeepVoidModBlocks.ROTTEN_MOSS.get()) || groundState.is(Blocks.DEEPSLATE) || groundState.is(Blocks.COBBLED_DEEPSLATE) || groundState.is(TheDeepVoidModBlocks.POROUS_FLESH.get());
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
}
