package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.NightmareEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NightmareHalfHealthProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (entity instanceof NightmareEntity) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 1.5) {
					if (Math.random() < 0.2) {
						if (!(sourceentity.getY() > entity.getY() + 3) && !(sourceentity.getY() < entity.getY() - 3)) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SQUID_INK, x, (y + 1), z, 25, 1, 1, 1, 0.1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								_ent.teleportTo(
										(sourceentity.level()
												.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-1.5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
														sourceentity))
												.getBlockPos().getX()),
										(sourceentity.getY()),
										(sourceentity.level().clip(
												new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-1.5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, sourceentity))
												.getBlockPos().getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(
											(sourceentity.level()
													.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-1.5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
															sourceentity))
													.getBlockPos().getX()),
											(sourceentity.getY()),
											(sourceentity.level().clip(
													new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale((-1.5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, sourceentity))
													.getBlockPos().getZ()),
											_ent.getYRot(), _ent.getXRot());
							}
						}
					}
				}
			}
		}
	}
}
