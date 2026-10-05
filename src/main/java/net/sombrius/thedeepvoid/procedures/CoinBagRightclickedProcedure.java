package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class CoinBagRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Math.random() < (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.LUCK)
				? 0.05 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getAmplifier() : 0) + 1) * 0.01
				: 0.05)) {
			itemstack.getOrCreateTag().putDouble("prize", 128);
		} else if (Math.random() < (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.LUCK)
				? 0.1 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getAmplifier() : 0) + 1) * 0.01
				: 0.1)) {
			itemstack.getOrCreateTag().putDouble("prize", 32);
		} else if (Math.random() < (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.LUCK)
				? 0.2 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getAmplifier() : 0) + 1) * 0.01
				: 0.2)) {
			itemstack.getOrCreateTag().putDouble("prize", (Mth.nextInt(RandomSource.create(), 8, 16)));
		} else {
			itemstack.getOrCreateTag().putDouble("prize", (Mth.nextInt(RandomSource.create(), 1, 8)));
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.DARK_STEEL_COIN.get()).copy();
			_setstack.setCount((int) (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.LUCK)
					? Math.round(itemstack.getOrCreateTag().getDouble("prize") * Mth.nextDouble(RandomSource.create(), 1, 1.5))
					: itemstack.getOrCreateTag().getDouble("prize")));
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.drop_contents")), SoundSource.PLAYERS, (float) 0.4, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.drop_contents")), SoundSource.PLAYERS, (float) 0.4, 1, false);
			}
		}
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			itemstack.shrink(1);
		}
	}
}
