package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class FleshBlobsGenerateAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.STOPACTIVEBLOCKGENERATION.get() == false) {
			return true;
		}
		return false;
	}
}
