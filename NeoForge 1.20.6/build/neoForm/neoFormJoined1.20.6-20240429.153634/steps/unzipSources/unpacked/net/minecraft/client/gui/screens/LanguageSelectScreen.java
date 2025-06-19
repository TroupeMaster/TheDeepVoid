package net.minecraft.client.gui.screens;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.navigation.CommonInputs;
import net.minecraft.client.resources.language.LanguageInfo;
import net.minecraft.client.resources.language.LanguageManager;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LanguageSelectScreen extends OptionsSubScreen {
    private static final Component WARNING_LABEL = Component.translatable("options.languageAccuracyWarning").withStyle(ChatFormatting.GRAY);
    private static final int FOOTER_HEIGHT = 53;
    private LanguageSelectScreen.LanguageSelectionList packSelectionList;
    final LanguageManager languageManager;

    public LanguageSelectScreen(Screen p_96085_, Options p_96086_, LanguageManager p_96087_) {
        super(p_96085_, p_96086_, Component.translatable("options.language.title"));
        this.languageManager = p_96087_;
    }

    @Override
    protected void init() {
        this.packSelectionList = this.addRenderableWidget(new LanguageSelectScreen.LanguageSelectionList(this.minecraft));
        this.layout.setFooterHeight(53);
        super.init();
    }

    @Override
    protected void repositionElements() {
        super.repositionElements();
        this.packSelectionList.updateSize(this.width, this.layout);
    }

    @Override
    protected void addFooter() {
        LinearLayout linearlayout = this.layout.addToFooter(LinearLayout.vertical()).spacing(8);
        linearlayout.defaultCellSetting().alignHorizontallyCenter();
        linearlayout.addChild(new StringWidget(WARNING_LABEL, this.font));
        LinearLayout linearlayout1 = linearlayout.addChild(LinearLayout.horizontal().spacing(8));
        linearlayout1.addChild(
            Button.builder(Component.translatable("options.font"), p_325494_ -> this.minecraft.setScreen(new FontOptionsScreen(this, this.options))).build()
        );
        linearlayout1.addChild(Button.builder(CommonComponents.GUI_DONE, p_333466_ -> this.onDone()).build());
    }

    void onDone() {
        LanguageSelectScreen.LanguageSelectionList.Entry languageselectscreen$languageselectionlist$entry = this.packSelectionList.getSelected();
        if (languageselectscreen$languageselectionlist$entry != null
            && !languageselectscreen$languageselectionlist$entry.code.equals(this.languageManager.getSelected())) {
            this.languageManager.setSelected(languageselectscreen$languageselectionlist$entry.code);
            this.options.languageCode = languageselectscreen$languageselectionlist$entry.code;
            this.minecraft.reloadResourcePacks();
        }

        this.minecraft.setScreen(this.lastScreen);
    }

    @OnlyIn(Dist.CLIENT)
    class LanguageSelectionList extends ObjectSelectionList<LanguageSelectScreen.LanguageSelectionList.Entry> {
        public LanguageSelectionList(Minecraft p_96103_) {
            super(p_96103_, LanguageSelectScreen.this.width, LanguageSelectScreen.this.height - 33 - 53, 33, 18);
            String s = LanguageSelectScreen.this.languageManager.getSelected();
            LanguageSelectScreen.this.languageManager
                .getLanguages()
                .forEach(
                    (p_265492_, p_265377_) -> {
                        LanguageSelectScreen.LanguageSelectionList.Entry languageselectscreen$languageselectionlist$entry = new LanguageSelectScreen.LanguageSelectionList.Entry(
                            p_265492_, p_265377_
                        );
                        this.addEntry(languageselectscreen$languageselectionlist$entry);
                        if (s.equals(p_265492_)) {
                            this.setSelected(languageselectscreen$languageselectionlist$entry);
                        }
                    }
                );
            if (this.getSelected() != null) {
                this.centerScrollOn(this.getSelected());
            }
        }

        @Override
        public int getRowWidth() {
            return super.getRowWidth() + 50;
        }

        @OnlyIn(Dist.CLIENT)
        public class Entry extends ObjectSelectionList.Entry<LanguageSelectScreen.LanguageSelectionList.Entry> {
            final String code;
            private final Component language;
            private long lastClickTime;

            public Entry(String p_265319_, LanguageInfo p_265357_) {
                this.code = p_265319_;
                this.language = p_265357_.toComponent();
            }

            @Override
            public void render(
                GuiGraphics p_282025_,
                int p_283548_,
                int p_282485_,
                int p_282109_,
                int p_283314_,
                int p_283303_,
                int p_281337_,
                int p_283527_,
                boolean p_283295_,
                float p_282169_
            ) {
                p_282025_.drawCenteredString(LanguageSelectScreen.this.font, this.language, LanguageSelectionList.this.width / 2, p_282485_ + 1, -1);
            }

            @Override
            public boolean keyPressed(int p_333997_, int p_333994_, int p_333822_) {
                if (CommonInputs.selected(p_333997_)) {
                    this.select();
                    LanguageSelectScreen.this.onDone();
                    return true;
                } else {
                    return super.keyPressed(p_333997_, p_333994_, p_333822_);
                }
            }

            @Override
            public boolean mouseClicked(double p_96122_, double p_96123_, int p_96124_) {
                this.select();
                if (Util.getMillis() - this.lastClickTime < 250L) {
                    LanguageSelectScreen.this.onDone();
                }

                this.lastClickTime = Util.getMillis();
                return super.mouseClicked(p_96122_, p_96123_, p_96124_);
            }

            private void select() {
                LanguageSelectionList.this.setSelected(this);
            }

            @Override
            public Component getNarration() {
                return Component.translatable("narrator.select", this.language);
            }
        }
    }
}
