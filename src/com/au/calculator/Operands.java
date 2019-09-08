package com.au.calculator;

/**
 * This class holds the operands, result, multiplier and other values
 */
public class Operands {
	
	private String calculatedResult = null;
	private String metal;
	private String firstOperand;
	private String secondOperand;
	private String thirdOperand;
	private String fourthOperand;
	private String statement;
	
	/**
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}
	/**
	 * @param statement the statement to set
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}
	/**
	 * @return the calculatedResult
	 */
	public String getCalculatedResult() {
		return calculatedResult;
	}
	/**
	 * @param calculatedResult the calculatedResult to set
	 */
	public void setCalculatedResult(String calculatedResult) {
		this.calculatedResult = calculatedResult;
	}
	/**
	 * @return the metal
	 */
	public String getMetal() {
		return metal;
	}
	/**
	 * @param metal the metal to set
	 */
	public void setMetal(String metal) {
		this.metal = metal;
	}
	/**
	 * @return the firstOperand
	 */
	public String getFirstOperand() {
		return firstOperand;
	}
	/**
	 * @param firstOperand the firstOperand to set
	 */
	public void setFirstOperand(String firstOperand) {
		this.firstOperand = firstOperand;
	}
	/**
	 * @return the secondOperand
	 */
	public String getSecondOperand() {
		return secondOperand;
	}
	/**
	 * @param secondOperand the secondOperand to set
	 */
	public void setSecondOperand(String secondOperand) {
		this.secondOperand = secondOperand;
	}
	/**
	 * @return the thirdOperand
	 */
	public String getThirdOperand() {
		return thirdOperand;
	}
	/**
	 * @param thirdOperand the thirdOperand to set
	 */
	public void setThirdOperand(String thirdOperand) {
		this.thirdOperand = thirdOperand;
	}
	/**
	 * @return the fourthOperand
	 */
	public String getFourthOperand() {
		return fourthOperand;
	}
	/**
	 * @param fourthOperand the fourthOperand to set
	 */
	public void setFourthOperand(String fourthOperand) {
		this.fourthOperand = fourthOperand;
	}
	
}
