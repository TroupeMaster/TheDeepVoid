package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.VoidbornEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HallucinateFogProcedure {
	public static ViewportEvent.RenderFog provider = null;

	public static void setDistance(float start, float end) {
		provider.setNearPlaneDistance(start);
		provider.setFarPlaneDistance(end);
		if (!provider.isCanceled()) {
			provider.setCanceled(true);
		}
	}

	public static void setShape(FogShape shape) {
		provider.setFogShape(shape);
		if (!provider.isCanceled()) {
			provider.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		provider = event;
		if (provider.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
			ClientLevel level = Minecraft.getInstance().level;
			Entity entity = provider.getCamera().getEntity();
			if (level != null && entity != null) {
				Vec3 pos = entity.getPosition((float) provider.getPartialTick());
				execute(provider, level, pos.x(), pos.y(), pos.z(), entity);
			}
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.HALLUCINATE.get()) && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 8) {
				setDistance(10, 14);
				setShape(FogShape.SPHERE);
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 8 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 6) {
				setDistance(8, 12);
				setShape(FogShape.SPHERE);
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 6 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 4) {
				setDistance(6, 10);
				setShape(FogShape.SPHERE);
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 4 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 2) {
				setDistance(4, 8);
				setShape(FogShape.SPHERE);
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 2 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 1) {
				setDistance(2, 6);
				setShape(FogShape.SPHERE);
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 1) {
				setDistance(1, 4);
				setShape(FogShape.SPHERE);
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0) {
				setDistance(0, 1);
				setShape(FogShape.SPHERE);
				if (!(!world.getEntitiesOfClass(VoidbornEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(TheDeepVoidModMobEffects.PAIN_KILLER.get()))
						&& !(entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get()))) {
					if (entity.getPersistentData().getDouble("voidbornSpawn") >= (double) DeepVoidConfigConfiguration.VOIDBORNSPAWNTIMER.get()) {
						entity.getPersistentData().putDouble("voidbornSpawn", 0);
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.VOIDBORN.get().spawn(_level,
									BlockPos.containing(
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-10))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-10))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getZ()),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof VoidbornEntity) {
									if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("voidbornSpawn", (entity.getPersistentData().getDouble("voidbornSpawn") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("voidbornSpawn") == (double) DeepVoidConfigConfiguration.VOIDBORNSPAWNTIMER.get() / 2) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
						}
					}
				} else if (entity.getPersistentData().getDouble("voidbornSpawn") == (double) DeepVoidConfigConfiguration.VOIDBORNSPAWNTIMER.get() / 1.2) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
						}
					}
				}
			}
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 0 && entity.getPersistentData().getDouble("voidbornSpawn") > 0) {
				entity.getPersistentData().putDouble("voidbornSpawn", (entity.getPersistentData().getDouble("voidbornSpawn") - 1));
			}
		}
	}
}
