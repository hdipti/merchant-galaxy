package com.au.calculator;

import com.au.common.CommonConstants;
import com.au.common.Metals;

/**
 * This class calculates the arithmetic values of the questions and metal values
 */
public class ArithmeticCalculator implements CommonConstants {
	
	RomanCalculator romanCalculator = new RomanCalculator();
	
	/**
	 * This method calculates the result for questions
	 * 
	 * @param operands
	 */
	public void performCalculation(Operands operands){
		/* Sample statement processed
		 * glob prok pish pish ?
		 * glob prok Silver ?
		 */
		if(Metals.isMetal(operands.getMetal())){
			operands.setCalculatedResult(calculateMetalValue(operands));
		} else {
			operands.setCalculatedResult(romanCalculator.calculateResult(operands));
		}
	}
	
	/**
	 * This method calculates the value for metal
	 * 
	 * @param operands
	 * @return
	 */
	private String calculateMetalValue(Operands operands) {
		int result = (int) (romanCalculator.getArithmaticCalculation(operands.getFirstOperand(),
				operands.getSecondOperand()) * MULTIPLIER_CONVERSION_MAP.get(operands.getMetal()));
		return Integer.toString(result);
	}
	
	/**
	 * This method calculates the metal value from the input and adds it to the map
	 * 
	 * @param operands
	 * @return
	 */
	public boolean calculateAndAddToMap(Operands operands) {
		/* Sample statement processed
		 * glob prok Silver is 500 Credits
		 */
		double multiplier = Integer.valueOf(operands.getCalculatedResult())
				/ romanCalculator.getArithmaticCalculation(operands.getFirstOperand(), operands.getSecondOperand());
		if(Metals.isMetal(operands.getMetal())){
			MULTIPLIER_CONVERSION_MAP.put(operands.getMetal(), multiplier);	
		}
		return MULTIPLIER_CONVERSION_MAP.containsKey(operands.getMetal());
	}
	
}
