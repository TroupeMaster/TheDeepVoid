package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FleshWormAirProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FleshWormEntity _datEntSetL)
			_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, true);
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("animation.fleshWorm_air");
		}
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2, (float) 0.8);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2, (float) 0.8, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DEEPSLATE_PEBBLE.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), -1, 1)), (entity.getY() + 0.5),
						(entity.getZ() + Mth.nextDouble(RandomSource.create(), -1, 1)), 12, 0.25, 1, 0.25, 0.5);
			if (entity instanceof FleshWormEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FleshWormEntity.DATA_spit, true);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putDouble("xLook", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				entity.getPersistentData().putDouble("zLook", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
				entity.setDeltaMovement(
						new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.3), 1.6, (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.3)));
			}
		});
		TheDeepVoidMod.queueServerWork(50, () -> {
			if (entity instanceof FleshWormEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FleshWormEntity.DATA_spit, false);
		});
		TheDeepVoidMod.queueServerWork(80, () -> {
			if (entity instanceof FleshWormEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, false);
			if (entity instanceof FleshWormEntity) {
				((FleshWormEntity) entity).setAnimation("empty");
			}
			if (entity instanceof FleshWormEntity) {
				((FleshWormEntity) entity).setAnimation("animation.fleshWorm_appear");
			}
		});
	}
}
