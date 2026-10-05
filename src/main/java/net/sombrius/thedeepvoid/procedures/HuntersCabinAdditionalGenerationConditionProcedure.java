package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class HuntersCabinAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.GENERATECABIN.get() == true) {
			return true;
		}
		return false;
	}
}
