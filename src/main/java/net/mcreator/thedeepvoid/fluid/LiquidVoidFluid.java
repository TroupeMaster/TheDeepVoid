
package net.mcreator.thedeepvoid.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.procedures.LiquidVoidCheckBelowProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluids;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluidTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public abstract class LiquidVoidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TheDeepVoidModFluidTypes.LIQUID_VOID_TYPE.get(), () -> TheDeepVoidModFluids.LIQUID_VOID.get(),
			() -> TheDeepVoidModFluids.FLOWING_LIQUID_VOID.get()).explosionResistance(100f).tickRate(2).bucket(() -> TheDeepVoidModItems.LIQUID_VOID_BUCKET.get()).block(() -> (LiquidBlock) TheDeepVoidModBlocks.LIQUID_VOID.get());

	private LiquidVoidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get());
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState blockstate) {
		LiquidVoidCheckBelowProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static class Source extends LiquidVoidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidVoidFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
