
package net.mcreator.thedeepvoid.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModJeiPlugin;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class SoulForgeJEITypeRecipeCategory implements IRecipeCategory<SoulForgeJEITypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("the_deep_void", "soul_forge_jei_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("the_deep_void", "textures/screens/soul_forge_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public SoulForgeJEITypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 85);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(TheDeepVoidModBlocks.SOUL_FORGE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<SoulForgeJEITypeRecipe> getRecipeType() {
		return TheDeepVoidModJeiPlugin.SoulForgeJEIType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Soul Forging");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, SoulForgeJEITypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 44).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 70, 44).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 44).addItemStack(recipe.getResultItem(null));
	}
}
