package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class HandsOfTheAberrationOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / (4 + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100)) {
			if (entity.isInWall()) {
				if (!(entity instanceof Player)) {
					if (entity instanceof LivingEntity _entity7)
						_entity7.skipDropExperience();
				}
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 999);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.HOSTILE, 1, (float) 0.7);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.HOSTILE, 1, (float) 0.7, false);
							}
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
						entity.kill();
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.HOSTILE, 1, (float) 0.7);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.HOSTILE, 1, (float) 0.7, false);
							}
						}
					}
				}
			} else {
				if (entity instanceof Player) {
					{
						Entity _ent = entity;
						_ent.teleportTo((entity.getX()), (entity.getY() - 0.1), (entity.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getX()), (entity.getY() - 0.1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
					}
				} else {
					{
						Entity _ent = entity;
						_ent.teleportTo((entity.getX()), (entity.getY() - 0.005), (entity.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getX()), (entity.getY() - 0.005), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
