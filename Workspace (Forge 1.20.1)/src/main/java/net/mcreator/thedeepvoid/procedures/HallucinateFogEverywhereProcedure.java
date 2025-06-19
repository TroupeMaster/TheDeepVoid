package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HallucinateFogEverywhereProcedure {
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
				execute(provider, level, pos.x(), pos.y(), pos.z(), level.dimension(), entity);
			}
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity) {
		execute(null, world, x, y, z, dimension, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null)
			return;
		if (DeepVoidConfigConfiguration.CREEPINGDARKNESS.get() == true) {
			if (dimension == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)) && !(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.NIGHT_VISION))) {
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
					} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1) {
						setDistance(1, 4);
						setShape(FogShape.SPHERE);
					}
				}
			}
		}
	}
}
