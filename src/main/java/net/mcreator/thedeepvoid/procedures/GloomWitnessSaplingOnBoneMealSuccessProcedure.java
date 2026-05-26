package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GloomWitnessSaplingOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (Math.random() < 0.25 && world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 3, z))
				&& world.isEmptyBlock(BlockPos.containing(x, y + 4, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 5, z)) && world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) && world.isEmptyBlock(BlockPos.containing(x - 1, y, z))
				&& world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("the_deep_void", "giant_gloom_lantern_plant"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y, z - 3), BlockPos.containing(x - 3, y, z - 3), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == blockstate.getBlock()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			int horizontalRadiusSquare = (int) 10 - 1;
			int verticalRadiusSquare = (int) 10 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.STRUCTURE_BLOCK) {
							world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}
}
