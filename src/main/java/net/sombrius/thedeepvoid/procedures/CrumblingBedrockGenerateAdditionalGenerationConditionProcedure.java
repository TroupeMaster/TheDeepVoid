package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class CrumblingBedrockGenerateAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.CRUMBLINGBEDROCKGENERATE.get() == true) {
			return true;
		}
		return false;
	}
}
