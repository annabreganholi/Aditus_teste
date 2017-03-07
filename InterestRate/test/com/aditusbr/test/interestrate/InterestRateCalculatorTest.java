package com.aditusbr.test.interestrate;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class InterestRateCalculatorTest {

	private static final double DELTA = Math.pow(0.1, 9);

	private InterestRateCalculator calculator = new InterestRateCalculator();

	private Calendar calendar = Calendar.getInstance();

	@Test
	public void testFullYearPeriodRate() {
		assertEquals(0.075, calculator.getPeriodRate(0.075, 252), DELTA);
	}

	@Test
	public void testOneMonthPeriodRate() {
		assertEquals(0.011163421, calculator.getPeriodRate(0.1425, 21), DELTA);
	}

	@Test
	public void testSingleDayPeriodRate() {
		assertEquals(0.00045867, calculator.getPeriodRate(0.1225, 1), DELTA);
	}

	@Test
	public void testOneDayPeriodRate() {
		calendar.set(2017, Calendar.JANUARY, 31);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.FEBRUARY, 1);
		Date date2 = calendar.getTime();

		assertEquals(0.000480889, calculator.getPeriodRate(date1, date2), DELTA);
	}

	@Test
	public void testFirstWeekPeriodRate() {
		calendar.set(2017, Calendar.JANUARY, 2);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.JANUARY, 9);
		Date date2 = calendar.getTime();

		assertEquals(0.002538482, calculator.getPeriodRate(date1, date2), DELTA);
	}

	@Test
	public void testLastWeekPeriodRate() {
		calendar.set(2017, Calendar.FEBRUARY, 20);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.MARCH, 1);
		Date date2 = calendar.getTime();

		assertEquals(0.002353729, calculator.getPeriodRate(date1, date2), DELTA);
	}

	@Test
	public void testJanuaryPeriodRate() {
		calendar.set(2017, Calendar.JANUARY, 2);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.FEBRUARY, 1);
		Date date2 = calendar.getTime();

		assertEquals(0.010845657, calculator.getPeriodRate(date1, date2), DELTA);
	}

	@Test
	public void testFebruaryPeriodRate() {
		calendar.set(2017, Calendar.FEBRUARY, 1);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.MARCH, 1);
		Date date2 = calendar.getTime();

		assertEquals(0.008638124, calculator.getPeriodRate(date1, date2), DELTA);
	}

	@Test
	public void testFullPeriodRate() {
		calendar.set(2017, Calendar.JANUARY, 2);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.MARCH, 1);
		Date date2 = calendar.getTime();

		assertEquals(0.019577467, calculator.getPeriodRate(date1, date2), DELTA);
	}
}
