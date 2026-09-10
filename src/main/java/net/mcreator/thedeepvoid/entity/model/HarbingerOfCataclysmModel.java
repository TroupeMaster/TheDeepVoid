package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;

public class HarbingerOfCataclysmModel extends GeoModel<HarbingerOfCataclysmEntity> {
	@Override
	public ResourceLocation getAnimationResource(HarbingerOfCataclysmEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/harbinger.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HarbingerOfCataclysmEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/harbinger.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HarbingerOfCataclysmEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(HarbingerOfCataclysmEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
