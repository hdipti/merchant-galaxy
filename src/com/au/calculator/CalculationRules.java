package com.au.calculator;

import com.au.common.RomanNumerals;

/**
 * This class has the rules for Roman Numerical calculations
 */
public class CalculationRules {

	/**
	 * This method checks if the two operands should be subtracted
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public boolean isSubtraction(String firstOperand, String secondOperand) {

		return ISubtrationRules(firstOperand, secondOperand) || XSubtrationRules(firstOperand, secondOperand)
				|| CSubtrationRules(firstOperand, secondOperand);

	}
	
	/**
	 * This method verifies if the first operand is I and if it the two operands should be subtracted
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	private boolean ISubtrationRules(String firstOperand, String secondOperand) {

		return firstOperand.equals(RomanNumerals.I.getSymbol()) && (secondOperand.equals(RomanNumerals.V.getSymbol())
				|| secondOperand.equals(RomanNumerals.X.getSymbol()));
	}

	/**
	 * This method verifies if the first operand is X and if it the two operands should be subtracted
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	private boolean XSubtrationRules(String firstOperand, String secondOperand) {

		return firstOperand.equals(RomanNumerals.X.getSymbol()) && (secondOperand.equals(RomanNumerals.L.getSymbol())
				|| secondOperand.equals(RomanNumerals.C.getSymbol()));
	}

	/**
	 * This method verifies if the first operand is C and if it the two operands should be subtracted
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	private boolean CSubtrationRules(String firstOperand, String secondOperand) {

		return firstOperand.equals(RomanNumerals.C.getSymbol()) && (secondOperand.equals(RomanNumerals.D.getSymbol())
				|| secondOperand.equals(RomanNumerals.M.getSymbol()));
	}
	
	/**
	 * This method checks for the valid operands to be repeated and if the
	 * repetition is more than 3 times in succession, its invalid
	 * 
	 * @param operands
	 * @return
	 */
	public boolean isInvalidRepetition(String... operands) {
		boolean isInvalidRepetition = false;
		if (!isRepeatable(operands[0]) || (isRepetitionUpto3Numerals(operands)
				&& ((operands.length > 3) && (operands[0].equals(operands[3]))))) {
			isInvalidRepetition = true;
		}
		return isInvalidRepetition;
	}
	
	/**
	 * This method checks if the operands are repeated upto 3 times
	 * 
	 * @param operands
	 * @return
	 */
	public boolean isRepetitionUpto3Numerals(String...operands){
		boolean isRepetition = false;
		String firstOperator = operands[0];
		if(firstOperator.equals(operands[1]) && isRepeatable(firstOperator)) {
			isRepetition = true;
		}
		
		if(!(isRepetition && ((operands.length > 2) && (firstOperator.equals(operands[2]))))){
			isRepetition = false;
		} 
		
		return isRepetition;
	}
	
	/**
	 * This method checks if the operand is repeatable. valid values are I, X, C and M
	 * 
	 * @param operand
	 * @return
	 */
	private boolean isRepeatable(String operand){
		return operand.equals(RomanNumerals.I.getSymbol()) ||
				operand.equals(RomanNumerals.X.getSymbol()) ||
				operand.equals(RomanNumerals.C.getSymbol()) ||
				operand.equals(RomanNumerals.M.getSymbol());
	}
	
	/**
	 * This method checks if the Roman numerical is a valid one. 
	 * It should not have more than 3 operands repeated in succession. 
	 * It cannot have more than one subtraction in the digit.
	 * 
	 * @param operands
	 * @return
	 */
	public boolean isValidDigit(String... operands) {

		boolean isInvalid = false;

		boolean compareFirstTwo = isSubtraction(operands[0], operands[1]);
		boolean compareSecondTwo = isSubtraction(operands[1], operands[2]);
		boolean compareThirdTwo = isSubtraction(operands[2], operands[3]);
		boolean isInvalidRepetition = isInvalidRepetition(operands[0], operands[1], operands[2], operands[3]);
		
		isInvalid = (compareFirstTwo && compareSecondTwo) || (compareFirstTwo && compareThirdTwo)
				|| (compareSecondTwo && compareThirdTwo) || isInvalidRepetition;

		return !isInvalid;

	}

}
