package net.mcreator.thedeepvoid.procedures;

public class BarbedTipsActiveTickConditionProcedure {
	public static boolean execute(double duration) {
		double baseRate = 0;
		baseRate = 20;
		return duration % baseRate == 0;
	}
}
