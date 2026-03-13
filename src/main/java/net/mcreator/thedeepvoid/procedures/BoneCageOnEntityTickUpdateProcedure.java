package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.entity.BoneCageEntity;

import java.util.Comparator;

public class BoneCageOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.BONE_CAGE_CLOSED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.BONE_CAGE_CLOSED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).isEmpty()) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)))) && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.BONE_CAGE_CLOSED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).isEmpty()) {
			if ((entity instanceof BoneCageEntity _datEntI ? _datEntI.getEntityData().get(BoneCageEntity.DATA_lure) : 0) <= 0) {
				if (entity instanceof BoneCageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BoneCageEntity.DATA_lure, 400);
				if (((Entity) world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity)
					_entity.getNavigation().moveTo(x, y, z, 1);
			} else {
				if (entity instanceof BoneCageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BoneCageEntity.DATA_lure, (int) ((entity instanceof BoneCageEntity _datEntI ? _datEntI.getEntityData().get(BoneCageEntity.DATA_lure) : 0) - 1));
			}
		}
		if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).isEmpty()) {
			if ((entity instanceof BoneCageEntity _datEntI ? _datEntI.getEntityData().get(BoneCageEntity.DATA_lure) : 0) <= 0) {
				if (entity instanceof BoneCageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BoneCageEntity.DATA_lure, 400);
				if (((Entity) world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity)
					_entity.getNavigation().moveTo(x, y, z, 1);
			} else {
				if (entity instanceof BoneCageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BoneCageEntity.DATA_lure, (int) ((entity instanceof BoneCageEntity _datEntI ? _datEntI.getEntityData().get(BoneCageEntity.DATA_lure) : 0) - 1));
			}
		}
		if (!world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty() && (!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty() || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 999);
		}
		if ((entity instanceof BoneCageEntity _datEntI ? _datEntI.getEntityData().get(BoneCageEntity.DATA_despawn) : 0) >= 3400) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof BoneCageEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BoneCageEntity.DATA_despawn, (int) ((entity instanceof BoneCageEntity _datEntI ? _datEntI.getEntityData().get(BoneCageEntity.DATA_despawn) : 0) + 1));
		}
	}
}
