package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.List;
import java.util.Comparator;

public class AmalgamOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double roar = 0;
		double step = 0;
		if (entity.getPersistentData().getDouble("deep_void:amalgamRoar") >= 100) {
			entity.getPersistentData().putDouble("deep_void:amalgamRoar", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_ambient")), SoundSource.HOSTILE, 4,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_ambient")), SoundSource.HOSTILE, 4,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
				}
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:amalgamRoar", (entity.getPersistentData().getDouble("deep_void:amalgamRoar") + 1));
		}
		if (entity.getDeltaMovement().x() != 0 && entity.getDeltaMovement().z() != 0) {
			if (entity.getPersistentData().getDouble("deep_void:amalgamStep") >= 5) {
				entity.getPersistentData().putDouble("deep_void:amalgamStep", 0);
				if (!(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.HOSTILE, 4, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:amalgam_step")), SoundSource.HOSTILE, 4, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.TREMBLE.get(), 20, 0, false, false));
								}
							}
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:amalgamStep", (entity.getPersistentData().getDouble("deep_void:amalgamStep") + 1));
			}
		}
	}
}
