package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ApostleGrabProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ApostleOfCatastropheEntity) {
			((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_noEscape");
		}
		if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
			_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_noEscape, true);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 2, (float) 1.2);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 2, (float) 1.2, false);
			}
		}
		TheDeepVoidMod.queueServerWork(18, () -> {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.45), 0.055, (Math.cos(Math.toRadians(entity.getYRot())) * 1.45)));
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
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
							{
								boolean _setval = true;
								entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.noEscape = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
						}
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(35, () -> {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
				if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).noEscape == false) {
					if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_noEscape, false);
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					}
					if (entity instanceof ApostleOfCatastropheEntity) {
						((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_meleeNew");
					}
					if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_missedGrab, true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
				}
			}
		});
		TheDeepVoidMod.queueServerWork(57, () -> {
			if ((entity instanceof ApostleOfCatastropheEntity _datEntL43 && _datEntL43.getEntityData().get(ApostleOfCatastropheEntity.DATA_missedGrab)) == true) {
				if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_missedGrab, false);
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
							if ((entityiterator instanceof LivingEntity _entUseItem50 ? _entUseItem50.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (entityiterator instanceof Player _player)
									_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem52 ? _entUseItem52.getUseItem() : ItemStack.EMPTY).getItem(), 60);
								{
									ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem54 ? _entUseItem54.getUseItem() : ItemStack.EMPTY);
									if (_ist.hurt(4, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							} else {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
										(float) (double) DeepVoidConfigConfiguration.APOSTLEMISSGRABMELEE.get());
								entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.5), 0.055, (Math.cos(Math.toRadians(entity.getYRot())) * 0.5)));
							}
						}
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(62, () -> {
			if ((entity instanceof ApostleOfCatastropheEntity _datEntL64 && _datEntL64.getEntityData().get(ApostleOfCatastropheEntity.DATA_noEscape)) == true) {
				if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_noEscape, false);
			}
		});
	}
}
