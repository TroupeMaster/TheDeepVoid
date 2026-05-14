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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FogStartCaveProcedure {
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
		if (DeepVoidConfigConfiguration.DEEPVOIDFOG.get() == true) {
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void")) && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity.getY() <= 40 && entity.getY() >= 1 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setShape(FogShape.SPHERE);
				}
				if (entity.getY() <= 40 && entity.getY() > 38 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(100, 120);
				} else if (entity.getY() <= 38 && entity.getY() > 36 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(95, 115);
				} else if (entity.getY() <= 36 && entity.getY() > 34 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(90, 110);
				} else if (entity.getY() <= 34 && entity.getY() > 32 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(85, 105);
				} else if (entity.getY() <= 32 && entity.getY() > 30 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(80, 100);
				} else if (entity.getY() <= 30 && entity.getY() > 28 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(75, 95);
				} else if (entity.getY() <= 28 && entity.getY() > 26 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(70, 90);
				} else if (entity.getY() <= 26 && entity.getY() > 24 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(65, 85);
				} else if (entity.getY() <= 24 && entity.getY() > 22 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(60, 80);
				} else if (entity.getY() <= 22 && entity.getY() > 20 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(55, 75);
				} else if (entity.getY() <= 20 && entity.getY() > 18 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(50, 75);
				} else if (entity.getY() <= 18 && entity.getY() > 16 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(45, 70);
				} else if (entity.getY() <= 16 && entity.getY() > 14 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(40, 65);
				} else if (entity.getY() <= 14 && entity.getY() > 12 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(35, 60);
				} else if (entity.getY() <= 12 && entity.getY() > 10 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(30, 55);
				} else if (entity.getY() <= 10 && entity.getY() > 8 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(25, 50);
				} else if (entity.getY() <= 8 && entity.getY() > 6 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(20, 45);
				} else if (entity.getY() <= 6 && entity.getY() > 4 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(15, 40);
				} else if (entity.getY() <= 4 && entity.getY() > 2 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(10, 35);
				} else if (entity.getY() == 3 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(10, 30);
				} else if (entity.getY() == 2 && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:force_fog")))) {
					setDistance(10, 25);
				} else if (entity.getY() <= 1 && !(entity instanceof LivingEntity _livEnt92 && _livEnt92.hasEffect(TheDeepVoidModMobEffects.HALLUCINATE.get()))) {
					setDistance(10, 20);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:staring_hills"))) {
				if (entity.getY() > 40 && !(!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
					setDistance(80, 180);
					setShape(FogShape.CYLINDER);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:grim_canopy")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:deep_marrows"))) {
				if (entity.getY() > 40 && !(!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
					setDistance(50, 120);
					setShape(FogShape.CYLINDER);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:watching_undergrowth"))) {
				if (entity.getY() > 40 && !(!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
					setDistance(5, 80);
					setShape(FogShape.CYLINDER);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
				if (entity.getY() > 40 && !(!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
					setDistance(35, 100);
					setShape(FogShape.CYLINDER);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gaol_of_heretics"))) {
				if (entity.getY() > 40 && !(!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
					setDistance(50, 120);
					setShape(FogShape.CYLINDER);
				}
			}
		}
	}
}
