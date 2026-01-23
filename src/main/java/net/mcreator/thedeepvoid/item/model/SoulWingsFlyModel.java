package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.SoulWingsFlyItem;

public class SoulWingsFlyModel extends GeoModel<SoulWingsFlyItem> {
	@Override
	public ResourceLocation getAnimationResource(SoulWingsFlyItem object) {
		return new ResourceLocation("the_deep_void", "animations/soulwings.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulWingsFlyItem object) {
		return new ResourceLocation("the_deep_void", "geo/soulwings.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulWingsFlyItem object) {
		return new ResourceLocation("the_deep_void", "textures/item/soul_wings.png");
	}
}
