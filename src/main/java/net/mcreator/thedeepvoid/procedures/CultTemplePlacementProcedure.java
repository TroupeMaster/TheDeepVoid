package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModGameRules;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class CultTemplePlacementProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (TheDeepVoidModVariables.MapVariables.get(world).CultTemplePlaced == false && DeepVoidConfigConfiguration.PLACECULTTEMPLE.get() == true
				&& (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
			if (world.getLevelData().getGameRules().getBoolean(TheDeepVoidModGameRules.SPAWN_HOLE_STRUCTURE) == true) {
				TheDeepVoidModVariables.MapVariables.get(world).CultTemplePlaced = true;
				TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
				if (DeepVoidConfigConfiguration.OLDHOLESTRUCTURE.get() == true) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("the_deep_void", "void_cult_temple"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(-8, (double) DeepVoidConfigConfiguration.HOLESTRUCTUREY.get(), -8), BlockPos.containing(-8, (double) DeepVoidConfigConfiguration.HOLESTRUCTUREY.get(), -8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
					world.setBlock(BlockPos.containing(-8, (double) DeepVoidConfigConfiguration.HOLESTRUCTUREY.get() + 1, -8), Blocks.AIR.defaultBlockState(), 3);
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("the_deep_void", "cult_temple_noair3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(-12, (double) DeepVoidConfigConfiguration.HOLESTRUCTUREY.get(), -12), BlockPos.containing(-12, (double) DeepVoidConfigConfiguration.HOLESTRUCTUREY.get(), -12),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
					world.setBlock(BlockPos.containing(-12, (double) DeepVoidConfigConfiguration.HOLESTRUCTUREY.get() + 1, -12), Blocks.AIR.defaultBlockState(), 3);
				}
			}
		} else if (TheDeepVoidModVariables.MapVariables.get(world).WeaverTemplePlaced == false && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey
				.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			TheDeepVoidModVariables.MapVariables.get(world).WeaverTemplePlaced = true;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("the_deep_void", "weaver_sepulcher_nogates"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-40, 1, -40), new BlockPos(-40, 1, -40), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			world.setBlock(new BlockPos(-40, 1, -40), Blocks.AIR.defaultBlockState(), 3);
		} else if (TheDeepVoidModVariables.MapVariables.get(world).pitPlaced == false
				&& (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:the_pit"))) {
			TheDeepVoidModVariables.MapVariables.get(world).pitPlaced = true;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("the_deep_void", "the_pit_7"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			{
				final Vec3 _center = new Vec3(0, 0, 0);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(400 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ItemEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
			world.setBlock(new BlockPos(0, 0, 0), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
