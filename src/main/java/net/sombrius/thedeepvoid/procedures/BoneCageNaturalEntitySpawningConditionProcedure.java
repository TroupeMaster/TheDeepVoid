package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.MaskedHunterEntity;
import net.sombrius.thedeepvoid.entity.BoneCageEntity;
import net.sombrius.thedeepvoid.entity.BoneCageClosedEntity;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BoneCageNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD
				&& !(!world.getEntitiesOfClass(BoneCageEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(BoneCageClosedEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())
				&& !world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty() && DeepVoidConfigConfiguration.SPAWNBONECAGES.get() == true && y >= 50
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:masked_hunter_spawnable_on")))) {
			return true;
		}
		return false;
	}
}
