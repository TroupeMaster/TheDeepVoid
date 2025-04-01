package net.mcreator.thedeepvoid.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@Mod.EventBusSubscriber(modid = TheDeepVoidMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeepVoidConfigConfiguration.SPEC, "Deep Void Config.toml");
		});
	}
}
