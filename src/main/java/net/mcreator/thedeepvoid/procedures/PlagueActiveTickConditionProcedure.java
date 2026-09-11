package net.mcreator.thedeepvoid.procedures;

public class PlagueActiveTickConditionProcedure {
	public static boolean execute(double amplifier, double duration) {
		double baseRate = 0;
		baseRate = 30 - amplifier * 2;
		return duration % baseRate == 0;
	}
}
