package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BoneBlockadeEntity;

public class BoneBlockadeModel extends GeoModel<BoneBlockadeEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoneBlockadeEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/boneblockade.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoneBlockadeEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/boneblockade.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoneBlockadeEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
