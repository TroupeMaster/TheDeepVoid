package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.SoulWingsItem;

public class SoulWingsModel extends GeoModel<SoulWingsItem> {
	@Override
	public ResourceLocation getAnimationResource(SoulWingsItem object) {
		return new ResourceLocation("the_deep_void", "animations/soulwings.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulWingsItem object) {
		return new ResourceLocation("the_deep_void", "geo/soulwings.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulWingsItem object) {
		return new ResourceLocation("the_deep_void", "textures/item/soul_wings.png");
	}
}
