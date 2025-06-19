package net.minecraft.world.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class ArrowItem extends Item implements ProjectileItem {
    public ArrowItem(Item.Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
        return new Arrow(p_40513_, p_40515_, p_40514_.copyWithCount(1));
    }

    @Override
    public Projectile asProjectile(Level p_338330_, Position p_338329_, ItemStack p_338197_, Direction p_338469_) {
        Arrow arrow = new Arrow(p_338330_, p_338329_.x(), p_338329_.y(), p_338329_.z(), p_338197_.copyWithCount(1));
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.LivingEntity livingEntity) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY, bow);
        return enchant > 0 && this.getClass() == net.minecraft.world.item.ArrowItem.class;
    }
}
