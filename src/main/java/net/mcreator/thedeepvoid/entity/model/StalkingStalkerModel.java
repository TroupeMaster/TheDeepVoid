package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;

public class StalkingStalkerModel extends GeoModel<StalkingStalkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(StalkingStalkerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/stalkingstalker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StalkingStalkerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/stalkingstalker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StalkingStalkerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
