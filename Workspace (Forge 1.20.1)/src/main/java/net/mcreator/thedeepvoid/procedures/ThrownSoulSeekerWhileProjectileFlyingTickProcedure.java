package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ThrownSoulSeekerWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.2, 0, 0, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0, 0, 0.2, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.2, 0, 0, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0, 0, 0.2, 0.2);
		if (entity.getPersistentData().getDouble("deep_void:slashSound") >= 10) {
			entity.getPersistentData().putDouble("deep_void:slashSound", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.PLAYERS, 1, (float) 1.1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.PLAYERS, 1, (float) 1.1, false);
				}
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:slashSound", (entity.getPersistentData().getDouble("deep_void:slashSound") + 1));
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity) {
					if (!(entityiterator == entity) && !(entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("deep_void:OwnedBy"))) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity), 5);
						entity.getPersistentData().putDouble("deep_void:scytheBloodAmount", (entity.getPersistentData().getDouble("deep_void:scytheBloodAmount") + 0.1));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL, (entityiterator.getX()), (entityiterator.getY() + 1.2), (entityiterator.getZ()), 2, 0.1, 0.1, 0.1, 0.1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BLOOD.get()), (entityiterator.getX()), (entityiterator.getY() + 1.2), (entityiterator.getZ()), 2, 0.1, 0.2, 0.1, 0.1);
					}
				}
			}
		}
		TheDeepVoidMod.queueServerWork(60, () -> {
			entity.getPersistentData().putBoolean("deep_void:comeBack", true);
		});
		if (entity.getPersistentData().getBoolean("deep_void:comeBack") == true) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("deep_void:OwnedBy"))) {
						entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.14), ((entityiterator.getY() - entity.getY()) * 0.14), ((entityiterator.getZ() - entity.getZ()) * 0.14)));
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("deep_void:OwnedBy"))) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + entity.getPersistentData().getDouble("deep_void:scytheBloodAmount")));
						if (!entity.level().isClientSide())
							entity.discard();
					}
				}
			}
		}
	}
}
