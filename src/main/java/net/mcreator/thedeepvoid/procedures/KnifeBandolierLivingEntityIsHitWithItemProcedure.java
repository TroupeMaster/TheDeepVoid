package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class KnifeBandolierLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("count") >= (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 4.5) {
			if (itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 2.25) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:rotten"))), sourceentity), 2);
			} else if (itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 1.5) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:rotten"))), sourceentity), 3);
			} else if (itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get()) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:rotten"))), sourceentity), 4);
			} else {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:rotten"))), sourceentity),
						(float) (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERFULLCHARGEHIT.get());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (Math.random() < 0.5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 80, (int) (itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 1.5 ? 0 : 1)));
			} else if (Math.random() < 0.5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 80, (int) (itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get() / 1.5 ? 0 : 1)));
			}
		}
	}
}
