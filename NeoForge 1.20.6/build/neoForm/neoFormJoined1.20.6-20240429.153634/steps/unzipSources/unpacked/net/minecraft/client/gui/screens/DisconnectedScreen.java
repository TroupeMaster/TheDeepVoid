package net.minecraft.client.gui.screens;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.MultiLineTextWidget;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DisconnectedScreen extends Screen {
    private static final Component TO_SERVER_LIST = Component.translatable("gui.toMenu");
    private static final Component TO_TITLE = Component.translatable("gui.toTitle");
    private final Screen parent;
    private final Component reason;
    private final Component buttonText;
    private final LinearLayout layout = LinearLayout.vertical();

    public DisconnectedScreen(Screen p_95993_, Component p_95994_, Component p_95995_) {
        this(p_95993_, p_95994_, p_95995_, TO_SERVER_LIST);
    }

    public DisconnectedScreen(Screen p_279153_, Component p_279183_, Component p_279332_, Component p_279257_) {
        super(p_279183_);
        this.parent = p_279153_;
        this.reason = p_279332_;
        this.buttonText = p_279257_;
    }

    @Override
    protected void init() {
        this.layout.defaultCellSetting().alignHorizontallyCenter().padding(10);
        this.layout.addChild(new StringWidget(this.title, this.font));
        this.layout.addChild(new MultiLineTextWidget(this.reason, this.font).setMaxWidth(this.width - 50).setCentered(true));
        Button button;
        if (this.minecraft.allowsMultiplayer()) {
            button = Button.builder(this.buttonText, p_280799_ -> this.minecraft.setScreen(this.parent)).build();
        } else {
            button = Button.builder(TO_TITLE, p_280800_ -> this.minecraft.setScreen(new TitleScreen())).build();
        }

        this.layout.addChild(button);
        this.layout.arrangeElements();
        this.layout.visitWidgets(this::addRenderableWidget);
        this.repositionElements();
    }

    @Override
    protected void repositionElements() {
        FrameLayout.centerInRectangle(this.layout, this.getRectangle());
    }

    @Override
    public Component getNarrationMessage() {
        return CommonComponents.joinForNarration(this.title, this.reason);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
