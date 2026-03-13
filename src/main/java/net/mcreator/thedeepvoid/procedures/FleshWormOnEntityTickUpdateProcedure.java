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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.FleshWormEntity;

public class FleshWormOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWall()) {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getX()), (entity.getY() + 1), (entity.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())
				&& (entity instanceof FleshWormEntity _datEntL10 && _datEntL10.getEntityData().get(FleshWormEntity.DATA_teleporting)) == false
				&& (entity instanceof FleshWormEntity _datEntL11 && _datEntL11.getEntityData().get(FleshWormEntity.DATA_spawning)) == false
				&& (entity instanceof FleshWormEntity _datEntL12 && _datEntL12.getEntityData().get(FleshWormEntity.DATA_attackFromBelow)) == false) {
			FleshWormTeleportProcedure.execute(world, entity);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof FleshWormEntity _datEntL15 && _datEntL15.getEntityData().get(FleshWormEntity.DATA_spawning)) == false) {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_attackChance, (int) ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) == 100) {
			FleshWormMeleeAttackProcedure.execute(world, entity);
		} else if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) == 160) {
			if (Math.random() < 0.5 && (entity instanceof FleshWormEntity _datEntL20 && _datEntL20.getEntityData().get(FleshWormEntity.DATA_teleporting)) == false) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					FleshWormTeleportAttackProcedure.execute(world, entity);
				}
			}
		} else if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) == 200) {
			FleshWormMeleeAttackProcedure.execute(world, entity);
		} else if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) == 260) {
			FleshWormAttackFromBelowProcedure.execute(world, entity);
		} else if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) == 320) {
			FleshWormSpitProcedure.execute(world, entity);
		} else if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) == 380) {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_attackChance, 0);
		}
		if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_sound) : 0) >= 400) {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_sound, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_worm_scream")), SoundSource.HOSTILE, 10,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_worm_scream")), SoundSource.HOSTILE, 10,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
		} else {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_sound, (int) ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_sound) : 0) + 1));
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null || (entity instanceof FleshWormEntity _datEntL39 && _datEntL39.getEntityData().get(FleshWormEntity.DATA_spawning)) == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
