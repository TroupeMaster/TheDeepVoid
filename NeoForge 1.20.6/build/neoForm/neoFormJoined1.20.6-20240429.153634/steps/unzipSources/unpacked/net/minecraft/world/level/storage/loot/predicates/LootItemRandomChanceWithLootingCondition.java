package net.minecraft.world.level.storage.loot.predicates;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import java.util.Set;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public record LootItemRandomChanceWithLootingCondition(float percent, float lootingMultiplier) implements LootItemCondition {
    public static final MapCodec<LootItemRandomChanceWithLootingCondition> CODEC = RecordCodecBuilder.mapCodec(
        p_298193_ -> p_298193_.group(
                    Codec.FLOAT.fieldOf("chance").forGetter(LootItemRandomChanceWithLootingCondition::percent),
                    Codec.FLOAT.fieldOf("looting_multiplier").forGetter(LootItemRandomChanceWithLootingCondition::lootingMultiplier)
                )
                .apply(p_298193_, LootItemRandomChanceWithLootingCondition::new)
    );

    @Override
    public LootItemConditionType getType() {
        return LootItemConditions.RANDOM_CHANCE_WITH_LOOTING;
    }

    @Override
    public Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.KILLER_ENTITY);
    }

    public boolean test(LootContext p_81967_) {
        int i = p_81967_.getLootingModifier();
        return p_81967_.getRandom().nextFloat() < this.percent + (float)i * this.lootingMultiplier;
    }

    public static LootItemCondition.Builder randomChanceAndLootingBoost(float p_81964_, float p_81965_) {
        return () -> new LootItemRandomChanceWithLootingCondition(p_81964_, p_81965_);
    }
}
