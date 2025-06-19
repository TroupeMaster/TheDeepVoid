package net.minecraft.client.gui.screens;

import java.util.Arrays;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SoundOptionsScreen extends OptionsSubScreen {
    private static final Component TITLE = Component.translatable("options.sounds.title");
    private OptionsList list;

    private static OptionInstance<?>[] buttonOptions(Options p_250217_) {
        return new OptionInstance[]{p_250217_.showSubtitles(), p_250217_.directionalAudio()};
    }

    public SoundOptionsScreen(Screen p_96702_, Options p_96703_) {
        super(p_96702_, p_96703_, TITLE);
    }

    @Override
    protected void init() {
        this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
        this.list.addBig(this.options.getSoundSourceOptionInstance(SoundSource.MASTER));
        this.list.addSmall(this.getAllSoundOptionsExceptMaster());
        this.list.addBig(this.options.soundDevice());
        this.list.addSmall(buttonOptions(this.options));
        super.init();
    }

    @Override
    protected void repositionElements() {
        super.repositionElements();
        this.list.updateSize(this.width, this.layout);
    }

    private OptionInstance<?>[] getAllSoundOptionsExceptMaster() {
        return Arrays.stream(SoundSource.values())
            .filter(p_247780_ -> p_247780_ != SoundSource.MASTER)
            .map(p_247779_ -> this.options.getSoundSourceOptionInstance(p_247779_))
            .toArray(OptionInstance[]::new);
    }
}
