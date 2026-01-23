package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;

public class PrimordialBoneCrawlerModel extends GeoModel<PrimordialBoneCrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrimordialBoneCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/primordial_crawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrimordialBoneCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/primordial_crawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrimordialBoneCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
