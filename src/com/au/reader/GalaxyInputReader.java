package com.au.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import org.apache.log4j.Logger;

/**
 * This class reads the input file containing the test cases
 */
public class GalaxyInputReader {

	/** Logger for GalaxyInputReader */
	private Logger LOG = Logger.getLogger(getClass());
	
	/**
	 * This method reads the file and return the buffered reader for the file
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public BufferedReader readTestInputFile(String fileName) throws FileNotFoundException {
		URL url = GalaxyInputReader.class.getResource(fileName);
		FileReader reader = new FileReader(url.getPath());
		LOG.info("Input file is : " + fileName);
		return new BufferedReader(reader);
	}

}
