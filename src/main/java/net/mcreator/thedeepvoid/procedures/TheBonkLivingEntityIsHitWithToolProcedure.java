package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.IdlingApostleEntity;
import net.mcreator.thedeepvoid.entity.HiveBrainEntity;
import net.mcreator.thedeepvoid.entity.GiantBoneCrawlerEggEntity;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;

public class TheBonkLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:bonk")), SoundSource.PLAYERS, 4, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:bonk")), SoundSource.PLAYERS, 4, 1, false);
			}
		}
		if (entity instanceof HiveBrainEntity || entity instanceof GiantBoneCrawlerEggEntity || entity instanceof IdlingApostleEntity || entity instanceof ChainedWeaverEntity) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
