package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.PrimordialCrawlerEntity;

public class PrimordialCrawlerModel extends GeoModel<PrimordialCrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrimordialCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/primordialcrawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrimordialCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/primordialcrawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrimordialCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
