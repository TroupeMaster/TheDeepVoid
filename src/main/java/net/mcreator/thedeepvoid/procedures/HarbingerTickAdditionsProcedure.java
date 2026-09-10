package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;

import java.util.Comparator;

public class HarbingerTickAdditionsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		double rndX = 0;
		double rndZ = 0;
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntL0 && _datEntL0.getEntityData().get(HarbingerOfCataclysmEntity.DATA_attacking)) == true
				&& (entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_parry) : 0) > 0
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, false);
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_parry, 0);
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 60);
		}
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_parry) : 0) > 0) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_parry, (int) ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_parry) : 0) - 1));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
		}
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_repeat) : 0) >= 4) {
			if ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_repeatCooldown) : 0) >= 80) {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_repeat, 0);
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_repeatCooldown, 0);
			} else {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_repeatCooldown,
							(int) ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_repeatCooldown) : 0) + 1));
			}
		}
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntL16 && _datEntL16.getEntityData().get(HarbingerOfCataclysmEntity.DATA_piercing)) == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES,
						new Vec3((entity.getPersistentData().getDouble("dashX")), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.5), (entity.getPersistentData().getDouble("dashZ"))));
			}
		}
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntL24 && _datEntL24.getEntityData().get(HarbingerOfCataclysmEntity.DATA_teleport)) == true && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_teleport, false);
			success = false;
			for (int index0 = 0; index0 < 100; index0++) {
				rndX = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -5, 5);
				rndZ = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -5, 5);
				if (world.isEmptyBlock(BlockPos.containing(rndX, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(), rndZ))
						&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(rndX, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), rndZ), 4, 4, 4), e -> true).isEmpty())) {
					{
						Entity _ent = entity;
						_ent.teleportTo(rndX, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), rndZ);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(rndX, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), rndZ, _ent.getYRot(), _ent.getXRot());
					}
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.5),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
						_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_teleportAttack, true);
					success = true;
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, (float) 0.8);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, (float) 0.8, false);
						}
					}
					break;
				}
			}
			if (success == false) {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, false);
			}
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
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
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
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
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
				{
					Entity _ent = entity;
					_ent.teleportTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), _ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.6);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.6, false);
					}
				}
			}
		}
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntL73 && _datEntL73.getEntityData().get(HarbingerOfCataclysmEntity.DATA_dying)) == true) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_dyingCooldown, (int) ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_dyingCooldown) : 0) + 1));
			if ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_dyingCooldown) : 0) >= 45
					&& (entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_dyingCooldown) : 0) < 75) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 125, 0, false, false));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.FLAME_OF_SPITE.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 1.25)),
							(entity.getZ() + Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), Mth.nextInt(RandomSource.create(), 8, 16), 0.25, 0.6, 0.25, 0.1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.HOSTILE, (float) 1.5,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.HOSTILE, (float) 1.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
					}
				}
			}
		}
	}
}
