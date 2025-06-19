package net.minecraft.world.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public abstract class ProjectileWeaponItem extends Item {
    public static final Predicate<ItemStack> ARROW_ONLY = p_43017_ -> p_43017_.is(ItemTags.ARROWS);
    public static final Predicate<ItemStack> ARROW_OR_FIREWORK = ARROW_ONLY.or(p_43015_ -> p_43015_.is(Items.FIREWORK_ROCKET));

    public ProjectileWeaponItem(Item.Properties p_43009_) {
        super(p_43009_);
    }

    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return this.getAllSupportedProjectiles();
    }

    public abstract Predicate<ItemStack> getAllSupportedProjectiles();

    public static ItemStack getHeldProjectile(LivingEntity p_43011_, Predicate<ItemStack> p_43012_) {
        if (p_43012_.test(p_43011_.getItemInHand(InteractionHand.OFF_HAND))) {
            return p_43011_.getItemInHand(InteractionHand.OFF_HAND);
        } else {
            return p_43012_.test(p_43011_.getItemInHand(InteractionHand.MAIN_HAND)) ? p_43011_.getItemInHand(InteractionHand.MAIN_HAND) : ItemStack.EMPTY;
        }
    }

    @Override
    public int getEnchantmentValue() {
        return 1;
    }

    public abstract int getDefaultProjectileRange();

    protected void shoot(
        Level p_331270_,
        LivingEntity p_330728_,
        InteractionHand p_331152_,
        ItemStack p_330646_,
        List<ItemStack> p_331726_,
        float p_331007_,
        float p_331445_,
        boolean p_331107_,
        @Nullable LivingEntity p_331167_
    ) {
        float f = 10.0F;
        float f1 = p_331726_.size() == 1 ? 0.0F : 20.0F / (float)(p_331726_.size() - 1);
        float f2 = (float)((p_331726_.size() - 1) % 2) * f1 / 2.0F;
        float f3 = 1.0F;

        for (int i = 0; i < p_331726_.size(); i++) {
            ItemStack itemstack = p_331726_.get(i);
            if (!itemstack.isEmpty()) {
                float f4 = f2 + f3 * (float)((i + 1) / 2) * f1;
                f3 = -f3;
                p_330646_.hurtAndBreak(this.getDurabilityUse(itemstack), p_330728_, LivingEntity.getSlotForHand(p_331152_));
                Projectile projectile = this.createProjectile(p_331270_, p_330728_, p_330646_, itemstack, p_331107_);
                this.shootProjectile(p_330728_, projectile, i, p_331007_, p_331445_, f4, p_331167_);
                p_331270_.addFreshEntity(projectile);
            }
        }
    }

    protected int getDurabilityUse(ItemStack p_331003_) {
        return 1;
    }

    protected abstract void shootProjectile(
        LivingEntity p_330966_, Projectile p_332201_, int p_331696_, float p_331444_, float p_331156_, float p_331718_, @Nullable LivingEntity p_331705_
    );

    protected Projectile createProjectile(Level p_331008_, LivingEntity p_330781_, ItemStack p_330846_, ItemStack p_331497_, boolean p_331305_) {
        ArrowItem arrowitem = p_331497_.getItem() instanceof ArrowItem arrowitem1 ? arrowitem1 : (ArrowItem)Items.ARROW;
        AbstractArrow abstractarrow = arrowitem.createArrow(p_331008_, p_331497_, p_330781_);
        if (p_331305_) {
            abstractarrow.setCritArrow(true);
        }

        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER, p_330846_);
        if (k > 0) {
            abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)k * 0.5 + 0.5);
        }

        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH, p_330846_);
        if (i > 0) {
            abstractarrow.setKnockback(i);
        }

        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAME, p_330846_) > 0) {
            abstractarrow.igniteForSeconds(100);
        }

        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, p_330846_);
        if (j > 0) {
            abstractarrow.setPierceLevel((byte)j);
        }

        return customArrow(abstractarrow, p_330846_);
    }

    protected static boolean hasInfiniteArrows(ItemStack p_330642_, ItemStack p_332202_, boolean p_331512_) {
        return p_331512_ || p_332202_.is(Items.ARROW) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY, p_330642_) > 0;
    }

    protected static List<ItemStack> draw(ItemStack p_331565_, ItemStack p_330406_, LivingEntity p_330823_) {
        if (p_330406_.isEmpty()) {
            return List.of();
        } else {
            int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, p_331565_);
            int j = i == 0 ? 1 : 3;
            List<ItemStack> list = new ArrayList<>(j);
            ItemStack itemstack = p_330406_.copy();

            for (int k = 0; k < j; k++) {
                list.add(useAmmo(p_331565_, k == 0 ? p_330406_ : itemstack, p_330823_, k > 0));
            }

            return list;
        }
    }

    protected static ItemStack useAmmo(ItemStack p_331207_, ItemStack p_331434_, LivingEntity p_330302_, boolean p_330934_) {
        boolean flag = !p_330934_ && !(p_330302_.hasInfiniteMaterials() || (p_331434_.getItem() instanceof ArrowItem && ((ArrowItem)p_331434_.getItem()).isInfinite(p_331434_, p_331207_, p_330302_)));
        if (!flag) {
            ItemStack itemstack1 = p_331434_.copyWithCount(1);
            itemstack1.set(DataComponents.INTANGIBLE_PROJECTILE, Unit.INSTANCE);
            return itemstack1;
        } else {
            ItemStack itemstack = p_331434_.split(1);
            if (p_331434_.isEmpty() && p_330302_ instanceof Player player) {
                player.getInventory().removeItem(p_331434_);
            }

            return itemstack;
        }
    }

    public AbstractArrow customArrow(AbstractArrow arrow, net.minecraft.world.item.ItemStack stack) {
        return arrow;
    }
}
