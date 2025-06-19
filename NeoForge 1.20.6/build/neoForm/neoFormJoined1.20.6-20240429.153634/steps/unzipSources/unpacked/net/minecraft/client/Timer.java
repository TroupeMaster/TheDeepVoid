package net.minecraft.client;

import it.unimi.dsi.fastutil.floats.FloatUnaryOperator;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Timer {
    public float partialTick;
    public float tickDelta;
    private long lastMs;
    private final float msPerTick;
    private final FloatUnaryOperator targetMsptProvider;

    public Timer(float p_92523_, long p_92524_, FloatUnaryOperator p_308974_) {
        this.msPerTick = 1000.0F / p_92523_;
        this.lastMs = p_92524_;
        this.targetMsptProvider = p_308974_;
    }

    public int advanceTime(long p_92526_) {
        this.tickDelta = (float)(p_92526_ - this.lastMs) / this.targetMsptProvider.apply(this.msPerTick);
        this.lastMs = p_92526_;
        this.partialTick = this.partialTick + this.tickDelta;
        int i = (int)this.partialTick;
        this.partialTick -= (float)i;
        return i;
    }
}
