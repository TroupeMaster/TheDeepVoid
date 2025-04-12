package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.LightEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LightIsPlacedProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (entity instanceof LivingEntity) {
				if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0 && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN_HANGED.get())
						&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FERRYMAN_LANTERN.get())
						&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.VOIDRIUM_GLASS.get()) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEACON)
						&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.DEAD_FERRYMAN.get())) {
					if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 6) {
						if (!world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3(x, (y + 0.45), z), 0.5, 0.5, 0.5), e -> true).isEmpty() == false) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.LIGHT.get().spawn(_level, BlockPos.containing(x, y + 0.45, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
			}
		}
	}
}
