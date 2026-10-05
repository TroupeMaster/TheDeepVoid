package net.sombrius.thedeepvoid.procedures;

public class BlossomActiveTickConditionProcedure {
	public static boolean execute(double amplifier, double duration) {
		double baseRate = 0;
		baseRate = 80 - Math.round(amplifier * 1.25);
		return duration % baseRate == 0;
	}
}
