package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SleepingPrimordialCrawlerEntity;

public class SleepingPrimordialCrawlerModel extends GeoModel<SleepingPrimordialCrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(SleepingPrimordialCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/primordial_crawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SleepingPrimordialCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/primordial_crawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SleepingPrimordialCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
