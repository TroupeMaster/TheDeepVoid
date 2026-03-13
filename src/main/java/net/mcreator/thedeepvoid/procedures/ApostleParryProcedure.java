package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ApostleParryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ApostleOfCatastropheEntity) {
			((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_block");
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 3, (float) 1.8);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 3, (float) 1.8, false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
		if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
			_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_parry, true);
		TheDeepVoidMod.queueServerWork(15, () -> {
			if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_parry, false);
		});
	}
}
