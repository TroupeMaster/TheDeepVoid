package net.mcreator.thedeepvoid.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.thedeepvoid.world.inventory.UndertakerTradeGuiMenu;
import net.mcreator.thedeepvoid.procedures.UndertakerShowScaleProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerShowNormalScaleProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton6StockProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton6DisplayProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton5StockProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton5DisplayProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton4StockProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton4DisplayProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton3StockProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton3DisplayProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton2StockProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton2DisplayProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton1StockProcedure;
import net.mcreator.thedeepvoid.procedures.UndertakerButton1DisplayProcedure;
import net.mcreator.thedeepvoid.network.UndertakerTradeGuiButtonMessage;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class UndertakerTradeGuiScreen extends AbstractContainerScreen<UndertakerTradeGuiMenu> {
	private final static HashMap<String, Object> guistate = UndertakerTradeGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_button;
	ImageButton imagebutton_button1;
	ImageButton imagebutton_button2;
	ImageButton imagebutton_button3;
	ImageButton imagebutton_button4;
	ImageButton imagebutton_button5;

	public UndertakerTradeGuiScreen(UndertakerTradeGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 246;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("the_deep_void:textures/screens/undertaker_trade_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (UndertakerShowNormalScaleProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/scale.png"), this.leftPos + 144, this.topPos + 31, 0, 0, 28, 21, 28, 21);
		}

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/bundle_of_coins.png"), this.leftPos + 74, this.topPos + 21, 0, 0, 34, 34, 34, 34);

		guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/onyx.png"), this.leftPos + 114, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		if (UndertakerShowScaleProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/scale_deny.png"), this.leftPos + 144, this.topPos + 31, 0, 0, 28, 21, 28, 21);
		}
		if (UndertakerButton1StockProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/button_out_of_stock.png"), this.leftPos + 4, this.topPos + 18, 0, 0, 68, 20, 68, 20);
		}
		if (UndertakerButton2StockProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/button_out_of_stock.png"), this.leftPos + 4, this.topPos + 38, 0, 0, 68, 20, 68, 20);
		}
		if (UndertakerButton3StockProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/button_out_of_stock.png"), this.leftPos + 4, this.topPos + 58, 0, 0, 68, 20, 68, 20);
		}
		if (UndertakerButton4StockProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/button_out_of_stock.png"), this.leftPos + 4, this.topPos + 78, 0, 0, 68, 20, 68, 20);
		}
		if (UndertakerButton5StockProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/button_out_of_stock.png"), this.leftPos + 4, this.topPos + 98, 0, 0, 68, 20, 68, 20);
		}
		if (UndertakerButton6StockProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("the_deep_void:textures/screens/button_out_of_stock.png"), this.leftPos + 4, this.topPos + 118, 0, 0, 68, 20, 68, 20);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.the_deep_void.undertaker_trade_gui.label_trades"), 22, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_deep_void.undertaker_trade_gui.label_undertaker"), 132, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button = new ImageButton(this.leftPos + 4, this.topPos + 18, 68, 20, 0, 0, 20, new ResourceLocation("the_deep_void:textures/screens/atlas/imagebutton_button.png"), 68, 40, e -> {
			if (UndertakerButton1DisplayProcedure.execute(entity)) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new UndertakerTradeGuiButtonMessage(0, x, y, z));
				UndertakerTradeGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (UndertakerButton1DisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button", imagebutton_button);
		this.addRenderableWidget(imagebutton_button);
		imagebutton_button1 = new ImageButton(this.leftPos + 4, this.topPos + 38, 68, 20, 0, 0, 20, new ResourceLocation("the_deep_void:textures/screens/atlas/imagebutton_button1.png"), 68, 40, e -> {
			if (UndertakerButton2DisplayProcedure.execute(entity)) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new UndertakerTradeGuiButtonMessage(1, x, y, z));
				UndertakerTradeGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (UndertakerButton2DisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button1", imagebutton_button1);
		this.addRenderableWidget(imagebutton_button1);
		imagebutton_button2 = new ImageButton(this.leftPos + 4, this.topPos + 58, 68, 20, 0, 0, 20, new ResourceLocation("the_deep_void:textures/screens/atlas/imagebutton_button2.png"), 68, 40, e -> {
			if (UndertakerButton3DisplayProcedure.execute(entity)) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new UndertakerTradeGuiButtonMessage(2, x, y, z));
				UndertakerTradeGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (UndertakerButton3DisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button2", imagebutton_button2);
		this.addRenderableWidget(imagebutton_button2);
		imagebutton_button3 = new ImageButton(this.leftPos + 4, this.topPos + 78, 68, 20, 0, 0, 20, new ResourceLocation("the_deep_void:textures/screens/atlas/imagebutton_button3.png"), 68, 40, e -> {
			if (UndertakerButton4DisplayProcedure.execute(entity)) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new UndertakerTradeGuiButtonMessage(3, x, y, z));
				UndertakerTradeGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (UndertakerButton4DisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button3", imagebutton_button3);
		this.addRenderableWidget(imagebutton_button3);
		imagebutton_button4 = new ImageButton(this.leftPos + 4, this.topPos + 98, 68, 20, 0, 0, 20, new ResourceLocation("the_deep_void:textures/screens/atlas/imagebutton_button4.png"), 68, 40, e -> {
			if (UndertakerButton5DisplayProcedure.execute(entity)) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new UndertakerTradeGuiButtonMessage(4, x, y, z));
				UndertakerTradeGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (UndertakerButton5DisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button4", imagebutton_button4);
		this.addRenderableWidget(imagebutton_button4);
		imagebutton_button5 = new ImageButton(this.leftPos + 4, this.topPos + 118, 68, 20, 0, 0, 20, new ResourceLocation("the_deep_void:textures/screens/atlas/imagebutton_button5.png"), 68, 40, e -> {
			if (UndertakerButton6DisplayProcedure.execute(entity)) {
				TheDeepVoidMod.PACKET_HANDLER.sendToServer(new UndertakerTradeGuiButtonMessage(5, x, y, z));
				UndertakerTradeGuiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (UndertakerButton6DisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button5", imagebutton_button5);
		this.addRenderableWidget(imagebutton_button5);
	}
}
