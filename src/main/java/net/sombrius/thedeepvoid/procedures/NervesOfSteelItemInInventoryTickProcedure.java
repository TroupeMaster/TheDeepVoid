package net.sombrius.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class NervesOfSteelItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) && itemstack.getOrCreateTag().getDouble("pulling") > 0) {
			itemstack.getOrCreateTag().putDouble("pulling", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (itemstack.getOrCreateTag().getBoolean("loading") == true) {
				if ((entity instanceof LivingEntity _entUseItem15 ? _entUseItem15.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem() && itemstack.getOrCreateTag().getDouble("pulling") < 60) {
					itemstack.getOrCreateTag().putDouble("pulling", (itemstack.getOrCreateTag().getDouble("pulling") + 1));
					if (itemstack.getOrCreateTag().getDouble("pulling") == 35) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit_player")), SoundSource.PLAYERS, (float) 0.4,
										(float) 1.2);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit_player")), SoundSource.PLAYERS, (float) 0.4, (float) 1.2, false);
							}
						}
					}
					if (itemstack.getOrCreateTag().getDouble("pulling") >= 35 && itemstack.getOrCreateTag().getDouble("pulling") <= 37) {
						itemstack.getOrCreateTag().putDouble("glow", 1);
					} else {
						itemstack.getOrCreateTag().putDouble("glow", 0);
					}
				}
			} else {
				itemstack.getOrCreateTag().putBoolean("loading", false);
				itemstack.getOrCreateTag().putDouble("pulling", 0);
			}
		}
	}
}
