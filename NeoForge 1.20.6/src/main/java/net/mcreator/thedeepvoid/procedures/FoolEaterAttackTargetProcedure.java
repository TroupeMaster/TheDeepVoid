package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.FoolEaterEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoolEaterAttackTargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof FoolEaterEntity) {
			if (!((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (sourceentity.getPersistentData().getBoolean("deep_void:cracked") == false) {
					sourceentity.getPersistentData().putBoolean("deep_void:cracked", true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:fool_eater_targets")), SoundSource.HOSTILE,
									2, (float) 0.8);
						} else {
							_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:fool_eater_targets")), SoundSource.HOSTILE, 2, (float) 0.8,
									false);
						}
					}
					sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
							((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), ((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
			}
		}
	}
}
