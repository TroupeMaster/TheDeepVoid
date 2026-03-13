package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class SoulSeekerAoeDamageProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator == sourceentity) && !(entityiterator == (sourceentity.getVehicle()))
						&& !(entityiterator instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
					if (Math.random() < 0.4) {
						entityiterator.hurt(
								new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))), sourceentity),
								(float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() / 2));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")),
										SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.96, 1.04));
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.HOSTILE, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.96, 1.04), false);
							}
						}
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")),
											SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.96, 1.04));
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.96, 1.04), false);
								}
							}
						}
						Xo = entity.getX() - entityiterator.getX();
						Yo = entity.getY() - entityiterator.getY();
						Zo = entity.getZ() - entityiterator.getZ();
						if (Math.floor(entity.getX()) <= Math.floor(entityiterator.getX())) {
							if (Math.floor(entity.getX()) == Math.floor(entityiterator.getX())) {
								if (Math.floor(entity.getY()) == Math.floor(entityiterator.getY())) {
									if (Math.floor(entity.getZ()) <= Math.floor(entityiterator.getZ())) {
										Za = Math.floor(entity.getZ()) + 0.2;
										while (Za <= Math.floor(entityiterator.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.SQUID_INK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									} else {
										Za = Math.floor(entityiterator.getZ()) + 0.2;
										while (Za <= Math.floor(entity.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.SQUID_INK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									}
								} else {
									if (Math.floor(entity.getY()) <= Math.floor(entityiterator.getY())) {
										Ya = Math.floor(entity.getY()) + 0.2;
										while (Ya <= Math.floor(entityiterator.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.SQUID_INK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									} else {
										Ya = Math.floor(entityiterator.getY()) + 0.2;
										while (Ya <= Math.floor(entity.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.SQUID_INK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									}
								}
							} else {
								Xa = Math.floor(entity.getX()) + 0.2;
								while (Xa <= Math.floor(entityiterator.getX())) {
									T = (Xa - entity.getX()) / Xo;
									Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.SQUID_INK, Xa, Ya, Za, 1, 0, 0, 0, 0);
									Xa = 0.2 + Xa;
								}
							}
						} else {
							Xa = entityiterator.getX() + 0.2;
							while (Xa < Math.floor(entity.getX())) {
								T = (Xa - entity.getX()) / Xo;
								Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SQUID_INK, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Xa = 0.2 + Xa;
							}
						}
					}
				}
			}
		}
	}
}
