
package net.sombrius.thedeepvoid.client.renderer;

import net.sombrius.thedeepvoid.entity.GiantBoneCrawlerEggEntity;
import net.sombrius.thedeepvoid.client.model.Modelgiant_crawler_egg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GiantBoneCrawlerEggRenderer extends MobRenderer<GiantBoneCrawlerEggEntity, Modelgiant_crawler_egg<GiantBoneCrawlerEggEntity>> {
	public GiantBoneCrawlerEggRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgiant_crawler_egg(context.bakeLayer(Modelgiant_crawler_egg.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantBoneCrawlerEggEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/giant_crawler_egg.png");
	}
}
