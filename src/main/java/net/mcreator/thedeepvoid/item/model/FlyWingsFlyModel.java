package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.FlyWingsFlyItem;

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
