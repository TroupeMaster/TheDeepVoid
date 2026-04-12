
package net.mcreator.thedeepvoid.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class TheDeepVoidModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("the_deep_void:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModBlocks.GLUTTON_BLOCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.glutton_block_jei_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModBlocks.SOUL_FORGE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.soul_forge_jei_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModBlocks.BONE_CRAWLER_EGG.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.bone_crawler_egg_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModItems.BONE_CRAWLER_CHITIN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.bone_crawler_chitin_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.pustulent_flesh_block_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModBlocks.SOLID_AMBROSIA.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.solid_ambrosia_info"));
		registration.addIngredientInfo(
				List.of(new ItemStack(TheDeepVoidModBlocks.HEAD_OF_THE_HIVEMIND.get()), new ItemStack(TheDeepVoidModBlocks.EYE_OF_THE_HIVE_WATCHER.get()), new ItemStack(TheDeepVoidModBlocks.HEAD_OF_THE_PRIMORDIAL_CRAWLER.get()),
						new ItemStack(TheDeepVoidModBlocks.HEAD_OF_THE_APOSTLE.get()), new ItemStack(TheDeepVoidModBlocks.HEAD_OF_THE_WEAVER.get()), new ItemStack(TheDeepVoidModItems.PITCH_BLACK.get()),
						new ItemStack(TheDeepVoidModItems.MONSTERS_LAIR.get()), new ItemStack(TheDeepVoidModItems.THE_HAUNT.get()), new ItemStack(TheDeepVoidModItems.CHAINSAW.get()), new ItemStack(TheDeepVoidModItems.DARKMARE.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.boss_head_and_disc_info"));
		registration.addIngredientInfo(
				List.of(new ItemStack(TheDeepVoidModItems.MISANTHROPIC_HIVEMIND_TREASURE_BAG.get()), new ItemStack(TheDeepVoidModItems.HIVE_WATCHER_TREASURE_BAG.get()), new ItemStack(TheDeepVoidModItems.PRIMORDIAL_CRAWLER_TREASURE_BAG.get()),
						new ItemStack(TheDeepVoidModItems.APOSTLE_OF_CATASTROPHE_TREASURE_BAG.get()), new ItemStack(TheDeepVoidModItems.WEAVER_OF_SOULS_TREASURE_BAG.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.treasure_bag_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModItems.FLY_WING_PIECE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.fly_wing_piece_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModItems.BLOOD_BOW.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.blood_bow_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModItems.ROT_TONGUE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.rotten_tongue_info"));
		registration.addIngredientInfo(List.of(new ItemStack(TheDeepVoidModItems.FLESH_PARASITE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.the_deep_void.flesh_parasite_info"));
	}
}
