package com.au.calculator;

import java.util.StringTokenizer;

import com.au.common.CommonConstants;
import com.au.common.Metals;
import com.au.common.WordBank;
import com.au.writer.OutputProcessor;

/**
 * This class initializes the operands and invokes the calculator to generate result
 */
public class StatementSolver implements CommonConstants{
	
	/** Decimal calculator */
	ArithmeticCalculator calculator = new ArithmeticCalculator();
	/** The processor to display result	 */
	OutputProcessor outputProcessor = new OutputProcessor();
	/** The operands required for calculation	 */
	Operands operands = new Operands();
	
	/**
	 * This method removes the text words and sends the operands to the calculator to generate output
	 * 
	 * @param input
	 * @return
	 */
	public boolean solveQuestion(String input) {
		/* Sample input for the method
		 * how much is glob prok pish pish ?
		 * how many Credits is glob prok Silver ?
		 */
		StringTokenizer tokenizer = new StringTokenizer(input);
		String operandsList = EMPTY_STRING;
		 while(tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			if(WordBank.isQuestionWord(word)){ 
				continue;
			}
			operandsList = operandsList + word + SPACE;
		}
			initializeOperands(new StringTokenizer(operandsList));
			calculator.performCalculation(operands);
			generateOutput(input, operands);
		return (!operands.getCalculatedResult().isEmpty());
	}
	
	/**
	 * This method gets the operands required to map the metal value and sends it to the calculator
	 * 
	 * @param input
	 * @return
	 */
	public boolean solveComplexConversion(String input) {
		/* Sample input for the method
		 * glob prok Silver is 500 Credits
		 */
		initializeOperands(new StringTokenizer(input));
		return calculator.calculateAndAddToMap(operands);
	}
	
	/**
	 * This method generates the output to be displayed
	 * 
	 * @param originalInput
	 * @param operands
	 */
	private void generateOutput(String originalInput, Operands operands){
		operands.setStatement(originalInput);
		outputProcessor.setOutput(operands);
		outputProcessor.displayOutput();
	}
	
	/**
	 * This method retrieves the operands and other required values from the input
	 * 
	 * @param tokenizer
	 */
	private void initializeOperands(StringTokenizer tokenizer){
		operands = new Operands();
		operands.setFirstOperand(getOperand(tokenizer));
		operands.setSecondOperand(getOperand(tokenizer));
		String key = tokenizer.nextToken(); 
		if(Metals.isMetal(key)){
			operands.setMetal(key);
		} else {
			operands.setThirdOperand(getOperand(key));
		}
		String fourthOperand = (tokenizer.hasMoreTokens())? tokenizer.nextToken(): EMPTY_STRING;
		if(NUMERIC_CONVERSION_MAP.containsKey(fourthOperand))
			operands.setFourthOperand(getOperand(fourthOperand));
		String result = (tokenizer.hasMoreTokens())? tokenizer.nextToken(): EMPTY_STRING;
		if(result.matches(NUMBERS_ONLY_PATTERN)){
			operands.setCalculatedResult(result);
		}
	}
	
	/**
	 * This method gets the numeric value for the operand
	 * 
	 * @param tokenizer
	 * @return
	 */
	private String getOperand(StringTokenizer tokenizer) {
		return NUMERIC_CONVERSION_MAP.get(tokenizer.nextToken());
	}
	
	/**
	 * This method gets the numeric value for the operand
	 * 
	 * @param tokenizer
	 * @return
	 */
	private String getOperand(String input) {
		return NUMERIC_CONVERSION_MAP.get(input);
	}
	
}
