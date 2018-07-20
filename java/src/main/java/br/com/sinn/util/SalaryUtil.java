package br.com.sinn.util;

public class SalaryUtil {

	public static double increaseSalary(double olderSalary, int percentToIncrease) {
		double toIncrease = (olderSalary * percentToIncrease) / 100;
		return olderSalary + toIncrease;
	}
}
