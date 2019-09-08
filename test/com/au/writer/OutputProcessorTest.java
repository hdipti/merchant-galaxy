package com.au.writer;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.au.calculator.Operands;

import junit.framework.TestCase;

/**
 * Test for the output processor
 *
 */
public class OutputProcessorTest extends TestCase {
	
	private OutputProcessor processor = new OutputProcessor();
	private Operands output = new Operands();
	private Logger LOG = Logger.getLogger(getClass());
	
	@Test
	public void testdisplaySuccess(){
		LOG.info("Test success display");
		output.setStatement("I have no idea what you are talking about");
		processor.setOutput(output);
		assertEquals(true, processor.displayOutput());
	}

	
	@Test
	public void testdisplayFail(){
		LOG.info("Test fail display");
		output.setStatement(null);
		processor.setOutput(output);
		assertEquals(false, processor.displayOutput());
	}

}
