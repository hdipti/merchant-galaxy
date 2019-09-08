package com.au.common;

import org.junit.Test;

import com.au.common.WordBank;

import junit.framework.TestCase;

/**
 * Test for the WordBank enum
 */
public class WordBankTest extends TestCase{

	@Test
	public void testInvalidWord(){
		assertNull(WordBank.getQuestionWord("hello"));
	}
	
	@Test
	public void testValidQuestionWord(){
		assertEquals(WordBank.CREDITS, WordBank.getQuestionWord("Credits"));
	}
	
	@Test
	public void testIsQuestionWordSuccess(){
		assertTrue(WordBank.isQuestionWord("Credits"));
	}
	
	@Test
	public void testIsQuestionWordFail(){
		assertFalse(WordBank.isQuestionWord("Hi"));
	}
}
