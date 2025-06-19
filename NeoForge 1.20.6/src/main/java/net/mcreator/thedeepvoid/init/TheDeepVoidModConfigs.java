package net.mcreator.thedeepvoid.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@EventBusSubscriber(modid = TheDeepVoidMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeepVoidConfigConfiguration.SPEC, "Deep Void Config.toml");
		});
	}
}
