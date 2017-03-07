package com.aditusbr.test.businessdays;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Testes JUnit para a classe de contagem de dias úteis.
 * 
 * NÃO ALTERAR NADA AQUI!!!
 */
public class BusinessDayCounterTest {

	private BusinessDayCounter counter = new BusinessDayCounter();

	private Calendar calendar = Calendar.getInstance();

	@Test
	public void testSimpleDay() {
		calendar.set(2017, Calendar.FEBRUARY, 20);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.FEBRUARY, 21);
		Date date2 = calendar.getTime();

		assertEquals(1, counter.count(date1, date2));
	}

	@Test
	public void testSameDay() {
		calendar.set(2017, Calendar.FEBRUARY, 20);
		Date date = calendar.getTime();

		assertEquals(0, counter.count(date, date));
	}

	@Test
	public void testSimpleWeek() {
		calendar.set(2017, Calendar.FEBRUARY, 19);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.FEBRUARY, 26);
		Date date2 = calendar.getTime();

		assertEquals(5, counter.count(date1, date2));
	}
	@Test
	public void testCarnivalWeek() {
		calendar.set(2017, Calendar.FEBRUARY, 26);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.MARCH, 5);
		Date date2 = calendar.getTime();

		assertEquals(3, counter.count(date1, date2));
	}

	@Test
	public void testWeekend() {
		calendar.set(2017, Calendar.FEBRUARY, 17);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.FEBRUARY, 19);
		Date date2 = calendar.getTime();

		assertEquals(0, counter.count(date1, date2));
	}

	@Test
	public void testWeekendHoliday() {
		calendar.set(2016, Calendar.DECEMBER, 30);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.JANUARY, 2);
		Date date2 = calendar.getTime();

		assertEquals(1, counter.count(date1, date2));
	}

	@Test
	public void testYear() {
		calendar.set(2016, Calendar.DECEMBER, 31);
		Date date1 = calendar.getTime();

		calendar.set(2017, Calendar.DECEMBER, 31);
		Date date2 = calendar.getTime();

		assertEquals(249, counter.count(date1, date2));
	}
}
