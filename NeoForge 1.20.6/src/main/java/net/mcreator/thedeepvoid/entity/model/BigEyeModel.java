package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BigEyeEntity;

public class BigEyeModel extends GeoModel<BigEyeEntity> {
	@Override
	public ResourceLocation getAnimationResource(BigEyeEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/bigeye.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BigEyeEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/bigeye.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BigEyeEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BigEyeEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
