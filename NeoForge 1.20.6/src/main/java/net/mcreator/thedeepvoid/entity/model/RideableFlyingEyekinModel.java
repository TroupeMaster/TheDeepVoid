package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.RideableFlyingEyekinEntity;

public class RideableFlyingEyekinModel extends GeoModel<RideableFlyingEyekinEntity> {
	@Override
	public ResourceLocation getAnimationResource(RideableFlyingEyekinEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/eye.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RideableFlyingEyekinEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/eye.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RideableFlyingEyekinEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(RideableFlyingEyekinEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
