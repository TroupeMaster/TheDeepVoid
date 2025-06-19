package net.minecraft.client.gui.screens;

import com.mojang.datafixers.util.Unit;
import com.mojang.serialization.Codec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.Optionull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OnlineOptionsScreen extends SimpleOptionsSubScreen {
    private static final Component TITLE = Component.translatable("options.online.title");
    @Nullable
    private final OptionInstance<Unit> difficultyDisplay;

    public static OnlineOptionsScreen createOnlineOptionsScreen(Minecraft p_262120_, Screen p_261548_, Options p_261609_) {
        List<OptionInstance<?>> list = new ArrayList<>();
        list.add(p_261609_.realmsNotifications());
        list.add(p_261609_.allowServerListing());
        OptionInstance<Unit> optioninstance = Optionull.map(
            p_262120_.level,
            p_340609_ -> {
                Difficulty difficulty = p_340609_.getDifficulty();
                return new OptionInstance<>(
                    "options.difficulty.online",
                    OptionInstance.noTooltip(),
                    (p_261484_, p_262113_) -> difficulty.getDisplayName(),
                    new OptionInstance.Enum<>(List.of(Unit.INSTANCE), Codec.EMPTY.codec()),
                    Unit.INSTANCE,
                    p_261717_ -> {
                    }
                );
            }
        );
        if (optioninstance != null) {
            list.add(optioninstance);
        }

        return new OnlineOptionsScreen(p_261548_, p_261609_, list.toArray(new OptionInstance[0]), optioninstance);
    }

    private OnlineOptionsScreen(Screen p_261979_, Options p_261924_, OptionInstance<?>[] p_262151_, @Nullable OptionInstance<Unit> p_261692_) {
        super(p_261979_, p_261924_, TITLE, p_262151_);
        this.difficultyDisplay = p_261692_;
    }

    @Override
    protected void init() {
        super.init();
        if (this.difficultyDisplay != null) {
            AbstractWidget abstractwidget = this.list.findOption(this.difficultyDisplay);
            if (abstractwidget != null) {
                abstractwidget.active = false;
            }
        }

        AbstractWidget abstractwidget1 = this.list.findOption(this.options.telemetryOptInExtra());
        if (abstractwidget1 != null) {
            abstractwidget1.active = this.minecraft.extraTelemetryAvailable();
        }
    }
}
