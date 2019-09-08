package com.au.reader;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

/** 
 * Test for the input file reader
 */
public class GalaxyInputReaderTest extends TestCase{
	
	GalaxyInputReader reader = new GalaxyInputReader();
	private Logger LOG = Logger.getLogger(getClass());
	
	@Test
	public void testReadFileSuccess() throws FileNotFoundException{
		LOG.info("test success");
		assertNotNull(reader.readTestInputFile("TestInput.txt"));
	}

	@Test(expected=FileNotFoundException.class)
	public void testReadFileFail() throws FileNotFoundException{
		LOG.info("test exception");
		reader.readTestInputFile("TestInput.txt");
	}

}
