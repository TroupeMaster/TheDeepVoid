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
import net.mcreator.thedeepvoid.entity.AmalgamEntity;

import java.util.List;
import java.util.Comparator;

public class AmalgamOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_roar) : 0) >= 100) {
			if (entity instanceof AmalgamEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AmalgamEntity.DATA_roar, 0);
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
			if (entity instanceof AmalgamEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AmalgamEntity.DATA_roar, (int) ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_roar) : 0) + 1));
		}
		if (entity.getDeltaMovement().x() != 0 && entity.getDeltaMovement().z() != 0) {
			if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_step) : 0) >= 5) {
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_step, 0);
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
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_step, (int) ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_step) : 0) + 1));
			}
		}
	}
}
