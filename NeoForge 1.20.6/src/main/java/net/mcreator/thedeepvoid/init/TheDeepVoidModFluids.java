
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.thedeepvoid.fluid.LiquidVoidFluid;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, TheDeepVoidMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> LIQUID_VOID = REGISTRY.register("liquid_void", () -> new LiquidVoidFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIQUID_VOID = REGISTRY.register("flowing_liquid_void", () -> new LiquidVoidFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(LIQUID_VOID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_VOID.get(), RenderType.translucent());
		}
	}
}
