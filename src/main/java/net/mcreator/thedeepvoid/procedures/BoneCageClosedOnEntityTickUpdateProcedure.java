package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.entity.BoneCageClosedEntity;

import java.util.List;
import java.util.Comparator;

public class BoneCageClosedOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Animal || entityiterator instanceof Villager || entityiterator instanceof Player) {
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
					}.checkGamemode(entityiterator)) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entityiterator))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
						entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).isEmpty()
				&& !(!world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty())) {
			if ((entity instanceof BoneCageClosedEntity _datEntI ? _datEntI.getEntityData().get(BoneCageClosedEntity.DATA_findPath) : 0) >= 400) {
				if (entity instanceof BoneCageClosedEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BoneCageClosedEntity.DATA_findPath, 0);
				if ((((Entity) world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
					if (((Entity) world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity)
						_entity.getNavigation().moveTo(x, y, z, 1.5);
					if (!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					} else if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 2.5, 2.5, 2.5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			} else {
				if (entity instanceof BoneCageClosedEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BoneCageClosedEntity.DATA_findPath, (int) ((entity instanceof BoneCageClosedEntity _datEntI ? _datEntI.getEntityData().get(BoneCageClosedEntity.DATA_findPath) : 0) + 1));
			}
		}
		if (!world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty() && (!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty() || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 999);
		}
		if (!(!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) && !(!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 999);
		}
		if ((entity instanceof BoneCageClosedEntity _datEntI ? _datEntI.getEntityData().get(BoneCageClosedEntity.DATA_despawn) : 0) >= 600) {
			if (entity instanceof BoneCageClosedEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BoneCageClosedEntity.DATA_despawn, 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 999);
		} else {
			if (entity instanceof BoneCageClosedEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BoneCageClosedEntity.DATA_despawn, (int) ((entity instanceof BoneCageClosedEntity _datEntI ? _datEntI.getEntityData().get(BoneCageClosedEntity.DATA_despawn) : 0) + 1));
		}
	}
}
