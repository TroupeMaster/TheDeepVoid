
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class TheDeepVoidModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("the_deep_void:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		ingredientStack.add(new ItemStack(TheDeepVoidModItems.ROTFISH.get()));
		PotionUtils.setPotion(potion, Potions.POISON);
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.ROT_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.GHAST_TEAR));
		inputStack.add(new ItemStack(TheDeepVoidModItems.ABSORPTION_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.REGENERATION_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.GOLD_INGOT));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.ABSORPTION_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.IRON_INGOT));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.RESISTANCE_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.GLOWSTONE_DUST));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.GLOWING_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.RABBIT));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.JUMP_BOOST_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(TheDeepVoidModItems.ROTTEN_BONE.get()));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.ROT_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Blocks.SOUL_SAND));
		inputStack.add(new ItemStack(TheDeepVoidModItems.POISON_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.HEXED_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.MAGMA_CREAM));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.FIRE_RESISTANCE_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.SPIDER_EYE));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.POISON_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.SUGAR));
		inputStack.add(new ItemStack(TheDeepVoidModItems.BONE_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.SPEED_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(TheDeepVoidModItems.CINNABAR.get()));
		inputStack.add(new ItemStack(TheDeepVoidModItems.ABSORPTION_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.HEALTH_BOOST_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(TheDeepVoidModItems.ROTTEN_BONE.get()));
		inputStack.add(new ItemStack(TheDeepVoidModItems.POISON_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.WITHER_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.GOLDEN_APPLE));
		inputStack.add(new ItemStack(TheDeepVoidModItems.REGENERATION_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.SATURATION_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(TheDeepVoidModBlocks.BLOCK_OF_MISTED_BONE_PILE.get()));
		PotionUtils.setPotion(potion, Potions.INVISIBILITY);
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.VANISHMENT.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.REDSTONE));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.VANISHMENT.get());
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.LONG_VANISHMENT.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.GLOWSTONE_DUST));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.VANISHMENT.get());
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.ENHANCED_VANISHMENT.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.FERMENTED_SPIDER_EYE));
		inputStack.add(new ItemStack(TheDeepVoidModItems.REGENERATION_NEEDLE.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(TheDeepVoidModItems.INSTANT_DAMAGE_NEEDLE.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(TheDeepVoidModItems.VOIDFISH.get()));
		PotionUtils.setPotion(potion, Potions.WATER);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), new ItemStack(TheDeepVoidModItems.FISHY_POTION.get())));
		ingredientStack.clear();
		ingredientStack = new ArrayList<ItemStack>(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:crate"))).stream().map(item -> new ItemStack((Item) item)).collect(Collectors.toCollection(ArrayList::new)));
		inputStack.add(new ItemStack(TheDeepVoidModItems.FISHY_POTION.get()));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.CRATE_MAGNET_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(Items.REDSTONE));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.CRATE_MAGNET_POTION.get());
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.EXTENDED_CRATE_MAGNET.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.GLOWSTONE_DUST));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.CRATE_MAGNET_POTION.get());
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.AMPLIFIED_CRATE_MAGNET.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack = new ArrayList<ItemStack>(
				ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:fished_up_creature"))).stream().map(item -> new ItemStack((Item) item)).collect(Collectors.toCollection(ArrayList::new)));
		inputStack.add(new ItemStack(TheDeepVoidModItems.FISHY_POTION.get()));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.CREATURE_REPELLENT_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(Items.REDSTONE));
		PotionUtils.setPotion(potion, TheDeepVoidModPotions.CREATURE_REPELLENT_POTION.get());
		PotionUtils.setPotion(potion2, TheDeepVoidModPotions.EXTENDED_CREATURE_REPELLENT_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}
