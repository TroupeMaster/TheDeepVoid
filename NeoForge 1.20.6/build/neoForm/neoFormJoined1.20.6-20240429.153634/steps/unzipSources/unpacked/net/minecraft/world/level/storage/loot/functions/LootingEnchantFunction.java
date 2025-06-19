package net.minecraft.world.level.storage.loot.functions;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import java.util.List;
import java.util.Set;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;

public class LootingEnchantFunction extends LootItemConditionalFunction {
    public static final int NO_LIMIT = 0;
    public static final MapCodec<LootingEnchantFunction> CODEC = RecordCodecBuilder.mapCodec(
        p_338144_ -> commonFields(p_338144_)
                .and(
                    p_338144_.group(
                        NumberProviders.CODEC.fieldOf("count").forGetter(p_299003_ -> p_299003_.value),
                        Codec.INT.optionalFieldOf("limit", Integer.valueOf(0)).forGetter(p_298536_ -> p_298536_.limit)
                    )
                )
                .apply(p_338144_, LootingEnchantFunction::new)
    );
    private final NumberProvider value;
    private final int limit;

    LootingEnchantFunction(List<LootItemCondition> p_298273_, NumberProvider p_165227_, int p_165228_) {
        super(p_298273_);
        this.value = p_165227_;
        this.limit = p_165228_;
    }

    @Override
    public LootItemFunctionType<LootingEnchantFunction> getType() {
        return LootItemFunctions.LOOTING_ENCHANT;
    }

    @Override
    public Set<LootContextParam<?>> getReferencedContextParams() {
        return Sets.union(ImmutableSet.of(LootContextParams.KILLER_ENTITY), this.value.getReferencedContextParams());
    }

    private boolean hasLimit() {
        return this.limit > 0;
    }

    @Override
    public ItemStack run(ItemStack p_80789_, LootContext p_80790_) {
        Entity entity = p_80790_.getParamOrNull(LootContextParams.KILLER_ENTITY);
        if (entity instanceof LivingEntity) {
            int i = p_80790_.getLootingModifier();
            if (i == 0) {
                return p_80789_;
            }

            float f = (float)i * this.value.getFloat(p_80790_);
            p_80789_.grow(Math.round(f));
            if (this.hasLimit()) {
                p_80789_.limitSize(this.limit);
            }
        }

        return p_80789_;
    }

    public static LootingEnchantFunction.Builder lootingMultiplier(NumberProvider p_165230_) {
        return new LootingEnchantFunction.Builder(p_165230_);
    }

    public static class Builder extends LootItemConditionalFunction.Builder<LootingEnchantFunction.Builder> {
        private final NumberProvider count;
        private int limit = 0;

        public Builder(NumberProvider p_165232_) {
            this.count = p_165232_;
        }

        protected LootingEnchantFunction.Builder getThis() {
            return this;
        }

        public LootingEnchantFunction.Builder setLimit(int p_80807_) {
            this.limit = p_80807_;
            return this;
        }

        @Override
        public LootItemFunction build() {
            return new LootingEnchantFunction(this.getConditions(), this.count, this.limit);
        }
    }
}
