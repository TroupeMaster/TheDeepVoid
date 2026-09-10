package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.item.ApostasyItem;

public class ApostasySwingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("zoom") == false) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 1);
			itemstack.getOrCreateTag().putBoolean("zoom", true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.spyglass.use")), SoundSource.PLAYERS, (float) 0.1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.spyglass.use")), SoundSource.PLAYERS, (float) 0.1, 1, false);
				}
			}
		} else if (itemstack.getOrCreateTag().getBoolean("zoom") == true) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 1);
			itemstack.getOrCreateTag().putBoolean("zoom", false);
			itemstack.getOrCreateTag().putBoolean("zoomAnim", false);
			if (itemstack.getItem() instanceof ApostasyItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "empty");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.spyglass.stop_using")), SoundSource.PLAYERS, (float) 0.1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.spyglass.stop_using")), SoundSource.PLAYERS, (float) 0.1, 1, false);
				}
			}
		}
	}
}
