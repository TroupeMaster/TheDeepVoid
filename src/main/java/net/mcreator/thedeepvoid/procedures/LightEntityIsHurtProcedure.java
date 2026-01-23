package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class LightEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		if (DeepVoidConfigConfiguration.DESTROYLIGHTSOURCES.get() == true) {
			if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:can_break_light")))) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
					world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
				}
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0) {
					world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), false);
				}
				return true;
			} else if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:damneds")))) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (!sourceentity.level().isClientSide())
					sourceentity.discard();
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ())) > 0) {
					world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.45, entity.getZ()), false);
				}
				if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getLightEmission(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0) {
					world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), false);
				}
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
}
