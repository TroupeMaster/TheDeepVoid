
package net.mcreator.thedeepvoid.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.thedeepvoid.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.thedeepvoid.procedures.HuntersCabinAdditionalGenerationConditionProcedure;

public class HuntersCabinFeature extends StructureFeature {
	public HuntersCabinFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!HuntersCabinAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}
