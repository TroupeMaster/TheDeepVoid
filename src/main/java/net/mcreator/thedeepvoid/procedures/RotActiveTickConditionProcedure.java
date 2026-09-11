package net.mcreator.thedeepvoid.procedures;

public class RotActiveTickConditionProcedure {
	public static boolean execute(double duration) {
		double baseRate = 0;
		baseRate = 15;
		return duration % baseRate == 0;
	}
}
