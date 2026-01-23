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
				&& entity.getPersistentData().getBoolean("teleporting") == false && entity.getPersistentData().getBoolean("spawning") == false && entity.getPersistentData().getBoolean("attackFromBelow") == false) {
			FleshWormTeleportProcedure.execute(world, entity);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("spawning") == false) {
			entity.getPersistentData().putDouble("attackCooldown", (entity.getPersistentData().getDouble("attackCooldown") + 1));
		}
		if (entity.getPersistentData().getDouble("attackCooldown") == 100) {
			FleshWormMeleeAttackProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("attackCooldown") == 160) {
			if (Math.random() < 0.5 && entity.getPersistentData().getBoolean("teleporting") == false) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					FleshWormTeleportAttackProcedure.execute(world, entity);
				}
			}
		}
		if (entity.getPersistentData().getDouble("attackCooldown") == 200) {
			FleshWormMeleeAttackProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("attackCooldown") == 260) {
			FleshWormAttackFromBelowProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("attackCooldown") == 320) {
			FleshWormSpitProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("attackCooldown") == 380) {
			entity.getPersistentData().putDouble("attackCooldown", 0);
		}
		if (entity.getPersistentData().getDouble("sound") >= 400) {
			entity.getPersistentData().putDouble("sound", 0);
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
			entity.getPersistentData().putDouble("sound", (entity.getPersistentData().getDouble("sound") + 1));
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null || entity.getPersistentData().getBoolean("spawning") == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
