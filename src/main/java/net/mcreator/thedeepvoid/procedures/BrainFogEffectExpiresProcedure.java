package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class BrainFogEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants"))
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getAmplifier() : 0) < 4) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getAmplifier() : 0) == 3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BRAIN_FOG.get(), (int) Double.POSITIVE_INFINITY, 4, true, false));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BRAIN_FOG.get(), (int) (double) DeepVoidConfigConfiguration.BRAINFOGDURATION.get(),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getAmplifier() : 0) + 1), true, false));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:quiet_slow_whisper")), SoundSource.NEUTRAL, (float) 0.1,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:quiet_slow_whisper")), SoundSource.NEUTRAL, (float) 0.1,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
		}
	}
}
