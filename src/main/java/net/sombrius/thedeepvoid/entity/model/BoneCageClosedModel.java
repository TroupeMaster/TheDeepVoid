package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.BoneCageClosedEntity;

import net.minecraft.resources.ResourceLocation;

public class BoneCageClosedModel extends GeoModel<BoneCageClosedEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoneCageClosedEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/bone_cage.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoneCageClosedEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/bone_cage.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoneCageClosedEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
