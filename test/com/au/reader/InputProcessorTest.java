package com.au.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test for the Input processor
 *
 */
public class InputProcessorTest extends TestCase{
	
	GalaxyInputReader input = new GalaxyInputReader();
	BufferedReader reader = null;
	
	@Before
	public void setUp(){
		try {
			reader = input.readTestInputFile("TestInput.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=IOException.class)
	public void testValidInput() throws IOException{
			new InputProcessor().processInput(reader);
	}
	
}
