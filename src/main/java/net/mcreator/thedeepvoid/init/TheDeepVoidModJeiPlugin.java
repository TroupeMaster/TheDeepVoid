
package net.mcreator.thedeepvoid.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.jei_recipes.TreasureBagJeiTypeRecipeCategory;
import net.mcreator.thedeepvoid.jei_recipes.TreasureBagJeiTypeRecipe;
import net.mcreator.thedeepvoid.jei_recipes.SoulForgeJEITypeRecipeCategory;
import net.mcreator.thedeepvoid.jei_recipes.SoulForgeJEITypeRecipe;
import net.mcreator.thedeepvoid.jei_recipes.GluttonBlockJEITypeRecipeCategory;
import net.mcreator.thedeepvoid.jei_recipes.GluttonBlockJEITypeRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class TheDeepVoidModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<GluttonBlockJEITypeRecipe> GluttonBlockJEIType_Type = new mezz.jei.api.recipe.RecipeType<>(GluttonBlockJEITypeRecipeCategory.UID, GluttonBlockJEITypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<SoulForgeJEITypeRecipe> SoulForgeJEIType_Type = new mezz.jei.api.recipe.RecipeType<>(SoulForgeJEITypeRecipeCategory.UID, SoulForgeJEITypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<TreasureBagJeiTypeRecipe> TreasureBagJeiType_Type = new mezz.jei.api.recipe.RecipeType<>(TreasureBagJeiTypeRecipeCategory.UID, TreasureBagJeiTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("the_deep_void:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new GluttonBlockJEITypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new SoulForgeJEITypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new TreasureBagJeiTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<GluttonBlockJEITypeRecipe> GluttonBlockJEITypeRecipes = recipeManager.getAllRecipesFor(GluttonBlockJEITypeRecipe.Type.INSTANCE);
		registration.addRecipes(GluttonBlockJEIType_Type, GluttonBlockJEITypeRecipes);
		List<SoulForgeJEITypeRecipe> SoulForgeJEITypeRecipes = recipeManager.getAllRecipesFor(SoulForgeJEITypeRecipe.Type.INSTANCE);
		registration.addRecipes(SoulForgeJEIType_Type, SoulForgeJEITypeRecipes);
		List<TreasureBagJeiTypeRecipe> TreasureBagJeiTypeRecipes = recipeManager.getAllRecipesFor(TreasureBagJeiTypeRecipe.Type.INSTANCE);
		registration.addRecipes(TreasureBagJeiType_Type, TreasureBagJeiTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(TheDeepVoidModBlocks.GLUTTON_BLOCK.get().asItem()), GluttonBlockJEIType_Type);
		registration.addRecipeCatalyst(new ItemStack(TheDeepVoidModBlocks.SOUL_FORGE.get().asItem()), SoulForgeJEIType_Type);
	}
}
