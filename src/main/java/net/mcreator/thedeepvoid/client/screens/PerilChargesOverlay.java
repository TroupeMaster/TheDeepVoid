
package net.mcreator.thedeepvoid.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.procedures.PerilShowSkull5Procedure;
import net.mcreator.thedeepvoid.procedures.PerilShowSkull4Procedure;
import net.mcreator.thedeepvoid.procedures.PerilShowSkull3Procedure;
import net.mcreator.thedeepvoid.procedures.PerilShowSkull2Procedure;
import net.mcreator.thedeepvoid.procedures.PerilShowSkull1Procedure;
import net.mcreator.thedeepvoid.procedures.PerilChargesDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PerilChargesOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (PerilChargesDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_skull_empty.png"), w / 2 + -25, h / 2 + 16, 0, 0, 9, 9, 9, 9);

			event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_skull_empty.png"), w / 2 + -15, h / 2 + 16, 0, 0, 9, 9, 9, 9);

			event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_skull_empty.png"), w / 2 + -5, h / 2 + 16, 0, 0, 9, 9, 9, 9);

			event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_skull_empty.png"), w / 2 + 5, h / 2 + 16, 0, 0, 9, 9, 9, 9);

			event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_skull_empty.png"), w / 2 + 15, h / 2 + 16, 0, 0, 9, 9, 9, 9);

			if (PerilShowSkull1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_full_skull.png"), w / 2 + -25, h / 2 + 16, 0, 0, 9, 9, 9, 9);
			}
			if (PerilShowSkull2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_full_skull.png"), w / 2 + -15, h / 2 + 16, 0, 0, 9, 9, 9, 9);
			}
			if (PerilShowSkull3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_full_skull.png"), w / 2 + -5, h / 2 + 16, 0, 0, 9, 9, 9, 9);
			}
			if (PerilShowSkull4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_full_skull.png"), w / 2 + 5, h / 2 + 16, 0, 0, 9, 9, 9, 9);
			}
			if (PerilShowSkull5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_deep_void:textures/screens/peril_full_skull.png"), w / 2 + 15, h / 2 + 16, 0, 0, 9, 9, 9, 9);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
