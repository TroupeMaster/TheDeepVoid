package net.mcreator.thedeepvoid.procedures;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class CrumblingBedrockGenerateAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.CRUMBLINGBEDROCKGENERATE.get() == true) {
			return true;
		}
		return false;
	}
}
