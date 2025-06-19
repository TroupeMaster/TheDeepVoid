package net.minecraft.world.item.enchantment;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Enchantment implements FeatureElement, net.neoforged.neoforge.common.extensions.IEnchantmentExtension {
    private final Enchantment.EnchantmentDefinition definition;
    @Nullable
    protected String descriptionId;
    private final Holder.Reference<Enchantment> builtInRegistryHolder = BuiltInRegistries.ENCHANTMENT.createIntrusiveHolder(this);

    public static Enchantment.Cost constantCost(int p_336195_) {
        return new Enchantment.Cost(p_336195_, 0);
    }

    public static Enchantment.Cost dynamicCost(int p_336066_, int p_336018_) {
        return new Enchantment.Cost(p_336066_, p_336018_);
    }

    public static Enchantment.EnchantmentDefinition definition(
        TagKey<Item> p_335552_,
        TagKey<Item> p_336174_,
        int p_335557_,
        int p_336051_,
        Enchantment.Cost p_336176_,
        Enchantment.Cost p_335380_,
        int p_335569_,
        EquipmentSlot... p_335470_
    ) {
        return new Enchantment.EnchantmentDefinition(
            p_335552_, Optional.of(p_336174_), p_335557_, p_336051_, p_336176_, p_335380_, p_335569_, FeatureFlags.DEFAULT_FLAGS, p_335470_
        );
    }

    public static Enchantment.EnchantmentDefinition definition(
        TagKey<Item> p_335812_, int p_335506_, int p_335598_, Enchantment.Cost p_336185_, Enchantment.Cost p_335768_, int p_335409_, EquipmentSlot... p_335583_
    ) {
        return new Enchantment.EnchantmentDefinition(
            p_335812_, Optional.empty(), p_335506_, p_335598_, p_336185_, p_335768_, p_335409_, FeatureFlags.DEFAULT_FLAGS, p_335583_
        );
    }

    public static Enchantment.EnchantmentDefinition definition(
        TagKey<Item> p_338699_,
        int p_338488_,
        int p_338497_,
        Enchantment.Cost p_338563_,
        Enchantment.Cost p_338689_,
        int p_338253_,
        FeatureFlagSet p_338531_,
        EquipmentSlot... p_338705_
    ) {
        return new Enchantment.EnchantmentDefinition(p_338699_, Optional.empty(), p_338488_, p_338497_, p_338563_, p_338689_, p_338253_, p_338531_, p_338705_);
    }

    @Nullable
    public static Enchantment byId(int p_44698_) {
        return BuiltInRegistries.ENCHANTMENT.byId(p_44698_);
    }

    public Enchantment(Enchantment.EnchantmentDefinition p_335940_) {
        this.definition = p_335940_;
    }

    public Map<EquipmentSlot, ItemStack> getSlotItems(LivingEntity p_44685_) {
        Map<EquipmentSlot, ItemStack> map = Maps.newEnumMap(EquipmentSlot.class);

        for (EquipmentSlot equipmentslot : this.definition.slots()) {
            ItemStack itemstack = p_44685_.getItemBySlot(equipmentslot);
            if (!itemstack.isEmpty()) {
                map.put(equipmentslot, itemstack);
            }
        }

        return map;
    }

    public final TagKey<Item> getSupportedItems() {
        return this.definition.supportedItems();
    }

    public final boolean isPrimaryItem(ItemStack p_336088_) {
        return this.definition.primaryItems.isEmpty() || p_336088_.is(this.definition.primaryItems.get());
    }

    public final int getWeight() {
        return this.definition.weight();
    }

    public final int getAnvilCost() {
        return this.definition.anvilCost();
    }

    public final int getMinLevel() {
        return 1;
    }

    public final int getMaxLevel() {
        return this.definition.maxLevel();
    }

    public final int getMinCost(int p_44679_) {
        return this.definition.minCost().calculate(p_44679_);
    }

    public final int getMaxCost(int p_44691_) {
        return this.definition.maxCost().calculate(p_44691_);
    }

    public int getDamageProtection(int p_44680_, DamageSource p_44681_) {
        return 0;
    }

    @Deprecated // Forge: Use ItemStack aware version in IForgeEnchantment
    public float getDamageBonus(int p_44682_, @Nullable EntityType<?> p_320800_) {
        return 0.0F;
    }

    public final boolean isCompatibleWith(Enchantment p_44696_) {
        return this.checkCompatibility(p_44696_) && p_44696_.checkCompatibility(this);
    }

    protected boolean checkCompatibility(Enchantment p_44690_) {
        return this != p_44690_;
    }

    protected String getOrCreateDescriptionId() {
        if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("enchantment", BuiltInRegistries.ENCHANTMENT.getKey(this));
        }

        return this.descriptionId;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    public Component getFullname(int p_44701_) {
        MutableComponent mutablecomponent = Component.translatable(this.getDescriptionId());
        if (this.isCurse()) {
            mutablecomponent.withStyle(ChatFormatting.RED);
        } else {
            mutablecomponent.withStyle(ChatFormatting.GRAY);
        }

        if (p_44701_ != 1 || this.getMaxLevel() != 1) {
            mutablecomponent.append(CommonComponents.SPACE).append(Component.translatable("enchantment.level." + p_44701_));
        }

        return mutablecomponent;
    }

    public boolean canEnchant(ItemStack p_44689_) {
        return canApplyAtEnchantingTable(p_44689_);
    }

    public void doPostAttack(LivingEntity p_44686_, Entity p_44687_, int p_44688_) {
    }

    public void doPostHurt(LivingEntity p_44692_, Entity p_44693_, int p_44694_) {
    }

    public void doPostItemStackHurt(LivingEntity p_338405_, Entity p_338648_, int p_338725_) {
    }

    public boolean isTreasureOnly() {
        return false;
    }

    public boolean isCurse() {
        return false;
    }

    public boolean isTradeable() {
        return true;
    }

    public boolean isDiscoverable() {
        return true;
    }

    /**
     * This applies specifically to applying at the enchanting table. The other method {@link #canEnchant(ItemStack)}
     * applies for <i>all possible</i> enchantments.
     * @param stack
     * @return
     */
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.canApplyAtEnchantingTable(this);
    }

    /**
     * Is this enchantment allowed to be enchanted on books via Enchantment Table
     * @return false to disable the vanilla feature
     */
    public boolean isAllowedOnBooks() {
        return true;
    }

    @Deprecated
    public Holder.Reference<Enchantment> builtInRegistryHolder() {
        return this.builtInRegistryHolder;
    }

    @Override
    public FeatureFlagSet requiredFeatures() {
        return this.definition.requiredFeatures();
    }

    public static record Cost(int base, int perLevel) {
        public int calculate(int p_335917_) {
            return this.base + this.perLevel * (p_335917_ - 1);
        }
    }

    public static record EnchantmentDefinition(
        TagKey<Item> supportedItems,
        Optional<TagKey<Item>> primaryItems,
        int weight,
        int maxLevel,
        Enchantment.Cost minCost,
        Enchantment.Cost maxCost,
        int anvilCost,
        FeatureFlagSet requiredFeatures,
        EquipmentSlot[] slots
    ) {
    }
}
