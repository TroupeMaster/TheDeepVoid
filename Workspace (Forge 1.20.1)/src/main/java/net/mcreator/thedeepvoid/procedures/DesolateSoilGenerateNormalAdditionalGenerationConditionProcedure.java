package net.mcreator.thedeepvoid.procedures;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class DesolateSoilGenerateNormalAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.STOPACTIVEBLOCKGENERATION.get() == true) {
			return true;
		}
		return false;
	}
}
