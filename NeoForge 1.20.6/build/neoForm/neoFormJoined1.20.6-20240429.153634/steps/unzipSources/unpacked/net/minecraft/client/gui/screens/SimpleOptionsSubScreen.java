package net.minecraft.client.gui.screens;

import javax.annotation.Nullable;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class SimpleOptionsSubScreen extends OptionsSubScreen {
    protected final OptionInstance<?>[] smallOptions;
    @Nullable
    private AbstractWidget narratorButton;
    protected OptionsList list;

    public SimpleOptionsSubScreen(Screen p_232763_, Options p_232764_, Component p_232765_, OptionInstance<?>[] p_232766_) {
        super(p_232763_, p_232764_, p_232765_);
        this.smallOptions = p_232766_;
    }

    @Override
    protected void init() {
        this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
        this.list.addSmall(this.smallOptions);
        this.narratorButton = this.list.findOption(this.options.narrator());
        if (this.narratorButton != null) {
            this.narratorButton.active = this.minecraft.getNarrator().isActive();
        }

        super.init();
    }

    @Override
    protected void repositionElements() {
        super.repositionElements();
        this.list.updateSize(this.width, this.layout);
    }

    public void updateNarratorButton() {
        if (this.narratorButton instanceof CycleButton) {
            ((CycleButton)this.narratorButton).setValue(this.options.narrator().get());
        }
    }
}
