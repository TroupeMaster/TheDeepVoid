package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class BarbedArrowProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 12 / 11, 4 / 3));
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 12 / 11, 4 / 3), false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BARBED_TIPS.get(), 60,
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BARBED_TIPS.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BARBED_TIPS.get()).getAmplifier() : 0) + 1)));
		if (entity instanceof Player) {
			if (entity instanceof Player _plr6)
				_plr6.setArrowCount((int) ((entity instanceof Player _plr5 ? _plr5.getArrowCount() : 0) + 1));
		}
	}
}
