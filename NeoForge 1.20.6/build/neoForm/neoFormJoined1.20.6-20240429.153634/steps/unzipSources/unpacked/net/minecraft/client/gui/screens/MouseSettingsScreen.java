package net.minecraft.client.gui.screens;

import com.mojang.blaze3d.platform.InputConstants;
import java.util.Arrays;
import java.util.stream.Stream;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MouseSettingsScreen extends OptionsSubScreen {
    private static final Component TITLE = Component.translatable("options.mouse_settings.title");
    private final HeaderAndFooterLayout layout = new HeaderAndFooterLayout(this);
    private OptionsList list;

    private static OptionInstance<?>[] options(Options p_232749_) {
        return new OptionInstance[]{
            p_232749_.sensitivity(), p_232749_.invertYMouse(), p_232749_.mouseWheelSensitivity(), p_232749_.discreteMouseScroll(), p_232749_.touchscreen()
        };
    }

    public MouseSettingsScreen(Screen p_96222_, Options p_96223_) {
        super(p_96222_, p_96223_, TITLE);
    }

    @Override
    protected void init() {
        this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
        if (InputConstants.isRawMouseInputSupported()) {
            this.list.addSmall(Stream.concat(Arrays.stream(options(this.options)), Stream.of(this.options.rawMouseInput())).toArray(OptionInstance[]::new));
        } else {
            this.list.addSmall(options(this.options));
        }

        super.init();
    }

    @Override
    protected void repositionElements() {
        super.repositionElements();
        this.list.updateSize(this.width, this.layout);
    }
}
