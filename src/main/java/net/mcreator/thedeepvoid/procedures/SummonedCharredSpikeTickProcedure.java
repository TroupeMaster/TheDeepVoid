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
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.SummonedCharredSpikeEntity;

import java.util.List;
import java.util.Comparator;

public class SummonedCharredSpikeTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("deep_void:spikeDamage") >= 10) {
			entity.getPersistentData().putDouble("deep_void:spikeDamage", 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator instanceof SummonedCharredSpikeEntity) && !(entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("deep_void:summonedBy"))) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity), 2);
						entity.getPersistentData().putDouble("deep_void:attacking", 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("enchant.thorns.hit")), SoundSource.HOSTILE,
										1, (float) 0.8);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("enchant.thorns.hit")), SoundSource.HOSTILE, 1, (float) 0.8,
										false);
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("deep_void:summonedBy"))) {
						if (entity.getPersistentData().getDouble("deep_void:attacking") >= 1) {
							entity.getPersistentData().putDouble("deep_void:attacking", 0);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 0.5));
						}
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:spikeDamage", (entity.getPersistentData().getDouble("deep_void:spikeDamage") + 1));
		}
		if (entity.getPersistentData().getDouble("deep_void:despawnTimer") >= 100) {
			entity.getPersistentData().putDouble("deep_void:despawnTimer", 0);
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BLOOD.get()), x, (y + 0.5), z, 8, 0.1, 0.2, 0.1, 0.1);
		} else {
			entity.getPersistentData().putDouble("deep_void:despawnTimer", (entity.getPersistentData().getDouble("deep_void:despawnTimer") + 1));
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}
