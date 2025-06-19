
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thedeepvoid.entity.BlindProphetEntity;
import net.mcreator.thedeepvoid.client.model.Modelblind_prophet;

public class BlindProphetRenderer extends MobRenderer<BlindProphetEntity, Modelblind_prophet<BlindProphetEntity>> {
	public BlindProphetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblind_prophet(context.bakeLayer(Modelblind_prophet.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlindProphetEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/blind_prophet.png");
	}
}
