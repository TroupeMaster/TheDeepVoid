package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.HollowedEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class HollowedSetsAttackTargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof HollowedEntity) {
			if (entity.isShiftKeyDown() && (sourceentity instanceof HollowedEntity _datEntI ? _datEntI.getEntityData().get(HollowedEntity.DATA_call) : 0) <= 0) {
				if (sourceentity instanceof Mob) {
					try {
						((Mob) sourceentity).setTarget(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				if ((sourceentity instanceof HollowedEntity _datEntI ? _datEntI.getEntityData().get(HollowedEntity.DATA_call) : 0) <= 0) {
					if (sourceentity instanceof HollowedEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HollowedEntity.DATA_call, 800);
					if ((sourceentity instanceof HollowedEntity _datEntL6 && _datEntL6.getEntityData().get(HollowedEntity.DATA_called)) == false) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 99, false, false));
						if (sourceentity instanceof HollowedEntity) {
							((HollowedEntity) sourceentity).setAnimation("animation.hollowed_scream");
						}
						TheDeepVoidMod.queueServerWork(25, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hollowed_scream")),
											SoundSource.HOSTILE, 8, (float) Mth.nextDouble(RandomSource.create(), 0.89, 1));
								} else {
									_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hollowed_scream")), SoundSource.HOSTILE, 8,
											(float) Mth.nextDouble(RandomSource.create(), 0.89, 1), false);
								}
							}
						});
						{
							final Vec3 _center = new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof HollowedEntity && !(entityiterator == sourceentity)) {
									if (entityiterator instanceof HollowedEntity) {
										((HollowedEntity) entityiterator).setAnimation("animation.hollowed_scream");
									}
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 99, false, false));
									if (entityiterator instanceof HollowedEntity _datEntSetL)
										_datEntSetL.getEntityData().set(HollowedEntity.DATA_called, true);
									TheDeepVoidMod.queueServerWork(45, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
														ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hollowed_responds")), SoundSource.HOSTILE, 8, (float) Mth.nextDouble(RandomSource.create(), 0.89, 1));
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hollowed_responds")),
														SoundSource.HOSTILE, 8, (float) Mth.nextDouble(RandomSource.create(), 0.89, 1), false);
											}
										}
									});
									TheDeepVoidMod.queueServerWork(60, () -> {
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									});
								}
							}
						}
					}
				} else {
					if ((sourceentity instanceof HollowedEntity _datEntI ? _datEntI.getEntityData().get(HollowedEntity.DATA_call) : 0) == 800) {
						if (sourceentity instanceof HollowedEntity _datEntSetL)
							_datEntSetL.getEntityData().set(HollowedEntity.DATA_called, false);
					}
					if (sourceentity instanceof HollowedEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HollowedEntity.DATA_call, (int) ((sourceentity instanceof HollowedEntity _datEntI ? _datEntI.getEntityData().get(HollowedEntity.DATA_call) : 0) - 1));
				}
			}
		}
	}
}
