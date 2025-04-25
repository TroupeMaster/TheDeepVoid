package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class WeaverOfSoulsTreasureBagRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.shrink(1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.drop_contents")), SoundSource.PLAYERS, 1, (float) 0.9);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.drop_contents")), SoundSource.PLAYERS, 1, (float) 0.9, false);
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.REFINED_CINNABAR.get()).copy();
			_setstack.setCount(24);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.REFINED_BISMUTH.get()).copy();
			_setstack.setCount(12);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
			_setstack.setCount(12);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.ROUGH_VOIDRIUM.get()).copy();
			_setstack.setCount(4);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE).copy();
			_setstack.setCount(2);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.SACRED_CINNABAR.get()).copy();
			_setstack.setCount(8);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheDeepVoidModItems.HEXED_DOLL.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (TheDeepVoidModVariables.MapVariables.get(world).weaverFightCount >= 2) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(TheDeepVoidModItems.SOUL_SHARD.get()).copy();
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:i_always_come_back"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}
