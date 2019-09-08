package com.au.common;

import org.junit.Test;

import com.au.common.RomanNumerals;

import junit.framework.TestCase;

/**
 * Test for the RomanNumerals enum
 */
public class RomanNumeralsTest extends TestCase{

	@Test
	public void testInvalidSymbol(){
		assertNull(RomanNumerals.getRomanNumeralBySymbol("Z"));
	}
	
	@Test
	public void testInValidValue(){
		assertNull(RomanNumerals.getRomanNumeralByValue(12));
	}
	
	@Test
	public void testValidSymbol(){
		assertEquals(RomanNumerals.I, RomanNumerals.getRomanNumeralBySymbol("I"));
	}
	
	@Test
	public void testValidValue(){
		assertEquals(RomanNumerals.I, RomanNumerals.getRomanNumeralByValue(1));
	}
	
	@Test
	public void testIsRomanNumeralSuccess(){
		assertTrue(RomanNumerals.isRomanNumeral("I"));
	}
	
	@Test
	public void testIsRomanNumeralFail(){
		assertFalse(RomanNumerals.isRomanNumeral("Hi"));
	}
}
