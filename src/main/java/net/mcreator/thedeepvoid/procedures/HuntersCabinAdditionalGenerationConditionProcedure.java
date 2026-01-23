package net.mcreator.thedeepvoid.procedures;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class HuntersCabinAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (DeepVoidConfigConfiguration.GENERATECABIN.get() == true) {
			return true;
		}
		return false;
	}
}
