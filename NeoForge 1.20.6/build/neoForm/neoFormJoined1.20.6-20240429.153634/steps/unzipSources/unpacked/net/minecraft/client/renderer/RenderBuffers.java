package net.minecraft.client.renderer;

import com.mojang.blaze3d.vertex.BufferBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.util.SortedMap;
import net.minecraft.Util;
import net.minecraft.client.resources.model.ModelBakery;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBuffers {
    private final SectionBufferBuilderPack fixedBufferPack = new SectionBufferBuilderPack();
    private final SectionBufferBuilderPool sectionBufferPool;
    private final MultiBufferSource.BufferSource bufferSource;
    private final MultiBufferSource.BufferSource crumblingBufferSource;
    private final OutlineBufferSource outlineBufferSource;

    public RenderBuffers(int p_307464_) {
        this.sectionBufferPool = SectionBufferBuilderPool.allocate(p_307464_);
        SortedMap<RenderType, BufferBuilder> sortedmap = Util.make(new Object2ObjectLinkedOpenHashMap<>(), p_307112_ -> {
            p_307112_.put(Sheets.solidBlockSheet(), this.fixedBufferPack.builder(RenderType.solid()));
            p_307112_.put(Sheets.cutoutBlockSheet(), this.fixedBufferPack.builder(RenderType.cutout()));
            p_307112_.put(Sheets.bannerSheet(), this.fixedBufferPack.builder(RenderType.cutoutMipped()));
            p_307112_.put(Sheets.translucentCullBlockSheet(), this.fixedBufferPack.builder(RenderType.translucent()));
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, Sheets.shieldSheet());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, Sheets.bedSheet());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, Sheets.shulkerBoxSheet());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, Sheets.signSheet());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, Sheets.hangingSignSheet());
            p_307112_.put(Sheets.chestSheet(), new BufferBuilder(786432));
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.armorGlint());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.armorEntityGlint());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.glint());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.glintDirect());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.glintTranslucent());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.entityGlint());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.entityGlintDirect());
            put((Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder>)p_307112_, RenderType.waterMask());
            ModelBakery.DESTROY_TYPES.forEach(p_173062_ -> put(p_307112_, p_173062_));
        });
        net.neoforged.fml.ModLoader.postEvent(new net.neoforged.neoforge.client.event.RegisterRenderBuffersEvent(sortedmap));
        this.crumblingBufferSource = MultiBufferSource.immediate(new BufferBuilder(1536));
        this.bufferSource = MultiBufferSource.immediateWithBuffers(sortedmap, new BufferBuilder(786432));
        this.outlineBufferSource = new OutlineBufferSource(this.bufferSource);
    }

    private static void put(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> p_110102_, RenderType p_110103_) {
        p_110102_.put(p_110103_, new BufferBuilder(p_110103_.bufferSize()));
    }

    public SectionBufferBuilderPack fixedBufferPack() {
        return this.fixedBufferPack;
    }

    public SectionBufferBuilderPool sectionBufferPool() {
        return this.sectionBufferPool;
    }

    public MultiBufferSource.BufferSource bufferSource() {
        return this.bufferSource;
    }

    public MultiBufferSource.BufferSource crumblingBufferSource() {
        return this.crumblingBufferSource;
    }

    public OutlineBufferSource outlineBufferSource() {
        return this.outlineBufferSource;
    }
}
