package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.world.inventory.UndertakerTradeGuiMenu;
import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.UndertakerEntity;

import io.netty.buffer.Unpooled;

public class UndertakerRightClickedOnEntityProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return InteractionResult.PASS;
		double dialogue = 0;
		if ((entity instanceof UndertakerEntity _datEntL0 && _datEntL0.getEntityData().get(UndertakerEntity.DATA_talkedTo)) == false) {
			if (entity instanceof UndertakerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(UndertakerEntity.DATA_talkedTo, true);
			if (entity instanceof UndertakerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndertakerEntity.DATA_talkCooldown, 40);
			if (TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled == true) {
				TheDeepVoidModVariables.MapVariables.get(world).undertakerKilled = false;
				TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof UndertakerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(UndertakerEntity.DATA_angry, true);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.killed").getString())), false);
			} else {
				UndertakerRandomBiomeDialogueProcedure.execute(world, x, y, z, sourceentity);
			}
			return InteractionResult.PASS;
		} else if ((entity instanceof UndertakerEntity _datEntL8 && _datEntL8.getEntityData().get(UndertakerEntity.DATA_empty)) == true && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_dialogueCooldown) : 0) <= 0) {
				if (entity instanceof UndertakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndertakerEntity.DATA_dialogueCooldown, 25);
				dialogue = Mth.nextInt(RandomSource.create(), 1, 8);
				if (dialogue == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout1").getString())), false);
				} else if (dialogue == 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout2").getString())), false);
				} else if (dialogue == 3) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout3").getString())), false);
				} else if (dialogue == 4) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout4").getString())), false);
				} else if (dialogue == 5) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout5").getString())), false);
				} else if (dialogue == 6) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout6").getString())), false);
				} else if (dialogue == 7) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout7").getString())), false);
				} else if (dialogue == 8) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.stockout8").getString())), false);
				}
			}
			return InteractionResult.PASS;
		} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null && !(entity instanceof LivingEntity _livEnt41 && _livEnt41.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))
				&& (entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_talkCooldown) : 0) <= 0) {
			sourceentity.getPersistentData().putString("undertakerUuid", (entity.getStringUUID()));
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("UndertakerTradeGui");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new UndertakerTradeGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if ((entity instanceof UndertakerEntity _datEntI ? _datEntI.getEntityData().get(UndertakerEntity.DATA_dialogueCooldown) : 0) <= 0
					&& (entity instanceof UndertakerEntity _datEntL47 && _datEntL47.getEntityData().get(UndertakerEntity.DATA_angry)) == false) {
				if (entity instanceof UndertakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndertakerEntity.DATA_dialogueCooldown, 25);
				dialogue = Mth.nextInt(RandomSource.create(), 1, 8);
				if (dialogue == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open1").getString())), false);
				} else if (dialogue == 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open2").getString())), false);
				} else if (dialogue == 3) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open3").getString())), false);
				} else if (dialogue == 4) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open4").getString())), false);
				} else if (dialogue == 5) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open5").getString())), false);
				} else if (dialogue == 6) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open6").getString())), false);
				} else if (dialogue == 7) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open7").getString())), false);
				} else if (dialogue == 8) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + Component.translatable("entity.the_deep_void.undertaker").getString() + "> " + Component.translatable("entity.the_deep_void.undertaker.open8").getString())), false);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
