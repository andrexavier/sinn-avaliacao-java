package br.com.sinn.util;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SalaryUtilTest {
	
	private static final double DELTA = 1e-15;

	@Test
	void testInternSalaryEncrease() {
		double salary = SalaryUtil.increaseSalary(100.0, 10);
		assertEquals(salary, 110.0, DELTA);
	}
	
	@Test
	void testManagerSalaryIncrease() {
		double salary = SalaryUtil.increaseSalary(100.0, 20);
		assertEquals(salary, 120.0, DELTA);
	}
	
	@Test
	void testDirectorIncreaseSalary() {
		double salary = SalaryUtil.increaseSalary(100.0, 35);
		assertEquals(salary, 135.0, DELTA);
	}

}
