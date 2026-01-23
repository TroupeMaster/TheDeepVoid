package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class BigSmokeVentNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get() && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.EAST;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z + 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.NORTH;
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x + 1, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.SOUTH;
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x + 1, y, z + 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.WEST;
				BlockPos _pos = BlockPos.containing(x + 1, y, z + 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.WEST;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z - 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.SOUTH;
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x - 1, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.NORTH;
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x - 1, y, z - 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.EAST;
				BlockPos _pos = BlockPos.containing(x - 1, y, z - 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get() && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.NORTH;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z - 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.EAST;
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x + 1, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.WEST;
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x + 1, y, z - 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.SOUTH;
				BlockPos _pos = BlockPos.containing(x + 1, y, z - 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.BIG_SMOKE_VENT.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.SOUTH;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z + 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.WEST;
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x - 1, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.EAST;
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			world.setBlock(BlockPos.containing(x - 1, y, z + 1), TheDeepVoidModBlocks.BIG_SMOKE_VENT_CORNER.get().defaultBlockState(), 3);
			{
				Direction _dir = Direction.NORTH;
				BlockPos _pos = BlockPos.containing(x - 1, y, z + 1);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		} else {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BIG_SMOKE_VENT.get().defaultBlockState(), 3);
		}
	}
}
