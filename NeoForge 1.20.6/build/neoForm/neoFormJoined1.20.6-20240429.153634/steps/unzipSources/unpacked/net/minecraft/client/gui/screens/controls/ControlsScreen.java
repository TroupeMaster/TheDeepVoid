package net.minecraft.client.gui.screens.controls;

import javax.annotation.Nullable;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.MouseSettingsScreen;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ControlsScreen extends OptionsSubScreen {
    private static final Component TITLE = Component.translatable("controls.title");
    @Nullable
    private OptionsList list;

    private static OptionInstance<?>[] options(Options p_333995_) {
        return new OptionInstance[]{p_333995_.toggleCrouch(), p_333995_.toggleSprint(), p_333995_.autoJump(), p_333995_.operatorItemsTab()};
    }

    public ControlsScreen(Screen p_97519_, Options p_97520_) {
        super(p_97519_, p_97520_, TITLE);
    }

    @Override
    protected void init() {
        this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
        this.list
            .addSmall(
                Button.builder(
                        Component.translatable("options.mouse_settings"), p_280846_ -> this.minecraft.setScreen(new MouseSettingsScreen(this, this.options))
                    )
                    .build(),
                Button.builder(Component.translatable("controls.keybinds"), p_280844_ -> this.minecraft.setScreen(new KeyBindsScreen(this, this.options)))
                    .build()
            );
        this.list.addSmall(options(this.options));
        super.init();
    }

    @Override
    protected void repositionElements() {
        super.repositionElements();
        if (this.list != null) {
            this.list.updateSize(this.width, this.layout);
        }
    }
}
