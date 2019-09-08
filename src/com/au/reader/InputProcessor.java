package com.au.reader;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.au.converter.Converter;

/**
 * This class reads the commands in the file and processes them
 */
public class InputProcessor {
	
	/** Logger for InputProcessor */
	private Logger LOG = Logger.getLogger(getClass());
	/** Converter to map conversions and solve questions */
	private Converter converter = new Converter(); 
	
	/**
	 * This method reads the conversions and questions in the test file and processes them
	 * 
	 * @param reader
	 * @throws IOException
	 */
	public void processInput(BufferedReader reader)
			throws IOException {
		String line;
		while((line = reader.readLine()) != null ){
			printToConsole(line);
			LOG.info(line);
			converter.handleInput(line);
		}
	}
	
	/**
	 * Display text on console
	 * 
	 * @param line
	 */
	private void printToConsole(String line){
		System.out.println(line);
	}

}
