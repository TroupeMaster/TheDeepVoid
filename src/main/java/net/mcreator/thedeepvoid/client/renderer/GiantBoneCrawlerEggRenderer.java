
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thedeepvoid.entity.GiantBoneCrawlerEggEntity;
import net.mcreator.thedeepvoid.client.model.Modelgiant_crawler_egg;

public class GiantBoneCrawlerEggRenderer extends MobRenderer<GiantBoneCrawlerEggEntity, Modelgiant_crawler_egg<GiantBoneCrawlerEggEntity>> {
	public GiantBoneCrawlerEggRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgiant_crawler_egg(context.bakeLayer(Modelgiant_crawler_egg.LAYER_LOCATION)), 2.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantBoneCrawlerEggEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/giant_crawler_egg.png");
	}
}
