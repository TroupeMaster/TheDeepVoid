package net.minecraft.client.renderer;

import com.mojang.blaze3d.vertex.BufferBuilder;
import java.util.Map;
import java.util.stream.Collectors;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SectionBufferBuilderPack implements AutoCloseable {
    public static final int TOTAL_BUFFERS_SIZE = RenderType.chunkBufferLayers().stream().mapToInt(RenderType::bufferSize).sum();
    private final Map<RenderType, BufferBuilder> builders = RenderType.chunkBufferLayers()
        .stream()
        .collect(Collectors.toMap(p_294295_ -> (RenderType)p_294295_, p_295012_ -> new BufferBuilder(p_295012_.bufferSize())));

    public BufferBuilder builder(RenderType p_295847_) {
        return this.builders.get(p_295847_);
    }

    public void clearAll() {
        this.builders.values().forEach(BufferBuilder::clear);
    }

    public void discardAll() {
        this.builders.values().forEach(BufferBuilder::discard);
    }

    @Override
    public void close() {
        this.builders.values().forEach(BufferBuilder::release);
    }
}
