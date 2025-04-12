package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.ThrownSoulSeekerEntity;
import net.mcreator.thedeepvoid.entity.SummonedCharredSpikeEntity;
import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.ShadowEntity;
import net.mcreator.thedeepvoid.entity.RootedCloneEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.DeathMawHiddenEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.entity.CharredSpikeEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LightAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LightEntity) {
			if (!(sourceentity instanceof ShadowEntity)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
				TheDeepVoidMod.queueServerWork(15, () -> {
					if (!sourceentity.level().isClientSide())
						sourceentity.discard();
				});
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
					TheDeepVoidMod.queueServerWork(15, () -> {
						world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
					});
				}
			}
			if (sourceentity instanceof StalkingStalkerEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
					TheDeepVoidMod.queueServerWork(15, () -> {
						world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
					});
				}
			}
			if (sourceentity instanceof DamnedEntity || sourceentity instanceof BigEyeEntity || sourceentity instanceof CrossEyesEntity || sourceentity instanceof FourEyesEntity || sourceentity instanceof MultipleEyesEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
					world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
				}
			}
		}
		if (entity instanceof SulfurTntEntityEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if (entity instanceof RootedCloneEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if (entity instanceof DeathMawHiddenEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if (entity instanceof ThrownSoulSeekerEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if (entity instanceof CharredSpikeEntity || entity instanceof SummonedCharredSpikeEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if (entity instanceof ShadowEntity) {
			if (sourceentity instanceof Player) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 10, (Mth.nextDouble(RandomSource.create(), -0.01, 0.01)), 1, (Mth.nextDouble(RandomSource.create(), -0.01, 0.01)), 0.4);
			}
		}
	}
}
