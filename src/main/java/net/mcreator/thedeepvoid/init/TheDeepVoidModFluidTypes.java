
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.thedeepvoid.fluid.types.LiquidVoidFluidType;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TheDeepVoidMod.MODID);
	public static final RegistryObject<FluidType> LIQUID_VOID_TYPE = REGISTRY.register("liquid_void", () -> new LiquidVoidFluidType());
}
