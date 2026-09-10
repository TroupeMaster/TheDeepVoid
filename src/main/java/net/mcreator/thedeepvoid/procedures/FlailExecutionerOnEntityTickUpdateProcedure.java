package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.FlailExecutionerEntity;

public class FlailExecutionerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
				&& (entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_stun) : 0) <= 0
				&& (entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_attacking) : 0) <= 0
				&& (entity instanceof FlailExecutionerEntity _datEntL5 && _datEntL5.getEntityData().get(FlailExecutionerEntity.DATA_flailThrow)) == false) {
			if (entity instanceof FlailExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attackChance, (int) ((entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_attacking) : 0) > 0) {
			if (entity instanceof FlailExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attacking, (int) ((entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_attacking) : 0) - 1));
		}
		if ((entity instanceof FlailExecutionerEntity _datEntI
				? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_attackChance)
				: 0) >= ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 10 : 40)
				&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			rnd = Mth.nextInt(RandomSource.create(), 1, 3);
			if (rnd == 1) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 11, 11, 11), e -> true).isEmpty()) {
					FlailExecutionerSwingProcedure.execute(world, entity);
				} else {
					if (entity instanceof FlailExecutionerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attackChance, 40);
				}
			} else if (rnd == 2) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 11, 11, 11), e -> true).isEmpty()) {
					FlailExecutionerSmashProcedure.execute(world, x, y, z, entity);
				} else {
					if (entity instanceof FlailExecutionerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attackChance, 40);
				}
			} else if (rnd == 3) {
				if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 11, 11, 11), e -> true).isEmpty())) {
					FlailExecutionerThrowProcedure.execute(world, x, z, entity);
				} else {
					if (entity instanceof FlailExecutionerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_attackChance, 40);
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0, false, false));
		}
		if ((entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_stun) : 0) > 0) {
			if ((entity instanceof FlailExecutionerEntity _datEntL27 && _datEntL27.getEntityData().get(FlailExecutionerEntity.DATA_stunned)) == false) {
				if (entity instanceof FlailExecutionerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FlailExecutionerEntity.DATA_stunned, true);
				if (entity instanceof FlailExecutionerEntity) {
					((FlailExecutionerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof FlailExecutionerEntity) {
					((FlailExecutionerEntity) entity).setAnimation("animation.flail_stun");
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.stunned")), SoundSource.HOSTILE, 2, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.stunned")), SoundSource.HOSTILE, 2, (float) 0.8, false);
					}
				}
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 10);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 99, false, false));
			if (entity instanceof FlailExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlailExecutionerEntity.DATA_stun, (int) ((entity instanceof FlailExecutionerEntity _datEntI ? _datEntI.getEntityData().get(FlailExecutionerEntity.DATA_stun) : 0)
						- ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 2 : 1)));
		} else if ((entity instanceof FlailExecutionerEntity _datEntL40 && _datEntL40.getEntityData().get(FlailExecutionerEntity.DATA_stunned)) == true) {
			if (entity instanceof FlailExecutionerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FlailExecutionerEntity.DATA_stunned, false);
			if (entity instanceof FlailExecutionerEntity) {
				((FlailExecutionerEntity) entity).setAnimation("empty");
			}
		}
		if ((entity instanceof FlailExecutionerEntity _datEntL43 && _datEntL43.getEntityData().get(FlailExecutionerEntity.DATA_flailThrow)) == true
				&& (entity instanceof FlailExecutionerEntity _datEntL44 && _datEntL44.getEntityData().get(FlailExecutionerEntity.DATA_changeTexture)) == false) {
			if (entity instanceof FlailExecutionerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FlailExecutionerEntity.DATA_changeTexture, true);
			if (entity instanceof FlailExecutionerEntity animatable)
				animatable.setTexture("flail_executioner_noflail");
		} else if ((entity instanceof FlailExecutionerEntity _datEntL47 && _datEntL47.getEntityData().get(FlailExecutionerEntity.DATA_flailThrow)) == false
				&& (entity instanceof FlailExecutionerEntity _datEntL48 && _datEntL48.getEntityData().get(FlailExecutionerEntity.DATA_changeTexture)) == true) {
			if (entity instanceof FlailExecutionerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FlailExecutionerEntity.DATA_changeTexture, false);
			if (entity instanceof FlailExecutionerEntity animatable)
				animatable.setTexture("flail_executioner");
		}
	}
}
