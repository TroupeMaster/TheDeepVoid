package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.ExecutionerEntity;

public class ExecutionerEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity && sourceentity.isSprinting() && sourceentity.onGround() && (entity instanceof ExecutionerEntity _datEntL3 && _datEntL3.getEntityData().get(ExecutionerEntity.DATA_attacking)) == false
				&& (entity instanceof ExecutionerEntity _datEntI ? _datEntI.getEntityData().get(ExecutionerEntity.DATA_stunCooldown) : 0) <= 0) {
			if (entity instanceof ExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ExecutionerEntity.DATA_stunCooldown, (int) (300 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Enchantments.KNOCKBACK) * 20));
			if (entity instanceof ExecutionerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_stunned, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.stunned")), SoundSource.HOSTILE, 1, (float) 0.9);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.stunned")), SoundSource.HOSTILE, 1, (float) 0.9, false);
				}
			}
		}
	}
}
