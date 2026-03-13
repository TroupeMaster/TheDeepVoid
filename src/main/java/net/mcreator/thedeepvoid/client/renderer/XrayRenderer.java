
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thedeepvoid.entity.XrayEntity;
import net.mcreator.thedeepvoid.client.model.Modelxray;

public class XrayRenderer extends MobRenderer<XrayEntity, Modelxray<XrayEntity>> {
	public XrayRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelxray(context.bakeLayer(Modelxray.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(XrayEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/xray.png");
	}
}
