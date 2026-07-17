package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FalseHydraSingingEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.Comparator;

public class FalseHydraSingingOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWall()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		if ((entity instanceof FalseHydraSingingEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraSingingEntity.DATA_timer) : 0) >= (double) DeepVoidConfigConfiguration.HYDRASINGINGDESPAWNTIMER.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a hostile the_deep_void:false_hydra_sing");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a hostile the_deep_void:false_hydra_sing_distorted");
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof FalseHydraSingingEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraSingingEntity.DATA_timer, (int) ((entity instanceof FalseHydraSingingEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraSingingEntity.DATA_timer) : 0) + 1));
		}
		if (!(!(world.getNearestPlayer(entity, 30) == null))) {
			if ((entity instanceof FalseHydraSingingEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraSingingEntity.DATA_sing) : 0) <= 0) {
				if (!(world.getNearestPlayer(entity, 50) == null)) {
					if (entity instanceof FalseHydraSingingEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FalseHydraSingingEntity.DATA_sing, 720);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_sing_distorted")), SoundSource.HOSTILE, 4, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_sing_distorted")), SoundSource.HOSTILE, 4, 1, false);
						}
					}
				} else {
					if (entity instanceof FalseHydraSingingEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FalseHydraSingingEntity.DATA_sing, 820);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_sing")), SoundSource.HOSTILE, 4, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_sing")), SoundSource.HOSTILE, 4, 1, false);
						}
					}
				}
			} else {
				if (entity instanceof FalseHydraSingingEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FalseHydraSingingEntity.DATA_sing, (int) ((entity instanceof FalseHydraSingingEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraSingingEntity.DATA_sing) : 0) - 1));
			}
		} else if (!(world.getNearestPlayer(entity, 30) == null)) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a hostile the_deep_void:false_hydra_sing");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a hostile the_deep_void:false_hydra_sing_distorted");
			if (TheDeepVoidModVariables.MapVariables.get(world).spawnHydra >= (double) DeepVoidConfigConfiguration.SPAWNHYDRAREQUIREDENCOUNTER.get()) {
				TheDeepVoidModVariables.MapVariables.get(world).spawnHydra = 0;
				TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.FALSE_HYDRA.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())));
					if ((entity instanceof FalseHydraSingingEntity _datEntL38 && _datEntL38.getEntityData().get(FalseHydraSingingEntity.DATA_despawn)) == false) {
						if (entity instanceof FalseHydraSingingEntity _datEntSetL)
							_datEntSetL.getEntityData().set(FalseHydraSingingEntity.DATA_despawn, true);
						if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
							TheDeepVoidModVariables.MapVariables.get(world).spawnHydra = TheDeepVoidModVariables.MapVariables.get(world).spawnHydra + 1;
							TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
						}
						TheDeepVoidMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_slide")), SoundSource.HOSTILE, 3, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_slide")), SoundSource.HOSTILE, 3, 1, false);
								}
							}
						});
						TheDeepVoidMod.queueServerWork(20, () -> {
							if (entity instanceof FalseHydraSingingEntity) {
								((FalseHydraSingingEntity) entity).setAnimation("animation.falseHydra_dig");
							}
						});
						TheDeepVoidMod.queueServerWork(60, () -> {
							if (!entity.level().isClientSide())
								entity.discard();
						});
					}
				}
			}
		}
		if ((entity instanceof FalseHydraSingingEntity _datEntL52 && _datEntL52.getEntityData().get(FalseHydraSingingEntity.DATA_despawn)) == true) {
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-2)), (-1), (Math.cos(Math.toRadians(entity.getYRot())) * (-2))));
		}
	}
}
