
package net.sombrius.thedeepvoid.client.renderer;

import net.sombrius.thedeepvoid.entity.FallingCorpseEntity;
import net.sombrius.thedeepvoid.client.model.Modelfalling_corpse;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class FallingCorpseRenderer extends MobRenderer<FallingCorpseEntity, Modelfalling_corpse<FallingCorpseEntity>> {
	public FallingCorpseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfalling_corpse(context.bakeLayer(Modelfalling_corpse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FallingCorpseEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/falling_corpse_texture.png");
	}
}
