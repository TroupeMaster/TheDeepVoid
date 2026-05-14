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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.LickerEntity;

import java.util.List;
import java.util.Comparator;

public class LickerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) Double.POSITIVE_INFINITY, 9, false, false));
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 35, 35, 35), e -> true).isEmpty() && (entity instanceof LickerEntity _datEntL2 && _datEntL2.getEntityData().get(LickerEntity.DATA_stunned)) == false) {
			{
				final Vec3 _center = new Vec3(x, (y + 8), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && !entity.isVehicle() && !(new Object() {
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
						entityiterator.startRiding(entity);
						if ((entity instanceof LickerEntity _datEntL10 && _datEntL10.getEntityData().get(LickerEntity.DATA_caughtPrey)) == false) {
							if (entity instanceof LickerEntity) {
								((LickerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof LickerEntity) {
								((LickerEntity) entity).setAnimation("animation.licker_eat");
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, (y + 8), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getVehicle()) == entity) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 4);
					}
				}
			}
		}
		if (!entity.isVehicle() && (entity instanceof LickerEntity _datEntL20 && _datEntL20.getEntityData().get(LickerEntity.DATA_caughtPrey)) == true) {
			if (entity instanceof LickerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(LickerEntity.DATA_caughtPrey, false);
			if (entity instanceof LickerEntity) {
				((LickerEntity) entity).setAnimation("empty");
			}
		}
		if (Math.random() < 0.01 && (entity instanceof LickerEntity _datEntL23 && _datEntL23.getEntityData().get(LickerEntity.DATA_stunned)) == true) {
			if (entity instanceof LickerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(LickerEntity.DATA_stunned, false);
			if (entity instanceof LickerEntity) {
				((LickerEntity) entity).setAnimation("empty");
			}
		}
	}
}
