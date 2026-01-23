package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BigSmokeVentCornerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, (x + 1 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (y + 0.8), (z + 1 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 8, 0, 0.2, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, (x + 1 + Mth.nextDouble(RandomSource.create(), -1, 1)), (y + 0.8), (z + 1 + Mth.nextDouble(RandomSource.create(), -1, 1)), 8, 0, 0.1, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 1 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (y + 0.8), (z + 1 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 6, 0, 0.2, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (x + 1 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (y + 0.8), (z + 1 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 6, 0, 0.2, 0, 0.1);
			}
		}
	}
}
