package net.iessanclemente.dapw.katas.stringcalculator.tests;

import static org.junit.Assert.*;
import net.iessanclemente.dapw.katas.stringcalculator.StringCalculator;

import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {

	private StringCalculator sc;

	@Before
	public void setUp() throws Exception {
		sc = new StringCalculator();
	}

	@Test
	public void testEmptyStringReturnsCero() {
		int result=sc.add("");
		assertEquals(0, result);	
	}
	
	@Test
	public void testANumberReturnsTheNumber() {
		int shouldBeOne=sc.add("1");
		int shouldBeTwo=sc.add("2");
		assertEquals(1, shouldBeOne);	
		assertEquals(2, shouldBeTwo);
	}

}
