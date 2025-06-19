package net.minecraft.client.gui.screens;

import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OptionsSubScreen extends Screen {
    protected final Screen lastScreen;
    protected final Options options;
    public final HeaderAndFooterLayout layout = new HeaderAndFooterLayout(this);

    public OptionsSubScreen(Screen p_96284_, Options p_96285_, Component p_96286_) {
        super(p_96286_);
        this.lastScreen = p_96284_;
        this.options = p_96285_;
    }

    @Override
    protected void init() {
        this.addTitle();
        this.addFooter();
        this.layout.visitWidgets(this::addRenderableWidget);
        this.repositionElements();
    }

    protected void addTitle() {
        this.layout.addTitleHeader(this.title, this.font);
    }

    protected void addFooter() {
        this.layout.addToFooter(Button.builder(CommonComponents.GUI_DONE, p_331746_ -> this.onClose()).width(200).build());
    }

    @Override
    protected void repositionElements() {
        this.layout.arrangeElements();
    }

    @Override
    public void removed() {
        this.minecraft.options.save();
    }

    @Override
    public void onClose() {
        for (GuiEventListener guieventlistener : this.children()) {
            if (guieventlistener instanceof OptionsList optionslist) {
                optionslist.applyUnsavedChanges();
            }
        }

        this.minecraft.setScreen(this.lastScreen);
    }
}
