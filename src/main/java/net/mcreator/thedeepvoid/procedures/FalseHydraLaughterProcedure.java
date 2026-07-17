package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.FalseHydraEntity;

public class FalseHydraLaughterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_laugh) : 0) <= 0) {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_laugh, 100);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_laughter_loop")), SoundSource.HOSTILE, 4,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_laughter_loop")), SoundSource.HOSTILE, 4, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
		} else {
			if (entity instanceof FalseHydraEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FalseHydraEntity.DATA_laugh, (int) ((entity instanceof FalseHydraEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraEntity.DATA_laugh) : 0) - 1));
		}
	}
}
