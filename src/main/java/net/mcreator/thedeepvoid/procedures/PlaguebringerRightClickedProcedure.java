package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.List;
import java.util.Comparator;

public class PlaguebringerRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double distance = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		distance = 0;
		for (int index0 = 0; index0 < 4; index0++) {
			PlaguebringerSlashEffectProcedure.execute(world, x, y, z, entity, 0 + distance);
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((1.6 + distance))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
								.getX()),
						(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((1.6 + distance))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator == (entity.getVehicle()))
							&& !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:rotten"))), entity),
								(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 1.8));
						if ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.PLAGUE.get()).getAmplifier() : 0) >= 2) {
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
										+ (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.PLAGUE.get()).getAmplifier() : 0) / 10));
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(TheDeepVoidModMobEffects.PLAGUE.get());
						} else {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PLAGUE.get(), 160, 0));
						}
					}
				}
			}
			distance = distance + 1;
		}
	}
}
