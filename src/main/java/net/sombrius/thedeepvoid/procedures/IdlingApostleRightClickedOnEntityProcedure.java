package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;
import net.sombrius.thedeepvoid.init.TheDeepVoidModEntities;
import net.sombrius.thedeepvoid.entity.IdlingApostleEntity;
import net.sombrius.thedeepvoid.entity.ApostleBossEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class IdlingApostleRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CHAINS_OF_BINDING.get()) {
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
			}.checkGamemode(sourceentity))) {
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_bind")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_bind")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			if (world instanceof ServerLevel _serverLevel) {
				Entity entityinstance = TheDeepVoidModEntities.APOSTLE_BOSS.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
				if (entityinstance != null) {
					entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
					entityinstance.getPersistentData().putDouble("binding", 180);
					if (entityinstance instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 180, 0, false, false));
					if (entityinstance instanceof ApostleBossEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, true);
					_serverLevel.addFreshEntity(entityinstance);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (sourceentity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) {
				if (entity instanceof IdlingApostleEntity _datEntSetI)
					_datEntSetI.getEntityData().set(IdlingApostleEntity.DATA_apostleDiscuss, (int) ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) + 1));
				if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line1").getString())), false);
					if (entity instanceof IdlingApostleEntity _datEntSetL)
						_datEntSetL.getEntityData().set(IdlingApostleEntity.DATA_talking, true);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line2").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 3) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line3").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 4) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line4").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 5) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line5").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 6) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line6").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 7) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line7").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 8) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line8").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 9) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line9").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 10) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line10").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 11) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line11").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 12) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line12").getString())), false);
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_apostleDiscuss) : 0) == 13) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line13").getString())), false);
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))), sourceentity), 1);
				}
			}
		}
	}
}
