package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.ApostleBossEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class ApostleTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
				&& (entity instanceof ApostleBossEntity _datEntL3 && _datEntL3.getEntityData().get(ApostleBossEntity.DATA_doingAttack)) == false
				&& (entity instanceof ApostleBossEntity _datEntL4 && _datEntL4.getEntityData().get(ApostleBossEntity.DATA_jumpGrab)) == false) {
			if (entity instanceof ApostleBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_attackChance, (int) ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof ApostleBossEntity _datEntI
				? _datEntI.getEntityData().get(ApostleBossEntity.DATA_attackChance)
				: 0) >= ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / (double) DeepVoidConfigConfiguration.APOSTLESECONDPHASE.get()
						? (double) DeepVoidConfigConfiguration.APOSTLEDELAYSECONDPHASE.get()
						: (double) DeepVoidConfigConfiguration.APOSTLEDELAY.get())) {
			if (entity instanceof ApostleBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_attackChance, 0);
			if (entity instanceof ApostleBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_random,
						Mth.nextInt(RandomSource.create(), 1,
								(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / (double) DeepVoidConfigConfiguration.APOSTLESECONDPHASE.get()
										&& (entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_teleportCount) : 0) == 0 ? 7 : 6)));
			if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 1) {
				ApostleSimpleShootProcedure.execute(world, entity);
			} else if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 2) {
				if (Math.random() < 0.2) {
					ApostleSlash2Procedure.execute(world, entity);
				} else {
					ApostleSlash1Procedure.execute(world, entity);
				}
			} else if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 3) {
				ApostleBackJumpProcedure.execute(world, entity);
			} else if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 4) {
				ApostleSpinAttackProcedure.execute(world, x, y, z, entity);
			} else if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 5) {
				ApostlePierceHeartProcedure.execute(world, x, y, z, entity);
			} else if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 6) {
				ApostleBigSlashProcedure.execute(world, x, z, entity);
			} else if ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_random) : 0) == 7) {
				ApostleTeleportCloneProcedure.execute(world, entity);
			}
		}
		if ((entity instanceof ApostleBossEntity _datEntL27 && _datEntL27.getEntityData().get(ApostleBossEntity.DATA_upMotion)) == true) {
			entity.setDeltaMovement(new Vec3(0, 1.8, 0));
		} else if ((entity instanceof ApostleBossEntity _datEntL29 && _datEntL29.getEntityData().get(ApostleBossEntity.DATA_downMotion)) == true) {
			entity.setDeltaMovement(new Vec3(0, (-2), 0));
		}
		if ((entity instanceof ApostleBossEntity _datEntL31 && _datEntL31.getEntityData().get(ApostleBossEntity.DATA_jumpGrab)) == true) {
			if (entity.onGround()) {
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_jumpGrab, false);
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, false);
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_downMotion, false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 2, (float) 0.8);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 2, (float) 0.8, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.HOSTILE, 2, (float) 0.8);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.HOSTILE, 2, (float) 0.8, false);
					}
				}
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("grabbedByApostle") == true) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
									(float) (double) DeepVoidConfigConfiguration.APOSTLEGRAB.get());
							entityiterator.getPersistentData().putBoolean("grabbedByApostle", false);
							for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 4, 8); index0++) {
								world.levelEvent(2001, BlockPos.containing(entityiterator.getX() + Mth.nextInt(RandomSource.create(), -3, 3) + 0.5, entityiterator.getY() + Mth.nextInt(RandomSource.create(), 0, 1),
										entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -3, 3) + 0.5), Block.getId((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())))));
							}
						}
					}
				}
				if (entity instanceof ApostleBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_grabbedPlayer, false);
			}
		}
		ApostleDoingSpinProcedure.execute(world, entity);
		ApostleTickUpdateAdditionsProcedure.execute(world, x, y, z, entity);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			WeaverBossMusicProcedure.execute(world, x, y, z, entity);
		}
	}
}
