package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ChainedWeaverOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 99, false, false));
		if (entity.getPersistentData().getBoolean("deep_void:free") == true) {
			if (entity.getPersistentData().getBoolean("deep_void:playingAnimation") == false) {
				entity.getPersistentData().putBoolean("deep_void:playingAnimation", true);
				if (entity instanceof ChainedWeaverEntity) {
					((ChainedWeaverEntity) entity).setAnimation("animation.chainedWeaver_getOut");
				}
				TheDeepVoidMod.queueServerWork(170, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WEAVER_OF_SOULS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream")), SoundSource.HOSTILE, 4, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream")), SoundSource.HOSTILE, 4, 1, false);
						}
					}
				});
			}
		}
		if (entity.getPersistentData().getBoolean("deep_void:playingAnimation") == true) {
			if (Math.random() < 0.02) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.HOSTILE, 4, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.HOSTILE, 4, (float) 0.8, false);
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 55, 55, 55), e -> true).isEmpty()) {
			if (entity.getPersistentData().getBoolean("deep_void:message") == false && entity.getPersistentData().getBoolean("deep_void:talking") == false) {
				entity.getPersistentData().putBoolean("deep_void:message", true);
				entity.getPersistentData().putDouble("deep_void:messageCount", 200);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(55 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lThe Void is accepting, the Void embraces all, shows us the path.. \u00A7c\u00A7l\u00A7kGOD"), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lGet me out of these chains.. \u00A7c\u00A7l\u00A7kGOD"), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lA Vessel granted for the unascended.. \u00A7c\u00A7l\u00A7kGOD"), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lA Vessel to make one with the Void.. \u00A7c\u00A7l\u00A7kGOD"), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u00A7kGOD \u00A7c\u00A7lGet me out of these chains.. \u00A7c\u00A7l\u00A7kGOD"), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("deep_void:message") == true) {
			if (entity.getPersistentData().getDouble("deep_void:messageCount") > 0) {
				entity.getPersistentData().putDouble("deep_void:messageCount", (entity.getPersistentData().getDouble("deep_void:messageCount") - 1));
			}
			if (entity.getPersistentData().getDouble("deep_void:messageCount") <= 0) {
				entity.getPersistentData().putBoolean("deep_void:message", false);
			}
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}
