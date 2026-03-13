package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class SoulSeekerRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("soul") >= 10) {
			itemstack.getOrCreateTag().putDouble("soul", 0);
			itemstack.getOrCreateTag().putDouble("temp", (itemstack.getOrCreateTag().getDouble("value")));
			itemstack.getOrCreateTag().putDouble("value", 0);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 160);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_SWEEP.get()), entity.getX() + entity.getLookAngle().x * 2.4, (entity.getY() + 0.9), entity.getZ() + entity.getLookAngle().z * 2.4, 1, 0, 0, 0, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:the_harvest_soul_slash")), SoundSource.PLAYERS, 1,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:the_harvest_soul_slash")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator == (entity.getVehicle()))
							&& !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
						TheDeepVoidMod.queueServerWork(Mth.nextInt(RandomSource.create(), 5, 10), () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BITE.get()), (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 1, 0, 0, 0, 0);
							TheDeepVoidMod.queueServerWork(12, () -> {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))), entity),
										(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * (1 + itemstack.getOrCreateTag().getDouble("temp"))));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")),
												SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
									}
								}
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (double) DeepVoidConfigConfiguration.SOULREAPERLIFESTEAL.get()));
							});
						});
					}
				}
			}
		} else {
			if (itemstack.getOrCreateTag().getDouble("soul") < 9) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 80);
			}
			SoulSeekerSlashEffectProcedure.execute(world, x, y, z, entity);
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator == (entity.getVehicle()))
							&& !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))), entity),
								(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 1.2));
						if (itemstack.getOrCreateTag().getDouble("soul") < 10) {
							itemstack.getOrCreateTag().putDouble("soul", (itemstack.getOrCreateTag().getDouble("soul") + 1));
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SCULK_SOUL, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), Mth.nextInt(RandomSource.create(), 1, 3), 0, 0.3, 0, 0.1);
					}
				}
			}
		}
	}
}
