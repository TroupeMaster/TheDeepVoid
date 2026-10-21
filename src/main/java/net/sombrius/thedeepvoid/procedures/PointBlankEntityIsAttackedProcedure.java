package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PointBlankEntityIsAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, damagesource, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double dist = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.POINT_BLANK.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("the_deep_void:guns")))
				&& immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:bullet")))
				&& !immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:nocooldown_bullet")))
				&& !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:cooldown_gun")))) {
			dist = Math.pow(entity.getX() - sourceentity.getX(), 2) + Math.pow(entity.getY() - sourceentity.getY(), 2) + Math.pow(entity.getZ() - sourceentity.getZ(), 2);
			if (dist <= 5) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:cooldown_gun"))), sourceentity),
						(float) (amount * (1.1 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(TheDeepVoidModEnchantments.POINT_BLANK.get()) * 0.05)));
			}
		}
	}
}
