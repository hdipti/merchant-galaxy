package com.au.converter;

import com.au.calculator.StatementSolver;
import com.au.common.CommonConstants;
import com.au.writer.OutputProcessor;

/**
 * This class validates the input and then calls the appropriate method to process the input
 */
public class Converter implements CommonConstants{
	
	/** Validates the input */
	StatementValidator validator = new StatementValidator();
	
	/** Maps the input with its corresponding numeric value */
	ConversionMapper mapper = new ConversionMapper();
	
	/** Calculates result */
	StatementSolver solver = new StatementSolver();
	
	/** The processor to display error	 */
	OutputProcessor outputProcessor = new OutputProcessor();
	
	/**
	 * This method validates the input and calls the relevant method to calculate the result
	 * 
	 * @param input
	 * @return
	 * @throws InvalidStatementException  
	 */
	public boolean handleInput(String input) {
		boolean isInputProcessed = false;
		
		// Check if the input is a numeric mapping
		if(validator.isValidConversion(input)){
			isInputProcessed = mapper.addToMap(input);
		} else if(validator.isValidCalculation(input)){
			// Check if the input is a conversion for metals
			isInputProcessed = solver.solveComplexConversion(input);
		} else if (validator.isValidQuestion(input)){
			// Check if the input is a question
			isInputProcessed = solver.solveQuestion(input);
		} else {
			outputProcessor.displayError();
		}

		return isInputProcessed;
	}
	
}
