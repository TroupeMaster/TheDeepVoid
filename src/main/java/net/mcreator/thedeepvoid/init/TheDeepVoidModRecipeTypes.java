package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.thedeepvoid.jei_recipes.TreasureBagJeiTypeRecipe;
import net.mcreator.thedeepvoid.jei_recipes.SoulForgeJEITypeRecipe;
import net.mcreator.thedeepvoid.jei_recipes.GluttonBlockJEITypeRecipe;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@Mod.EventBusSubscriber(modid = TheDeepVoidMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheDeepVoidModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "the_deep_void");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("glutton_block_jei_type", () -> GluttonBlockJEITypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("soul_forge_jei_type", () -> SoulForgeJEITypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("treasure_bag_jei_type", () -> TreasureBagJeiTypeRecipe.Serializer.INSTANCE);
		});
	}
}
