package net.minecraft.client.gui.screens;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AccessibilityOptionsScreen extends SimpleOptionsSubScreen {
    public static final Component TITLE = Component.translatable("options.accessibility.title");

    private static OptionInstance<?>[] options(Options p_232691_) {
        return new OptionInstance[]{
            p_232691_.narrator(),
            p_232691_.showSubtitles(),
            p_232691_.highContrast(),
            p_232691_.autoJump(),
            p_232691_.menuBackgroundBlurriness(),
            p_232691_.textBackgroundOpacity(),
            p_232691_.backgroundForChatOnly(),
            p_232691_.chatOpacity(),
            p_232691_.chatLineSpacing(),
            p_232691_.chatDelay(),
            p_232691_.notificationDisplayTime(),
            p_232691_.toggleCrouch(),
            p_232691_.toggleSprint(),
            p_232691_.screenEffectScale(),
            p_232691_.fovEffectScale(),
            p_232691_.darknessEffectScale(),
            p_232691_.damageTiltStrength(),
            p_232691_.glintSpeed(),
            p_232691_.glintStrength(),
            p_232691_.hideLightningFlash(),
            p_232691_.darkMojangStudiosBackground(),
            p_232691_.panoramaSpeed(),
            p_232691_.hideSplashTexts(),
            p_232691_.narratorHotkey()
        };
    }

    public AccessibilityOptionsScreen(Screen p_95504_, Options p_95505_) {
        super(p_95504_, p_95505_, TITLE, options(p_95505_));
    }

    @Override
    protected void init() {
        super.init();
        AbstractWidget abstractwidget = this.list.findOption(this.options.highContrast());
        if (abstractwidget != null && !this.minecraft.getResourcePackRepository().getAvailableIds().contains("high_contrast")) {
            abstractwidget.active = false;
            abstractwidget.setTooltip(Tooltip.create(Component.translatable("options.accessibility.high_contrast.error.tooltip")));
        }
    }

    @Override
    protected void addFooter() {
        LinearLayout linearlayout = this.layout.addToFooter(LinearLayout.horizontal().spacing(8));
        linearlayout.addChild(
            Button.builder(
                    Component.translatable("options.accessibility.link"), ConfirmLinkScreen.confirmLink(this, "https://aka.ms/MinecraftJavaAccessibility")
                )
                .build()
        );
        linearlayout.addChild(Button.builder(CommonComponents.GUI_DONE, p_280785_ -> this.minecraft.setScreen(this.lastScreen)).build());
    }
}
