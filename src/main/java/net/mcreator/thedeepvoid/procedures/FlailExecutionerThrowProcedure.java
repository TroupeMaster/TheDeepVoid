package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FlailExecutionerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FlailExecutionerThrowProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FlailExecutionerEntity _datEntSetI)
			_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attackChance, 0);
		if (entity instanceof FlailExecutionerEntity _datEntSetI)
			_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attacking, 35);
		if (entity instanceof FlailExecutionerEntity) {
			((FlailExecutionerEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FlailExecutionerEntity) {
			((FlailExecutionerEntity) entity).setAnimation("animation.flail_throw");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 35, 99, false, false));
		TheDeepVoidMod.queueServerWork(22, () -> {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof FlailExecutionerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FlailExecutionerEntity.DATA_flailThrow, true);
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 2),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snowball.throw")), SoundSource.HOSTILE, 2, (float) 0.5);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snowball.throw")), SoundSource.HOSTILE, 2, (float) 0.5, false);
					}
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = TheDeepVoidModEntities.EXECUTIONER_DARK_STEEL_FLAIL.get().create(_serverLevel, null, null,
							BlockPos.containing(entity.getX() + entity.getLookAngle().x * 1, entity.getY() + 1.5, entity.getZ() + entity.getLookAngle().z * 1), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						entityinstance.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.15),
								((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.5) - entity.getY()) * 0.2), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.15)));
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
				entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-0.15)), (entity.getDeltaMovement().y()), (Math.cos(Math.toRadians(entity.getYRot())) * (-0.15))));
			}
		});
	}
}
