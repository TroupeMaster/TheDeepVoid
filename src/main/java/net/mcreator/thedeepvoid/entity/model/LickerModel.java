package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.LickerEntity;

public class LickerModel extends GeoModel<LickerEntity> {
	@Override
	public ResourceLocation getAnimationResource(LickerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/lickerremodel.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LickerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/lickerremodel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LickerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
