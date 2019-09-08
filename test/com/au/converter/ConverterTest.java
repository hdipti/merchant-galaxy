package com.au.converter;

import org.junit.Test;

import com.au.common.AbstractMapInitializerTest;

public class ConverterTest extends AbstractMapInitializerTest {
	
	Converter converter = new Converter();
	
	@Test
	public void testInvalidInput() {
		assertFalse(converter.handleInput("I am an invalid input"));
	}
	
	@Test
	public void testValidQuestion() {
		assertTrue(converter.handleInput("how much is glob prok pish pish ?"));
	}
	
	@Test
	public void testInValidQuestion() {
		converter.handleInput("how much is IV ?");
	}
	
	@Test
	public void testValidConversion() {
		assertTrue(converter.handleInput("pish is X"));
	}
	
	@Test
	public void testInValidConversion() {
		assertFalse(converter.handleInput("fsrg bietmkd is N"));
	}
	
	@Test
	public void testInValidCalculation() {
		assertFalse(converter.handleInput("plob Silver is 500 Credits"));
	}
	
	@Test
	public void testValidCalculation() {
		assertTrue(converter.handleInput("glob prok Silver is 500 Credits"));
	}
	
	

}
