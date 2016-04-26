package net.iessanclemente.dapw.katas.stringcalculator.tests;

import static org.junit.Assert.*;
import net.iessanclemente.dapw.katas.stringcalculator.StringCalculator;
import net.iessanclemente.dapw.katas.stringcalculator.exceptions.NegativesNotSupportedException;

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
		int result = sc.add("");
		assertEquals(0, result);
	}

	@Test
	public void testANumberReturnsTheNumber() {
		int shouldBeOne = sc.add("1");
		int shouldBeTwo = sc.add("2");
		assertEquals(1, shouldBeOne);
		assertEquals(2, shouldBeTwo);
	}

	@Test
	public void testTwoNumbersReturnsTheSumOfThem() {
		int shouldBeThree = sc.add("1,2");
		assertEquals(3, shouldBeThree);
	}

	@Test
	public void testManyNumbersReturnsTheSumOfThem() {
		int shouldBeSix = sc.add("1,2,3");
		int shouldBeTen = sc.add("1,2,3,4");
		assertEquals(6, shouldBeSix);
		assertEquals(10, shouldBeTen);
	}

	@Test
	public void testCRSepator() {
		int shouldBeThree = sc.add("1\n2");
		assertEquals(3, shouldBeThree);
	}

	@Test
	public void testCRAndColonSepator() {
		int shouldBeSix = sc.add("1\n2,3");
		assertEquals(6, shouldBeSix);
	}

/*	
 * @Test
	public void testContiguousSepatorDoenstWork() {
		NumberFormatException lanzada = null;
		try {
			sc.add("1\n,3");
		} catch (NumberFormatException e) {
			lanzada = e;
		}
		assertNotNull(lanzada);
	}
	*/
	
	@Test
	public void testCustomSepartors() {
		int shouldBeSix = sc.add("//@\n1@2@3");
		assertEquals(6, shouldBeSix);
	}
	
	@Test
	public void testNegativesThrowNegativesNotSupportedException() {
		NegativesNotSupportedException lanzada = null;
		try {
			sc.add("1,-3");
		} catch (NegativesNotSupportedException e) {
			lanzada = e;
			System.out.println(e.getMessage());
		}
		assertNotNull(lanzada);
	}
	
	@Test
	public void testNegativesThrowNegativesNotSupportedExceptionWithManyNumbers() {
		NegativesNotSupportedException lanzada = null;
		try {
			sc.add("1,-3,-4,-5");
		} catch (NegativesNotSupportedException e) {
			lanzada = e;
			System.out.println(e.getMessage());
		}
		assertEquals(3,lanzada.getNegatives().length);
	}
	
}
