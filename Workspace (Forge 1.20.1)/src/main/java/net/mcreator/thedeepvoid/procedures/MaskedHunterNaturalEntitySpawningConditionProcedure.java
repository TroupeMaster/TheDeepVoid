package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class MaskedHunterNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD
				&& !(!world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 450, 450, 450), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) && DeepVoidConfigConfiguration.SPAWNMASKEDHUNTERS.get() == true && y >= 50
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:masked_hunter_spawnable_on")))) {
			return true;
		}
		return false;
	}
}
