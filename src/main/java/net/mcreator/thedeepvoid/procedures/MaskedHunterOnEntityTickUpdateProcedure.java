package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.entity.BoneCageEntity;
import net.mcreator.thedeepvoid.entity.BoneCageClosedEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class MaskedHunterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.isInWaterOrBubble()) {
			entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.05),
					(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) * 0.05), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.05)));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
					((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
		}
		if (DeepVoidConfigConfiguration.SPAWNBONECAGES.get() == true) {
			if (!(!world.getEntitiesOfClass(BoneCageEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())
					&& !(!world.getEntitiesOfClass(BoneCageClosedEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) && !entity.isInWaterOrBubble()) {
				MaskedHunterPlaceTrapProcedure.execute(world, x, y, z, entity);
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !entity.isInWaterOrBubble()) {
			MaskedHunterScreamWhileTargetProcedure.execute(world, x, y, z, entity);
			MaskedHunterThrowKnivesProcedure.execute(world, x, y, z, entity);
			MaskedHunterSpawnSpikesProcedure.execute(world, entity);
		}
		if ((entity instanceof MaskedHunterEntity _datEntI ? _datEntI.getEntityData().get(MaskedHunterEntity.DATA_screamAmbient) : 0) >= (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMCOOLDOWN.get()) {
			if (entity instanceof MaskedHunterEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MaskedHunterEntity.DATA_screamAmbient, 0);
			if (entity instanceof MaskedHunterEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MaskedHunterEntity.DATA_randomScreamAmbient, Mth.nextInt(RandomSource.create(), 1, 2));
			if (Math.random() < (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMCHANCE.get()) {
				if ((entity instanceof MaskedHunterEntity _datEntI ? _datEntI.getEntityData().get(MaskedHunterEntity.DATA_randomScreamAmbient) : 0) == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream1")), SoundSource.HOSTILE,
									(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream1")), SoundSource.HOSTILE,
									(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
					if (Math.random() < 0.8) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT,
										(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT,
										(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1), false);
							}
						}
					}
				} else if ((entity instanceof MaskedHunterEntity _datEntI ? _datEntI.getEntityData().get(MaskedHunterEntity.DATA_randomScreamAmbient) : 0) == 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream2")), SoundSource.HOSTILE,
									(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream2")), SoundSource.HOSTILE,
									(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
					if (Math.random() < 0.8) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT,
										(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT,
										(float) (double) DeepVoidConfigConfiguration.MASKEDHUNTERSCREAMDISTANCE.get(), (float) Mth.nextDouble(RandomSource.create(), 0.9, 1), false);
							}
						}
					}
				}
			}
		} else {
			if (entity instanceof MaskedHunterEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MaskedHunterEntity.DATA_screamAmbient, (int) ((entity instanceof MaskedHunterEntity _datEntI ? _datEntI.getEntityData().get(MaskedHunterEntity.DATA_screamAmbient) : 0) + 1));
		}
		if (entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(TheDeepVoidModMobEffects.ROT.get()) || entity instanceof LivingEntity _livEnt62 && _livEnt62.hasEffect(MobEffects.POISON)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheDeepVoidModMobEffects.ROT.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.POISON);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
			}
		}
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
	}
}
