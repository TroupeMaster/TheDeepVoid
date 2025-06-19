package net.mcreator.thedeepvoid.procedures;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class FleshBlobsGenerateAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.STOPACTIVEBLOCKGENERATION.get() == false) {
			return true;
		}
		return false;
	}
}
