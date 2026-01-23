package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BabyBoneCrawlerEntity;

public class BabyBoneCrawlerModel extends GeoModel<BabyBoneCrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BabyBoneCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/babycrawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BabyBoneCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/babycrawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BabyBoneCrawlerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BabyBoneCrawlerEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
