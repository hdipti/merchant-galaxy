package com.au.calculator;

import org.junit.Test;

import junit.framework.TestCase;

public class CalculationRulesTest extends TestCase{
	
	CalculationRules rules = new CalculationRules();
	
	@Test
	public void testIsSubtractionISuccess(){
		assertTrue(rules.isSubtraction("I", "X"));
	}
	
	@Test
	public void testIsSubtractionXSuccess(){
		assertTrue(rules.isSubtraction("X", "L"));
	}
	
	@Test
	public void testIsSubtractionCSuccess(){
		assertTrue(rules.isSubtraction("C", "D"));
	}
	
	@Test
	public void testIsSubtractionFail(){
		assertFalse(rules.isSubtraction("D", "I"));
	}
	
	@Test
	public void testIsRepetitionSuccess(){
		assertTrue(rules.isRepetitionUpto3Numerals("I", "I", "I"));
	}
	
	@Test
	public void testIsRepetitionFail(){
		assertFalse(rules.isRepetitionUpto3Numerals("I", "I", "C"));
	}
	
	@Test
	public void testInValidRepetitionSuccess(){
		assertTrue(rules.isInvalidRepetition("I", "I", "I", "I"));
	}
	
	@Test
	public void testInValidRepetitionFail(){
		assertFalse(rules.isRepetitionUpto3Numerals("D", "D", "D", "D"));
	}
	
	@Test
	public void testValidDigitSuccess(){
		assertTrue(rules.isValidDigit("X", "X", "I", "V"));
	}
	
	@Test
	public void testInValidDigitFail(){
		assertFalse(rules.isValidDigit("I", "X", "I", "V"));
	}

}
