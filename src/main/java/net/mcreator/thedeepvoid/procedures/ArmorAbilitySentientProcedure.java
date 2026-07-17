package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class ArmorAbilitySentientProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).sentientArmorAbility == 0) {
			{
				double _setval = 460;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sentientArmorAbility = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ADAPTED.get(), 60,
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) * 2)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.set_spawn")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.set_spawn")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
	}
}
