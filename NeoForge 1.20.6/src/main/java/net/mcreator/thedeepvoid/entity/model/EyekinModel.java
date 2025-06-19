package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.EyekinEntity;

public class EyekinModel extends GeoModel<EyekinEntity> {
	@Override
	public ResourceLocation getAnimationResource(EyekinEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/eye.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EyekinEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/eye.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EyekinEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(EyekinEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
