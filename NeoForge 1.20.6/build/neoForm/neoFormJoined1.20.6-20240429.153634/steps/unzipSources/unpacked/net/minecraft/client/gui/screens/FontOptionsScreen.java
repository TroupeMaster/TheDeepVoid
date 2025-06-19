package net.minecraft.client.gui.screens;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FontOptionsScreen extends SimpleOptionsSubScreen {
    private static OptionInstance<?>[] options(Options p_326103_) {
        return new OptionInstance[]{p_326103_.forceUnicodeFont(), p_326103_.japaneseGlyphVariants()};
    }

    public FontOptionsScreen(Screen p_326401_, Options p_326424_) {
        super(p_326401_, p_326424_, Component.translatable("options.font.title"), options(p_326424_));
    }
}
