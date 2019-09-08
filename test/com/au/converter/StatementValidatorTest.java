package com.au.converter;

import org.junit.Test;

import com.au.common.AbstractMapInitializerTest;

public class StatementValidatorTest extends AbstractMapInitializerTest{
	
	StatementValidator validator = new StatementValidator();
	
	@Test
	public void testValidQuestionFirstpattern(){
		assertTrue(validator.isValidQuestion("how much is glob prok pish pish ?"));
	}
	
	@Test
	public void testValidQuestionSecondPattern(){
		assertTrue(validator.isValidQuestion("how many Credits is glob prok Silver ?"));
	}
	
	@Test
	public void testInValidQuestion(){
		// Some values are not in map
		assertFalse(validator.isValidQuestion("how much is pish glob pish nsjg ?"));
	}
	
	@Test
	public void testInValidCalculation(){
		assertFalse(validator.isValidCalculation("plob Silver is 500 Credits"));
	}
	
	@Test
	public void testValidCalculation(){
		assertTrue(validator.isValidCalculation("glob prok Silver is 500 Credits"));
	}
	
	@Test
	public void testValidConversion(){
		assertTrue(validator.isValidConversion("pish is I"));
	}
	
	@Test
	public void testInvalidConversion(){
		assertFalse(validator.isValidConversion("pish are I"));
	}
	
	@Test
	public void testSolveQuestionFail(){
		assertFalse(validator.isValidQuestion("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}

}
