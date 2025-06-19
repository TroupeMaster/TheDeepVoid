
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thedeepvoid.entity.FallingCorpseEntity;
import net.mcreator.thedeepvoid.client.model.Modelfalling_corpse;

public class FallingCorpseRenderer extends MobRenderer<FallingCorpseEntity, Modelfalling_corpse<FallingCorpseEntity>> {
	public FallingCorpseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfalling_corpse(context.bakeLayer(Modelfalling_corpse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FallingCorpseEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/falling_corpse_texture.png");
	}
}
