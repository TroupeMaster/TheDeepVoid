
package net.mcreator.thedeepvoid.block;

import net.minecraftforge.common.PlantType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.AncientPotAdditionalPlacinggrowthConditionProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class AncientUrnsGenerateBlock extends FlowerBlock {
	public AncientUrnsGenerateBlock() {
		super(() -> MobEffects.MOVEMENT_SPEED, 0,
				BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.DECORATED_POT).strength(0f, 1f).noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return Shapes.or(box(2, 0, 2, 7, 10, 7), box(8, 0, 1, 14, 12, 7), box(2, 0, 8, 9, 7, 15), box(10, 0, 8, 15, 9, 13)).move(offset.x, offset.y, offset.z);
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		boolean additionalCondition = true;
		if (worldIn instanceof LevelAccessor world) {
			int x = pos.getX();
			int y = pos.getY() + 1;
			int z = pos.getZ();
			BlockState blockstate = world.getBlockState(pos.above());
			additionalCondition = AncientPotAdditionalPlacinggrowthConditionProcedure.execute(y);
		}
		return (groundState.is(Blocks.DEEPSLATE) || groundState.is(Blocks.TUFF) || groundState.is(TheDeepVoidModBlocks.ANCIENT_DEEPSLATE.get())) && additionalCondition;
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
