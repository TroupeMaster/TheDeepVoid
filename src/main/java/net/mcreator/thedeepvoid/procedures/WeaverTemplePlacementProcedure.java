package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class WeaverTemplePlacementProcedure {
	public static void execute(LevelAccessor world) {
		if (TheDeepVoidModVariables.MapVariables.get(world).WeaverTemplePlaced == false && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey
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
		}
	}
}
