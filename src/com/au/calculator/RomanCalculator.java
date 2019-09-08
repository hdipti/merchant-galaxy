package com.au.calculator;

import com.au.common.CommonConstants;
import com.au.common.RomanNumerals;

/**
 * This class performs the calculation on Roman Numerical
 */
public class RomanCalculator implements CommonConstants {
	
	/**
	 * The rules applicable for roman calculations
	 */
	CalculationRules rules = new CalculationRules();

	/**
	 * This method checks if the operands should be subtracted and returns the calculated result else returns the added values
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public int getArithmaticCalculation(String firstOperand, String secondOperand){

		int result = 0;
		if(rules.isSubtraction(firstOperand, secondOperand)){
			result = getArithmaticValue(secondOperand) - getArithmaticValue(firstOperand);
		} else {
			result = getArithmaticValue(secondOperand) + getArithmaticValue(firstOperand);
		}
		return result;
		
	}
	
	/**
	 * This method performs the conversion from Roman number to decimal number and retuns result
	 * 
	 * @param operands
	 * @return
	 */
	public String calculateResult(Operands operands) {
		return (isValidRepetition(operands) && isValidDigit(operands)) ? checkForSubtractionAndCalculateResult(operands)
				: Double.toString(Double.NaN);

	}
	
	/**
	 * This method retrieves the decimal value for the roman numerical
	 * 
	 * @param operand
	 * @return
	 */
	private int getArithmaticValue(String operand){
		return  RomanNumerals.getRomanNumeralBySymbol(operand).getValue();
	}

	/**
	 * This method checks for values to be subtracted from the roman numerical and calculated the decimal value for the roman number
	 * 
	 * @param operands
	 * @return
	 */
	private String checkForSubtractionAndCalculateResult(Operands operands) {
		int result = 0;
		if (isSubtraction(operands.getSecondOperand(), operands.getThirdOperand())) {
			result = subtractTheTwo(operands.getSecondOperand(), operands.getThirdOperand())
					+ addOtherOperands(operands.getFirstOperand(), operands.getFourthOperand());
			
		} else if (isSubtraction(operands.getThirdOperand(), operands.getFourthOperand())) {
			result = subtractTheTwo(operands.getThirdOperand(), operands.getFourthOperand())
					+ addOtherOperands(operands.getFirstOperand(), operands.getSecondOperand());
			
		} else {
			result = subtractTheTwo(operands.getFirstOperand(), operands.getSecondOperand())
					+ addOtherOperands(operands.getThirdOperand(), operands.getFourthOperand());
		}

		return Integer.toString(result);
	}

	/**
	 * This method returns the subtraction between the two operands
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	private int subtractTheTwo(String firstOperand, String secondOperand) {
		return getArithmaticCalculation(firstOperand, secondOperand);
	}
	
	/**
	 * This method returns the addition between the two operands
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	private int addOtherOperands(String firstOperand, String secondOperand) {
		return getArithmaticCalculation(firstOperand, secondOperand);
	}

	/**
	 * Checks if the two operands should be subtracted
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	private boolean isSubtraction(String firstOperand, String secondOperand) {
		return rules.isSubtraction(firstOperand, secondOperand);
	}

	/**
	 * This method checks if the opernads can be repeated and if they are repeated more than thrice
	 * 
	 * @param operands
	 * @return
	 */
	private boolean isValidRepetition(Operands operands) {
		return !rules.isInvalidRepetition(operands.getFirstOperand(), operands.getSecondOperand(),
				operands.getThirdOperand(), operands.getFourthOperand());
	}
	
	/**
	 * Checks if the roman number is a valid one
	 * 
	 * @param operands
	 * @return
	 */
	private boolean isValidDigit(Operands operands) {
		return rules.isValidDigit(operands.getFirstOperand(), operands.getSecondOperand(), operands.getThirdOperand(),
				operands.getFourthOperand());
	}
}
