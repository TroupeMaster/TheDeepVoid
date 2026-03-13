package net.mcreator.thedeepvoid.procedures;

public class BlackFlameParticleVisualScaleProcedure {
	public static double execute(double age, double scale) {
		if (age > 5) {
			return scale - 0.01;
		}
		return 1;
	}
}
