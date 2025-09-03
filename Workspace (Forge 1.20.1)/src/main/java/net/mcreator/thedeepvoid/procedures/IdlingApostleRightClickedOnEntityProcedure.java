package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class IdlingApostleRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) {
			sourceentity.getPersistentData().putDouble("deep_void:apostleDiscuss", (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") + 1));
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line1").getString())), false);
				entity.getPersistentData().putBoolean("deep_void:talking", true);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line2").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line3").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line4").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 5) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line5").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 6) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line6").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 7) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line7").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 8) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line8").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 9) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line9").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 10) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line10").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 11) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line11").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 12) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line12").getString())), false);
			}
			if (sourceentity.getPersistentData().getDouble("deep_void:apostleDiscuss") == 13) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.blessing_line13").getString())), false);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:void_energy"))), sourceentity), 1);
			}
		}
	}
}
