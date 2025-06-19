package net.mcreator.thedeepvoid.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.thedeepvoid.world.inventory.SoulForgeGUIMenu;
import net.mcreator.thedeepvoid.procedures.Tooltip2SoulForgeProcedure;
import net.mcreator.thedeepvoid.procedures.Tooltip1SoulForgeProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SoulForgeGUIScreen extends AbstractContainerScreen<SoulForgeGUIMenu> {
	private final static HashMap<String, Object> guistate = SoulForgeGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SoulForgeGUIScreen(SoulForgeGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("the_deep_void:textures/screens/soul_forge_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (Tooltip1SoulForgeProcedure.execute(entity))
			if (mouseX > leftPos + 20 && mouseX < leftPos + 44 && mouseY > topPos + 39 && mouseY < topPos + 63)
				guiGraphics.renderTooltip(font, Component.translatable("gui.the_deep_void.soul_forge_gui.tooltip_put_a_soul_shard_here"), mouseX, mouseY);
		if (Tooltip2SoulForgeProcedure.execute(entity))
			if (mouseX > leftPos + 65 && mouseX < leftPos + 89 && mouseY > topPos + 39 && mouseY < topPos + 63)
				guiGraphics.renderTooltip(font, Component.translatable("gui.the_deep_void.soul_forge_gui.tooltip_put_a_netherite_ingot_here"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/plus.png"), this.leftPos + 49, this.topPos + 45, 0, 0, 13, 13, 13, 13);

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/arrow.png"), this.leftPos + 93, this.topPos + 40, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/soul_hammer.png"), this.leftPos + 15, this.topPos + 7, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/soul_shard_icon.png"), this.leftPos + 25, this.topPos + 44, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/netherite_ingot_icon.png"), this.leftPos + 70, this.topPos + 44, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
	}
}
