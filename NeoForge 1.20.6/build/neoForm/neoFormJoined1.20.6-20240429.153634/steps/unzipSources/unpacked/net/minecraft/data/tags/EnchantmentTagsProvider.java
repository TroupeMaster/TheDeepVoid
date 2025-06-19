package net.minecraft.data.tags;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.enchantment.Enchantment;

public abstract class EnchantmentTagsProvider extends IntrinsicHolderTagsProvider<Enchantment> {
    private final FeatureFlagSet enabledFeatures;

    public EnchantmentTagsProvider(PackOutput p_341044_, CompletableFuture<HolderLookup.Provider> p_341146_, FeatureFlagSet p_340837_) {
        super(p_341044_, Registries.ENCHANTMENT, p_341146_, p_341324_ -> p_341324_.builtInRegistryHolder().key());
        this.enabledFeatures = p_340837_;
    }

    protected void tooltipOrder(HolderLookup.Provider p_341105_, Enchantment... p_341174_) {
        this.tag(EnchantmentTags.TOOLTIP_ORDER).add(p_341174_);
        Set<Enchantment> set = Set.of(p_341174_);
        List<String> list = p_341105_.lookupOrThrow(Registries.ENCHANTMENT)
            .listElements()
            .filter(p_340870_ -> p_340870_.value().requiredFeatures().isSubsetOf(this.enabledFeatures))
            .filter(p_340965_ -> !set.contains(p_340965_.value()))
            .map(Holder::getRegisteredName)
            .collect(Collectors.toList());
        if (!list.isEmpty()) {
            throw new IllegalStateException("Not all enchantments were registered for tooltip ordering. Missing: " + String.join(", ", list));
        }
    }
}
