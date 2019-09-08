package com.au.writer;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.au.calculator.Operands;
import com.au.common.CommonConstants;
import com.au.common.WordBank;

/**
 * This class displays the calculated result to console
 */
public class OutputProcessor implements CommonConstants {
	
	/** The output with operands and calculated result */
	Operands output = new Operands();
	
	/** Logger for OutputProcessor */
	private Logger LOG = Logger.getLogger(getClass());
	
	/**
	 * This method displays the calculated result to console
	 * 
	 * @return
	 */
	public boolean displayOutput(){
		boolean isDisplaySuccess = false;
		if(null != output.getStatement() && !output.getStatement().isEmpty()){
			printToConsole();
			isDisplaySuccess = true;
		}
		return isDisplaySuccess;
		
	}
	
	public void displayError(){
		printErrorMessage();
	}
	
	/**
	 * This method prints text to console
	 */
	private void printToConsole(){
		
		if(output.getStatement().contains(WordBank.CREDITS.getWord())) {
			printCalculatedCredits();
		} else {
			printCalculatedResult();
		}
	}

	/**
	 * This method prints the error message and logs it
	 */
	private void printErrorMessage() {
		System.out.println(UNKNOWN_STATEMENT_ERROR);
		LOG.error(output.getStatement());
	}

	/**
	 * This method prints the calculated credits with the operands and logs it
	 */
	private void printCalculatedCredits() {
		String outputStatement = getStatement() + WordBank.IS.getWord() + SPACE + output.getCalculatedResult()
				+ SPACE + WordBank.CREDITS.getWord();
		System.out.println(outputStatement);
		LOG.info(outputStatement);
	}
	
	/**
	 * This method prints the calculated result with the operands and logs it
	 */
	private void printCalculatedResult() {
		String outputStatement = getStatement() + WordBank.IS.getWord() + SPACE + output.getCalculatedResult();
		System.out.println(outputStatement);
		LOG.info(outputStatement);
	}
	
	/**
	 * This method returns the operands and metals used to calculate the result
	 * 
	 * @return
	 */
	private String getStatement(){
	StringTokenizer tokenizer = new StringTokenizer(output.getStatement());
	String operandsList = EMPTY_STRING;
	 while(tokenizer.hasMoreTokens()) {
		String word = tokenizer.nextToken();
		if(WordBank.isQuestionWord(word)){ 
			continue;
		}
		operandsList = operandsList + word + SPACE;
	 }
	 return operandsList;
	}

	/**
	 * @return the output
	 */
	public Operands getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(Operands output) {
		this.output = output;
	}
	
}