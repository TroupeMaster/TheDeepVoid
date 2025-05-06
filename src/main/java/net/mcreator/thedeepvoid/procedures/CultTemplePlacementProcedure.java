package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

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
		if (TheDeepVoidModVariables.MapVariables.get(world).CultTemplePlaced == false && DeepVoidConfigConfiguration.PLACECULTTEMPLE.get() == true) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("the_deep_void", "void_temple_new"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-12, -64, -12), new BlockPos(-12, -64, -12), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			TheDeepVoidModVariables.MapVariables.get(world).CultTemplePlaced = true;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			TheDeepVoidMod.queueServerWork(20, () -> {
				world.setBlock(new BlockPos(-8, -63, -12), Blocks.AIR.defaultBlockState(), 3);
			});
		}
		if (TheDeepVoidModVariables.MapVariables.get(world).CultTemplePlaced == true && TheDeepVoidModVariables.MapVariables.get(world).surfaceOverwritten == false && DeepVoidConfigConfiguration.PLACECULTTEMPLE.get() == true
				&& DeepVoidConfigConfiguration.OVERWRITEWITHTEMPLE.get() == true) {
			TheDeepVoidModVariables.MapVariables.get(world).surfaceOverwritten = true;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			TheDeepVoidModVariables.MapVariables.get(world).CultTemplePlaced = false;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
