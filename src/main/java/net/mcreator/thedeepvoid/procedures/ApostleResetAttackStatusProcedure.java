package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.entity.ExecutionerEntity;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class ApostleResetAttackStatusProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()
				&& ((!world.isClientSide() && world.getServer() != null) ? (ServerLifecycleHooks.getCurrentServer().isSingleplayer()) : true)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ApostleBossEntity) {
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_runGrab, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_grabbedPlayer, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_jumpGrab, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_upMotion, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_downMotion, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_canDoGrab, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_spinning, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_throwPlayer, false);
						if (entityiterator instanceof ApostleBossEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_piercedPlayer, false);
					}
				}
			}
			entity.getPersistentData().putBoolean("grabbedByApostle", false);
			entity.getPersistentData().putBoolean("piercedByApostle", false);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheDeepVoidModMobEffects.CHAINED.get());
		}
		if ((!world.getEntitiesOfClass(FleshWormEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty() || !world.getEntitiesOfClass(ExecutionerEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())
				&& ((!world.isClientSide() && world.getServer() != null) ? (ServerLifecycleHooks.getCurrentServer().isSingleplayer()) : true)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof FleshWormEntity) {
						if (entityiterator instanceof FleshWormEntity _datEntSetL)
							_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, false);
						if (entityiterator instanceof FleshWormEntity _datEntSetL)
							_datEntSetL.getEntityData().set(FleshWormEntity.DATA_spit, false);
					} else if (entityiterator instanceof ExecutionerEntity) {
						if (entityiterator instanceof ExecutionerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_attacking, false);
					}
				}
			}
			entity.getPersistentData().putBoolean("grabbedByExecutioner", false);
		}
	}
}
