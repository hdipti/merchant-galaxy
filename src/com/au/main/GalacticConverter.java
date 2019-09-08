package com.au.main;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.au.reader.GalaxyInputReader;
import com.au.reader.InputProcessor;


public class GalacticConverter {

	private static final Logger LOG = Logger.getLogger(GalacticConverter.class);
	
	public static void main(String[] args){
		
		try(BufferedReader buffer = new GalaxyInputReader().readTestInputFile("TestInput.txt")) {
			// Process the commands from the text file
			new InputProcessor().processInput(buffer);
		
		} catch (IOException exception) {
			LOG.error("Invalid test input file");
			LOG.error(exception.toString());
		
		} 
	}
	
}
