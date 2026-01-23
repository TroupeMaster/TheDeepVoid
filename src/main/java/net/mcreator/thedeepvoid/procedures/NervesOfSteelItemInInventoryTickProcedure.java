package net.mcreator.thedeepvoid.procedures;

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
		if (!((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) && entity.getPersistentData().getDouble("nervesBowPulling") > 0) {
			entity.getPersistentData().putDouble("nervesBowPulling", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity.getPersistentData().getBoolean("nervesBowLoading") == true) {
				if ((entity instanceof LivingEntity _entUseItem12 ? _entUseItem12.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem() && entity.getPersistentData().getDouble("nervesBowPulling") < 60) {
					entity.getPersistentData().putDouble("nervesBowPulling", (entity.getPersistentData().getDouble("nervesBowPulling") + 1));
					if (entity.getPersistentData().getDouble("nervesBowPulling") == 35) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit_player")), SoundSource.PLAYERS, (float) 0.4,
										(float) 1.2);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit_player")), SoundSource.PLAYERS, (float) 0.4, (float) 1.2, false);
							}
						}
					}
					if (entity.getPersistentData().getDouble("nervesBowPulling") >= 35 && entity.getPersistentData().getDouble("nervesBowPulling") <= 37) {
						itemstack.getOrCreateTag().putDouble("glow", 1);
					} else {
						itemstack.getOrCreateTag().putDouble("glow", 0);
					}
				}
			} else {
				entity.getPersistentData().putBoolean("nervesBowLoading", false);
				entity.getPersistentData().putDouble("nervesBowPulling", 0);
			}
		}
	}
}
