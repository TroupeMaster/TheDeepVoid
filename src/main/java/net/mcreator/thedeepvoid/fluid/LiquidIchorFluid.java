
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

import net.mcreator.thedeepvoid.procedures.LiquidIchorCheckBelowProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluids;
import net.mcreator.thedeepvoid.init.TheDeepVoidModFluidTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public abstract class LiquidIchorFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TheDeepVoidModFluidTypes.LIQUID_ICHOR_TYPE.get(), () -> TheDeepVoidModFluids.LIQUID_ICHOR.get(),
			() -> TheDeepVoidModFluids.FLOWING_LIQUID_ICHOR.get()).explosionResistance(100f).tickRate(7).levelDecreasePerBlock(2).slopeFindDistance(2).bucket(() -> TheDeepVoidModItems.LIQUID_ICHOR_BUCKET.get())
			.block(() -> (LiquidBlock) TheDeepVoidModBlocks.LIQUID_ICHOR.get());

	private LiquidIchorFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (TheDeepVoidModParticleTypes.AMBROSIA_DROPLET.get());
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState blockstate) {
		LiquidIchorCheckBelowProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static class Source extends LiquidIchorFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidIchorFluid {
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
