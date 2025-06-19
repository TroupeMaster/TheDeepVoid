package net.minecraft.world.food;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.effect.MobEffectInstance;

public record FoodProperties(int nutrition, float saturation, boolean canAlwaysEat, float eatSeconds, List<FoodProperties.PossibleEffect> effects) {
    private static final float DEFAULT_EAT_SECONDS = 1.6F;
    public static final Codec<FoodProperties> DIRECT_CODEC = RecordCodecBuilder.create(
        p_337892_ -> p_337892_.group(
                    ExtraCodecs.NON_NEGATIVE_INT.fieldOf("nutrition").forGetter(FoodProperties::nutrition),
                    Codec.FLOAT.fieldOf("saturation").forGetter(FoodProperties::saturation),
                    Codec.BOOL.optionalFieldOf("can_always_eat", Boolean.valueOf(false)).forGetter(FoodProperties::canAlwaysEat),
                    ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("eat_seconds", 1.6F).forGetter(FoodProperties::eatSeconds),
                    FoodProperties.PossibleEffect.CODEC.listOf().optionalFieldOf("effects", List.of()).forGetter(FoodProperties::effects)
                )
                .apply(p_337892_, FoodProperties::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, FoodProperties> DIRECT_STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT,
        FoodProperties::nutrition,
        ByteBufCodecs.FLOAT,
        FoodProperties::saturation,
        ByteBufCodecs.BOOL,
        FoodProperties::canAlwaysEat,
        ByteBufCodecs.FLOAT,
        FoodProperties::eatSeconds,
        FoodProperties.PossibleEffect.STREAM_CODEC.apply(ByteBufCodecs.list()),
        FoodProperties::effects,
        FoodProperties::new
    );

    public int eatDurationTicks() {
        return (int)(this.eatSeconds * 20.0F);
    }

    public static class Builder {
        private int nutrition;
        private float saturationModifier;
        private boolean canAlwaysEat;
        private float eatSeconds = 1.6F;
        private final ImmutableList.Builder<FoodProperties.PossibleEffect> effects = ImmutableList.builder();

        public FoodProperties.Builder nutrition(int p_38761_) {
            this.nutrition = p_38761_;
            return this;
        }

        public FoodProperties.Builder saturationModifier(float p_38759_) {
            this.saturationModifier = p_38759_;
            return this;
        }

        public FoodProperties.Builder alwaysEdible() {
            this.canAlwaysEat = true;
            return this;
        }

        public FoodProperties.Builder fast() {
            this.eatSeconds = 0.8F;
            return this;
        }

        // Neo: Use supplier method instead
        @Deprecated
        public FoodProperties.Builder effect(MobEffectInstance p_38763_, float p_38764_) {
            this.effects.add(new FoodProperties.PossibleEffect(p_38763_, p_38764_));
            return this;
        }

        public FoodProperties.Builder effect(java.util.function.Supplier<MobEffectInstance> effectIn, float probability) {
            this.effects.add(new FoodProperties.PossibleEffect(effectIn, probability));
            return this;
        }

        public FoodProperties build() {
            float f = FoodConstants.saturationByModifier(this.nutrition, this.saturationModifier);
            return new FoodProperties(this.nutrition, f, this.canAlwaysEat, this.eatSeconds, this.effects.build());
        }
    }

    public static record PossibleEffect(java.util.function.Supplier<MobEffectInstance> effectSupplier, float probability) {
        public static final Codec<FoodProperties.PossibleEffect> CODEC = RecordCodecBuilder.create(
            p_337893_ -> p_337893_.group(
                        MobEffectInstance.CODEC.fieldOf("effect").forGetter(FoodProperties.PossibleEffect::effect),
                        Codec.floatRange(0.0F, 1.0F).optionalFieldOf("probability", 1.0F).forGetter(FoodProperties.PossibleEffect::probability)
                    )
                    .apply(p_337893_, FoodProperties.PossibleEffect::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, FoodProperties.PossibleEffect> STREAM_CODEC = StreamCodec.composite(
            MobEffectInstance.STREAM_CODEC,
            FoodProperties.PossibleEffect::effect,
            ByteBufCodecs.FLOAT,
            FoodProperties.PossibleEffect::probability,
            FoodProperties.PossibleEffect::new
        );

        private PossibleEffect(MobEffectInstance effect, float probability) {
            this(() -> effect, probability);
        }

        public MobEffectInstance effect() {
            return new MobEffectInstance(this.effectSupplier.get());
        }
    }
}
