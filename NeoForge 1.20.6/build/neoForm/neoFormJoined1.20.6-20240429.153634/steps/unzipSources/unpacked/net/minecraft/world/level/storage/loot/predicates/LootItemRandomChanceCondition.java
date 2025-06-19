package net.minecraft.world.level.storage.loot.predicates;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import net.minecraft.world.level.storage.loot.LootContext;

public record LootItemRandomChanceCondition(float probability) implements LootItemCondition {
    public static final MapCodec<LootItemRandomChanceCondition> CODEC = RecordCodecBuilder.mapCodec(
        p_298192_ -> p_298192_.group(Codec.FLOAT.fieldOf("chance").forGetter(LootItemRandomChanceCondition::probability))
                .apply(p_298192_, LootItemRandomChanceCondition::new)
    );

    @Override
    public LootItemConditionType getType() {
        return LootItemConditions.RANDOM_CHANCE;
    }

    public boolean test(LootContext p_81930_) {
        return p_81930_.getRandom().nextFloat() < this.probability;
    }

    public static LootItemCondition.Builder randomChance(float p_81928_) {
        return () -> new LootItemRandomChanceCondition(p_81928_);
    }
}
