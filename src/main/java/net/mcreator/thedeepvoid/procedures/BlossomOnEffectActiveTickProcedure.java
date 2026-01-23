package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class BlossomOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData()
				.getDouble("blossomTick") >= ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BLOSSOM.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BLOSSOM.get()).getAmplifier() : 0) > 1
						? 80 - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BLOSSOM.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BLOSSOM.get()).getAmplifier() : 0) * 1.25
						: 80)) {
			entity.getPersistentData().putDouble("blossomTick", 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
					(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BLOSSOM.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BLOSSOM.get()).getAmplifier() : 0) > 1
							? 4 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BLOSSOM.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BLOSSOM.get()).getAmplifier() : 0)
							: 4));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.NEUTRAL, (float) 0.4,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")), SoundSource.NEUTRAL, (float) 0.4,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
				}
			}
		} else {
			entity.getPersistentData().putDouble("blossomTick", (entity.getPersistentData().getDouble("blossomTick") + 1));
		}
	}
}
