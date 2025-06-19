package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WeaverSetsItsAttackTargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof WeaverOfSoulsEntity) {
			if (entity instanceof Player) {
				if (sourceentity.getPersistentData().getBoolean("deep_void:screamPlayed") == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:weaver_scream_loud")), SoundSource.HOSTILE,
									2, 1);
						} else {
							_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:weaver_scream_loud")), SoundSource.HOSTILE, 2, 1, false);
						}
					}
					sourceentity.getPersistentData().putBoolean("deep_void:screamPlayed", true);
					sourceentity.getPersistentData().putDouble("deep_void:screamCooldown", 140);
				}
			}
		}
	}
}
