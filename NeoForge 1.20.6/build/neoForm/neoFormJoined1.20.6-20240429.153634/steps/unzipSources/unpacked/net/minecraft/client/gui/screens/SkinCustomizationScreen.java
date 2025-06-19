package net.minecraft.client.gui.screens;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkinCustomizationScreen extends OptionsSubScreen {
    private static final Component TITLE = Component.translatable("options.skinCustomisation.title");
    @Nullable
    private OptionsList list;

    public SkinCustomizationScreen(Screen p_96684_, Options p_96685_) {
        super(p_96684_, p_96685_, TITLE);
    }

    @Override
    protected void init() {
        this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
        List<AbstractWidget> list = new ArrayList<>();

        for (PlayerModelPart playermodelpart : PlayerModelPart.values()) {
            list.add(
                CycleButton.onOffBuilder(this.options.isModelPartEnabled(playermodelpart))
                    .create(playermodelpart.getName(), (p_169436_, p_169437_) -> this.options.toggleModelPart(playermodelpart, p_169437_))
            );
        }

        list.add(this.options.mainHand().createButton(this.options));
        this.list.addSmall(list);
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
