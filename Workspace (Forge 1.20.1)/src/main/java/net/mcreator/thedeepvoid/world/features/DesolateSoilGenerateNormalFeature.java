
package net.mcreator.thedeepvoid.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import net.minecraft.world.level.levelgen.feature.ReplaceBlobsFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.thedeepvoid.procedures.DesolateSoilGenerateNormalAdditionalGenerationConditionProcedure;

public class DesolateSoilGenerateNormalFeature extends ReplaceBlobsFeature {
	public DesolateSoilGenerateNormalFeature() {
		super(ReplaceSphereConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<ReplaceSphereConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!DesolateSoilGenerateNormalAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}
