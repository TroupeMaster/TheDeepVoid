package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class DesolateSoilGenerateNormalAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.STOPACTIVEBLOCKGENERATION.get() == true) {
			return true;
		}
		return false;
	}
}
