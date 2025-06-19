package net.minecraft.client.gui.screens.reporting;

import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.Optionull;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.MultiLineEditBox;
import net.minecraft.client.gui.components.PlayerSkinWidget;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.CommonLayouts;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.layouts.LayoutSettings;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.chat.report.Report;
import net.minecraft.client.multiplayer.chat.report.ReportReason;
import net.minecraft.client.multiplayer.chat.report.ReportingContext;
import net.minecraft.client.multiplayer.chat.report.SkinReport;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkinReportScreen extends AbstractReportScreen<SkinReport.Builder> {
    private static final int BUTTON_WIDTH = 120;
    private static final int SKIN_WIDTH = 85;
    private static final int FORM_WIDTH = 178;
    private static final Component TITLE = Component.translatable("gui.abuseReport.skin.title");
    private final LinearLayout layout = LinearLayout.vertical().spacing(8);
    private MultiLineEditBox commentBox;
    private Button sendButton;
    private Button selectReasonButton;

    private SkinReportScreen(Screen p_299943_, ReportingContext p_299995_, SkinReport.Builder p_299886_) {
        super(TITLE, p_299943_, p_299995_, p_299886_);
    }

    public SkinReportScreen(Screen p_299906_, ReportingContext p_299981_, UUID p_299970_, Supplier<PlayerSkin> p_299980_) {
        this(p_299906_, p_299981_, new SkinReport.Builder(p_299970_, p_299980_, p_299981_.sender().reportLimits()));
    }

    public SkinReportScreen(Screen p_299996_, ReportingContext p_299971_, SkinReport p_299899_) {
        this(p_299996_, p_299971_, new SkinReport.Builder(p_299899_, p_299971_.sender().reportLimits()));
    }

    @Override
    protected void init() {
        this.layout.defaultCellSetting().alignHorizontallyCenter();
        this.layout.addChild(new StringWidget(this.title, this.font));
        LinearLayout linearlayout = this.layout.addChild(LinearLayout.horizontal().spacing(8));
        linearlayout.defaultCellSetting().alignVerticallyMiddle();
        linearlayout.addChild(new PlayerSkinWidget(85, 120, this.minecraft.getEntityModels(), this.reportBuilder.report().getSkinGetter()));
        LinearLayout linearlayout1 = linearlayout.addChild(LinearLayout.vertical().spacing(8));
        this.selectReasonButton = Button.builder(
                SELECT_REASON, p_299945_ -> this.minecraft.setScreen(new ReportReasonSelectionScreen(this, this.reportBuilder.reason(), p_299969_ -> {
                        this.reportBuilder.setReason(p_299969_);
                        this.onReportChanged();
                    }))
            )
            .width(178)
            .build();
        linearlayout1.addChild(CommonLayouts.labeledElement(this.font, this.selectReasonButton, OBSERVED_WHAT_LABEL));
        this.commentBox = this.createCommentBox(178, 9 * 8, p_299919_ -> {
            this.reportBuilder.setComments(p_299919_);
            this.onReportChanged();
        });
        linearlayout1.addChild(CommonLayouts.labeledElement(this.font, this.commentBox, MORE_COMMENTS_LABEL, p_300017_ -> p_300017_.paddingBottom(12)));
        LinearLayout linearlayout2 = this.layout.addChild(LinearLayout.horizontal().spacing(8));
        linearlayout2.addChild(Button.builder(CommonComponents.GUI_BACK, p_315829_ -> this.onClose()).width(120).build());
        this.sendButton = linearlayout2.addChild(Button.builder(SEND_REPORT, p_329742_ -> this.sendReport()).width(120).build());
        this.layout.visitWidgets(p_321364_ -> {
            AbstractWidget abstractwidget = this.addRenderableWidget(p_321364_);
        });
        this.repositionElements();
        this.onReportChanged();
    }

    @Override
    protected void repositionElements() {
        this.layout.arrangeElements();
        FrameLayout.centerInRectangle(this.layout, this.getRectangle());
    }

    private void onReportChanged() {
        ReportReason reportreason = this.reportBuilder.reason();
        if (reportreason != null) {
            this.selectReasonButton.setMessage(reportreason.title());
        } else {
            this.selectReasonButton.setMessage(SELECT_REASON);
        }

        Report.CannotBuildReason report$cannotbuildreason = this.reportBuilder.checkBuildable();
        this.sendButton.active = report$cannotbuildreason == null;
        this.sendButton.setTooltip(Optionull.map(report$cannotbuildreason, Report.CannotBuildReason::tooltip));
    }

    @Override
    public boolean mouseReleased(double p_299874_, double p_299850_, int p_299923_) {
        return super.mouseReleased(p_299874_, p_299850_, p_299923_) ? true : this.commentBox.mouseReleased(p_299874_, p_299850_, p_299923_);
    }
}
