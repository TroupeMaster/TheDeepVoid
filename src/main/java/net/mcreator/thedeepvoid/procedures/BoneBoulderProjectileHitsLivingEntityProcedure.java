package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BoneBoulderProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getItem(), 200);
			{
				ItemStack _ist = (entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY);
				if (_ist.hurt(35, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.stopUsingItem();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, (float) 0.7);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, (float) 0.7, false);
				}
			}
		}
	}
}
