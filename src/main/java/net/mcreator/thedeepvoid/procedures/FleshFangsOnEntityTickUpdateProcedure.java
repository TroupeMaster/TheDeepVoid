package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.FleshFangsEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class FleshFangsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof FleshFangsEntity _datEntL0 && _datEntL0.getEntityData().get(FleshFangsEntity.DATA_caughtPlayer)) == true && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if ((entity instanceof FleshFangsEntity _datEntL2 && _datEntL2.getEntityData().get(FleshFangsEntity.DATA_animation)) == false) {
				if (entity instanceof FleshFangsEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FleshFangsEntity.DATA_animation, true);
				if (entity instanceof FleshFangsEntity) {
					((FleshFangsEntity) entity).setAnimation("animation.fleshFangs_caught");
				}
			}
		} else if ((entity instanceof FleshFangsEntity _datEntL5 && _datEntL5.getEntityData().get(FleshFangsEntity.DATA_animation)) == true) {
			if (entity instanceof FleshFangsEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FleshFangsEntity.DATA_animation, false);
			if (entity instanceof FleshFangsEntity) {
				((FleshFangsEntity) entity).setAnimation("empty");
			}
		}
		if ((entity instanceof FleshFangsEntity _datEntI ? _datEntI.getEntityData().get(FleshFangsEntity.DATA_despawn) : 0) >= 80) {
			entity.kill();
		} else {
			if (entity instanceof FleshFangsEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshFangsEntity.DATA_despawn, (int) ((entity instanceof FleshFangsEntity _datEntI ? _datEntI.getEntityData().get(FleshFangsEntity.DATA_despawn) : 0) + 1));
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player && !(new Object() {
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
				}.checkGamemode(entityiterator)) && !((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODY_RIB_CAGE_CHESTPLATE.get())) {
					if (!(!world.getEntitiesOfClass(FleshFangsEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 1, 1, 1), e -> true).isEmpty())) {
						if (entity instanceof FleshFangsEntity _datEntSetL)
							_datEntSetL.getEntityData().set(FleshFangsEntity.DATA_caughtPlayer, true);
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), (float) (double) DeepVoidConfigConfiguration.FLESHFANGSDAMAGE.get());
					} else if (!world.getEntitiesOfClass(FleshFangsEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 1, 1, 1), e -> true).isEmpty()
							&& ((Entity) world.getEntitiesOfClass(FleshFangsEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) == entity) {
						if (entity instanceof FleshFangsEntity _datEntSetL)
							_datEntSetL.getEntityData().set(FleshFangsEntity.DATA_caughtPlayer, true);
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), (float) (double) DeepVoidConfigConfiguration.FLESHFANGSDAMAGE.get());
					}
				}
			}
		}
	}
}
