
package net.mcreator.thedeepvoid.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModJeiPlugin;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class TreasureBagJeiTypeRecipeCategory implements IRecipeCategory<TreasureBagJeiTypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("the_deep_void", "treasure_bag_jei_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("the_deep_void", "textures/screens/treasure_bag_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public TreasureBagJeiTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 163, 85);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(TheDeepVoidModItems.APOSTLE_OF_CATASTROPHE_TREASURE_BAG.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<TreasureBagJeiTypeRecipe> getRecipeType() {
		return TheDeepVoidModJeiPlugin.TreasureBagJeiType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Treasure Bag");
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
	public void setRecipe(IRecipeLayoutBuilder builder, TreasureBagJeiTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 34, 35).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 114, 35).addItemStack(recipe.getResultItem(null));
	}
}
