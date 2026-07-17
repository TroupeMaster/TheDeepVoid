package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class AmalgamatedCornucopiaPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 50);
		itemstack.getOrCreateTag().putBoolean("hasFood", false);
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem().isEdible()) {
						itemstack.getOrCreateTag().putBoolean("hasFood", true);
					}
				}
			}
		}
		if (itemstack.getOrCreateTag().getBoolean("hasFood") == false) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.PLAYERS, (float) 0.4, (float) 1.4);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.PLAYERS, (float) 0.4, (float) 1.4, false);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("the_deep_void:food"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_sickness")))), (float) 0.5);
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.aggro")), SoundSource.PLAYERS, (float) 0.4, (float) 1.4);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.aggro")), SoundSource.PLAYERS, (float) 0.4, (float) 1.4, false);
				}
			}
		}
	}
}
