package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class FalseHydraOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if ((entity instanceof FalseHydraEntity _datEntL0 && _datEntL0.getEntityData().get(FalseHydraEntity.DATA_volley)) == false) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y()), 0));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, (int) ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) + 1));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
					((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
		}
		if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) == 60) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, 61);
			FalseHydraApplyDebuffProcedure.execute(world, entity);
		} else if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) == 140) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, 141);
			FalseHydraPokeProcedure.execute(world, entity);
		} else if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) == 180) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, 181);
			FalseHydraSummonArmsProcedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) == 230) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, 231);
			if (!(world.getNearestPlayer(
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), (entity.getY()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), 9,
					true) == null)) {
				FalseHydraSweepProcedure.execute(world, x, z, entity);
			} else {
				FalseHydraThrowBoulderProcedure.execute(world, x, y, z, entity);
			}
		} else if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) == 295) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, 296);
			if (entity instanceof FalseHydraEntity) {
				((FalseHydraEntity) entity).setAnimation("empty");
			}
			if (entity instanceof FalseHydraEntity) {
				((FalseHydraEntity) entity).setAnimation("animation.falseHydra_volley");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_bite")), SoundSource.HOSTILE, 4, (float) 0.8);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_bite")), SoundSource.HOSTILE, 4, (float) 0.8, false);
				}
			}
			TheDeepVoidMod.queueServerWork(30, () -> {
				if (entity instanceof FalseHydraEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FalseHydraEntity.DATA_volley, true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_slide")), SoundSource.HOSTILE, 3, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_slide")), SoundSource.HOSTILE, 3, 1, false);
					}
				}
			});
		} else if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_attackChance) : 0) == 376) {
			if (entity instanceof FalseHydraEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FalseHydraEntity.DATA_volley, false);
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_attackChance, 0);
		}
		FalseHydraVolleyProcedure.execute(world, x, y, z, entity);
		FalseHydraSummonKnockbackArmProcedure.execute(world, x, y, z);
		FalseHydraLaughterProcedure.execute(world, x, y, z, entity);
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty())) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
						if (entityiterator instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get())) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get());
						}
					}
				}
			}
		}
	}
}
