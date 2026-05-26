package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.List;
import java.util.Comparator;

public class StingerItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("rightClicked") == true) {
			itemstack.getOrCreateTag().putDouble("state", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.setDeltaMovement(new Vec3(0, 0, 0));
			{
				final Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * 1.5, (entity.getY()), entity.getZ() + entity.getLookAngle().z * 1.5);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:eldritch_void"))), entity),
								(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.25));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 2,
									(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROT.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROT.get()).getAmplifier() : 0) + 1)));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.PLAYERS,
										(float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.PLAYERS, (float) 0.5,
										(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
							}
						}
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:unaffected_by_allseeing")))) {
							Vec3 motion = entityiterator.getDeltaMovement().scale(0.1);
							entityiterator.setDeltaMovement(motion);
						}
						itemstack.getOrCreateTag().putDouble("hit", (itemstack.getOrCreateTag().getDouble("hit") + 1));
					}
				}
			}
			if (itemstack.getOrCreateTag().getDouble("sound") >= 2) {
				itemstack.getOrCreateTag().putDouble("sound", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 0.5, (float) 1.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 0.5, (float) 1.8, false);
					}
				}
			} else {
				itemstack.getOrCreateTag().putDouble("sound", (itemstack.getOrCreateTag().getDouble("sound") + 1));
			}
		}
		if (itemstack.getOrCreateTag().getDouble("hit") >= 60) {
			itemstack.getOrCreateTag().putDouble("hit", 0);
			itemstack.getOrCreateTag().putBoolean("rightClicked", false);
			itemstack.getOrCreateTag().putDouble("state", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.stopUsingItem();
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX() + entity.getLookAngle().x * 1, 1, entity.getZ() + entity.getLookAngle().z * 1, 1, 0, 0, 0, 0);
			{
				final Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * 1.5, (entity.getY()), entity.getZ() + entity.getLookAngle().z * 1.5);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:eldritch_void"))), entity),
								(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, 0));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 5,
									entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROT.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROT.get()).getAmplifier() : 0));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
										SoundSource.PLAYERS, (float) 0.5, (float) 0.7);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS,
										(float) 0.5, (float) 0.7, false);
							}
						}
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:unaffected_by_allseeing")))) {
							entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 0.1, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
						}
					}
				}
			}
		}
	}
}
