
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.thedeepvoid.fluid.types.LiquidVoidFluidType;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, TheDeepVoidMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> LIQUID_VOID_TYPE = REGISTRY.register("liquid_void", () -> new LiquidVoidFluidType());
}
