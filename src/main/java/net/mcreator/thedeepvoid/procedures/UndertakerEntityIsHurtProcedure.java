package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.entity.UndertakerEntity;
import net.mcreator.thedeepvoid.entity.ThrownNoxiousBrewEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UndertakerEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double dialogue = 0;
		if (entity instanceof UndertakerEntity && !(immediatesourceentity instanceof ThrownNoxiousBrewEntity) && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(sourceentity))) {
			if (entity instanceof UndertakerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndertakerEntity.DATA_dialogueCooldown, 25);
			dialogue = Mth.nextInt(RandomSource.create(), 1, 8);
			if (dialogue == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt1").getString())), false);
			} else if (dialogue == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt2").getString())), false);
			} else if (dialogue == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt3").getString())), false);
			} else if (dialogue == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt4").getString())), false);
			} else if (dialogue == 5) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt5").getString())), false);
			} else if (dialogue == 6) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt6").getString())), false);
			} else if (dialogue == 7) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt7").getString())), false);
			} else if (dialogue == 8) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.hurt8").getString())), false);
			}
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
		}
	}
}
