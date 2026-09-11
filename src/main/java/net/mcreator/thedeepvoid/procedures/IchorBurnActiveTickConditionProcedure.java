package net.mcreator.thedeepvoid.procedures;

public class IchorBurnActiveTickConditionProcedure {
	public static boolean execute(double duration) {
		double baseRate = 0;
		baseRate = 10;
		return duration % baseRate == 0;
	}
}
