package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class DeathMawOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (!entity.isVehicle()) {
				if (entity.getPersistentData().getDouble("deep_void:chase_timer") >= 35) {
					entity.getPersistentData().putDouble("deep_void:chase_timer", 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:death_maw_chase")), SoundSource.HOSTILE, (float) 1.8,
									(float) Mth.nextDouble(RandomSource.create(), 0.84, 0.94));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:death_maw_chase")), SoundSource.HOSTILE, (float) 1.8,
									(float) Mth.nextDouble(RandomSource.create(), 0.84, 0.94), false);
						}
					}
				} else {
					entity.getPersistentData().putDouble("deep_void:chase_timer", (entity.getPersistentData().getDouble("deep_void:chase_timer") + 1));
				}
			}
		}
	}
}
