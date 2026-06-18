package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;

public class MisanthropicHivemindModel extends GeoModel<MisanthropicHivemindEntity> {
	@Override
	public ResourceLocation getAnimationResource(MisanthropicHivemindEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/hivemindrework.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MisanthropicHivemindEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/hivemindrework.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MisanthropicHivemindEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
