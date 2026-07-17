package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.concurrent.atomic.AtomicReference;

public class PlagueDoctorGloveLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (itemstackiterator.is(ItemTags.create(new ResourceLocation("the_deep_void:needles")))) {
						if (itemstackiterator.getItem() == TheDeepVoidModItems.GLOWING_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1800, 0));
						} else if (itemstackiterator.getItem() == TheDeepVoidModItems.ROT_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 200, 0));
						} else if (itemstackiterator.getItem() == TheDeepVoidModItems.HEXED_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.HEXED.get(), 1200, 0));
						} else if (itemstackiterator.getItem() == TheDeepVoidModItems.POISON_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
						} else if (itemstackiterator.getItem() == TheDeepVoidModItems.WITHER_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
						} else if (itemstackiterator.getItem() == TheDeepVoidModItems.INSTANT_DAMAGE_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 0));
						} else if (itemstackiterator.getItem() == TheDeepVoidModItems.WEAKNESS_NEEDLE.get()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0));
						}
					}
				}
			}
		}
		if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.GLOWING_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.GLOWING_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.ROT_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.ROT_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.HEXED_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.HEXED_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.POISON_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.POISON_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.WITHER_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.WITHER_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.INSTANT_DAMAGE_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.INSTANT_DAMAGE_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheDeepVoidModItems.WEAKNESS_NEEDLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheDeepVoidModItems.WEAKNESS_NEEDLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
