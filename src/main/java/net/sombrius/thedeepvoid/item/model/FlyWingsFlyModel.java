package net.sombrius.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.item.FlyWingsFlyItem;

import net.minecraft.resources.ResourceLocation;

public class FlyWingsFlyModel extends GeoModel<FlyWingsFlyItem> {
	@Override
	public ResourceLocation getAnimationResource(FlyWingsFlyItem object) {
		return new ResourceLocation("the_deep_void", "animations/flywings.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlyWingsFlyItem object) {
		return new ResourceLocation("the_deep_void", "geo/flywings.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlyWingsFlyItem object) {
		return new ResourceLocation("the_deep_void", "textures/item/flywings.png");
	}
}
