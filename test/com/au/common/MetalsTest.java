package com.au.common;

import org.junit.Test;

import com.au.common.Metals;

import junit.framework.TestCase;

/**
 * Test for the Metals enum
 */
public class MetalsTest extends TestCase{

	@Test
	public void testInvalidMetal(){
		assertNull(Metals.getMetalByName("hello"));
	}
	
	@Test
	public void testValidMetal(){
		assertEquals(Metals.SILVER, Metals.getMetalByName("Silver"));
	}
	
	@Test
	public void testIsMetalSuccess(){
		assertTrue(Metals.isMetal("Gold"));
	}
	
	@Test
	public void testIsQuestionWordFail(){
		assertFalse(Metals.isMetal("Dirt"));
	}
}
