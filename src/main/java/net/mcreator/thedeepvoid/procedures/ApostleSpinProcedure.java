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

import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;

public class ApostleSpinProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ApostleOfCatastropheEntity) {
			((ApostleOfCatastropheEntity) entity).setAnimation("empty");
		}
		if (entity instanceof ApostleOfCatastropheEntity) {
			((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_spin");
		}
		if (entity instanceof ApostleOfCatastropheEntity _datEntSetL)
			_datEntSetL.getEntityData().set(ApostleOfCatastropheEntity.DATA_spinning, true);
		if (world instanceof Level)
			((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_hysterical_laugh")), SoundSource.HOSTILE, 4, 1, false);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 75, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 75, 1, false, false));
	}
}
