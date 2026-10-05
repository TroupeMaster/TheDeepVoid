package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEnchantments;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BlackHoleInventoryProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) && itemstack.getOrCreateTag().getDouble("pulling") > 0) {
			itemstack.getOrCreateTag().putDouble("pulling", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (itemstack.getOrCreateTag().getBoolean("loading") == true) {
				if ((entity instanceof LivingEntity _entUseItem15 ? _entUseItem15.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem() && itemstack.getOrCreateTag().getDouble("pulling") < 25) {
					itemstack.getOrCreateTag().putDouble("pulling", (itemstack.getOrCreateTag().getDouble("pulling") + 1));
					if (itemstack.getOrCreateTag().getDouble("pulling") == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.loading_start")), SoundSource.PLAYERS, (float) 0.15,
										1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.loading_start")), SoundSource.PLAYERS, (float) 0.15, 1, false);
							}
						}
					} else if (itemstack.getOrCreateTag().getDouble("pulling") == 13) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.loading_middle")), SoundSource.PLAYERS, (float) 0.15,
										1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.loading_middle")), SoundSource.PLAYERS, (float) 0.15, 1, false);
							}
						}
					} else if (itemstack.getOrCreateTag().getDouble("pulling") == 25) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.loading_end")), SoundSource.PLAYERS, (float) 0.15, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.loading_end")), SoundSource.PLAYERS, (float) 0.15, 1, false);
							}
						}
					}
				}
			} else {
				itemstack.getOrCreateTag().putBoolean("loading", false);
				itemstack.getOrCreateTag().putDouble("pulling", 0);
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.DIMENSIONAL_BURST.get(), itemstack) != 0 && itemstack.getOrCreateTag().getDouble("ammo") > (double) DeepVoidConfigConfiguration.BLACKHOLESTORELIMIT.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.ARROW).copy();
				_setstack.setCount((int) (itemstack.getOrCreateTag().getDouble("ammo") - (double) DeepVoidConfigConfiguration.BLACKHOLESTORELIMIT.get()));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemstack.getOrCreateTag().putDouble("ammo", ((double) DeepVoidConfigConfiguration.BLACKHOLESTORELIMIT.get()));
		}
	}
}
