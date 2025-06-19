package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.NightmareEntity;

public class NightmareModel extends GeoModel<NightmareEntity> {
	@Override
	public ResourceLocation getAnimationResource(NightmareEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/nightmare.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NightmareEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/nightmare.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NightmareEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
