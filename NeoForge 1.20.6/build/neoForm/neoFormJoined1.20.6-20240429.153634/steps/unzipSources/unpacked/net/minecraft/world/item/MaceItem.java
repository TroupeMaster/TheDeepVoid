package net.minecraft.world.item;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.DensityEnchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class MaceItem extends Item {
    private static final int DEFAULT_ATTACK_DAMAGE = 6;
    private static final float DEFAULT_ATTACK_SPEED = -2.4F;
    private static final float SMASH_ATTACK_FALL_THRESHOLD = 1.5F;
    private static final float SMASH_ATTACK_HEAVY_THRESHOLD = 5.0F;
    public static final float SMASH_ATTACK_KNOCKBACK_RADIUS = 3.5F;
    private static final float SMASH_ATTACK_KNOCKBACK_POWER = 0.7F;
    private static final float SMASH_ATTACK_FALL_DISTANCE_MULTIPLIER = 3.0F;

    public MaceItem(Item.Properties p_333796_) {
        super(p_333796_);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
            .add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 6.0, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
            )
            .add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
            )
            .build();
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 2);
    }

    @Override
    public boolean canAttackBlock(BlockState p_333875_, Level p_333847_, BlockPos p_334073_, Player p_334042_) {
        return !p_334042_.isCreative();
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public boolean hurtEnemy(ItemStack p_334046_, LivingEntity p_333712_, LivingEntity p_333812_) {
        p_334046_.hurtAndBreak(1, p_333812_, EquipmentSlot.MAINHAND);
        if (p_333812_ instanceof ServerPlayer serverplayer && canSmashAttack(serverplayer)) {
            ServerLevel serverlevel = (ServerLevel)p_333812_.level();
            serverplayer.currentImpulseImpactPos = serverplayer.position();
            serverplayer.ignoreFallDamageFromCurrentImpulse = true;
            serverplayer.setDeltaMovement(serverplayer.getDeltaMovement().with(Direction.Axis.Y, 0.01F));
            serverplayer.connection.send(new ClientboundSetEntityMotionPacket(serverplayer));
            if (p_333712_.onGround()) {
                serverplayer.setSpawnExtraParticlesOnFall(true);
                SoundEvent soundevent = serverplayer.fallDistance > 5.0F ? SoundEvents.MACE_SMASH_GROUND_HEAVY : SoundEvents.MACE_SMASH_GROUND;
                serverlevel.playSound(
                    null, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), soundevent, serverplayer.getSoundSource(), 1.0F, 1.0F
                );
            } else {
                serverlevel.playSound(
                    null, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), SoundEvents.MACE_SMASH_AIR, serverplayer.getSoundSource(), 1.0F, 1.0F
                );
            }

            knockback(serverlevel, serverplayer, p_333712_);
            return true;
        }

        return false;
    }

    @Override
    public boolean isValidRepairItem(ItemStack p_334031_, ItemStack p_334058_) {
        return p_334058_.is(Items.BREEZE_ROD);
    }

    @Override
    public float getAttackDamageBonus(Player p_335568_, float p_335575_) {
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.DENSITY, p_335568_);
        float f = DensityEnchantment.calculateDamageAddition(i, p_335568_.fallDistance);
        return canSmashAttack(p_335568_) ? 3.0F * p_335568_.fallDistance + f : 0.0F;
    }

    private static void knockback(Level p_335716_, Player p_335955_, Entity p_335810_) {
        p_335716_.levelEvent(2013, p_335810_.getOnPos(), 750);
        p_335716_.getEntitiesOfClass(LivingEntity.class, p_335810_.getBoundingBox().inflate(3.5), knockbackPredicate(p_335955_, p_335810_))
            .forEach(p_337941_ -> {
                Vec3 vec3 = p_337941_.position().subtract(p_335810_.position());
                double d0 = getKnockbackPower(p_335955_, p_337941_, vec3);
                Vec3 vec31 = vec3.normalize().scale(d0);
                if (d0 > 0.0) {
                    p_337941_.push(vec31.x, 0.7F, vec31.z);
                }
            });
    }

    private static Predicate<LivingEntity> knockbackPredicate(Player p_338613_, Entity p_338698_) {
        return p_337938_ -> {
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag5;
            label44: {
                flag = !p_337938_.isSpectator();
                flag1 = p_337938_ != p_338613_ && p_337938_ != p_338698_;
                flag2 = !p_338613_.isAlliedTo(p_337938_);
                if (p_337938_ instanceof ArmorStand armorstand && armorstand.isMarker()) {
                    flag5 = false;
                    break label44;
                }

                flag5 = true;
            }

            boolean flag3 = flag5;
            boolean flag4 = p_338698_.distanceToSqr(p_337938_) <= Math.pow(3.5, 2.0);
            return flag && flag1 && flag2 && flag3 && flag4;
        };
    }

    private static double getKnockbackPower(Player p_338265_, LivingEntity p_338630_, Vec3 p_338866_) {
        return (3.5 - p_338866_.length())
            * 0.7F
            * (double)(p_338265_.fallDistance > 5.0F ? 2 : 1)
            * (1.0 - p_338630_.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
    }

    public static boolean canSmashAttack(Player p_338434_) {
        return p_338434_.fallDistance > 1.5F && !p_338434_.isFallFlying();
    }
}
