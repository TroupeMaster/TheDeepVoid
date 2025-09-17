package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BoneCageClosedEntity;

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
