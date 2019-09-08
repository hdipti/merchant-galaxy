package com.au.calculator;

import org.junit.Test;

import junit.framework.TestCase;

public class RomanCalculatorTest extends TestCase{
	
	RomanCalculator calculator = new RomanCalculator();
	Operands operands = new Operands();
	
	@Test
	public void testSubtractionSuccess(){
		assertEquals(4, calculator.getArithmaticCalculation("I", "V"));
	}
	
	@Test
	public void testAdditionSuccess(){
		assertEquals(6, calculator.getArithmaticCalculation("V", "I"));
	}
	
	@Test
	public void testValidRepetitionSuccess(){
		operands = new Operands();
		operands.setFirstOperand("I");
		operands.setSecondOperand("I");
		operands.setThirdOperand("I");
		operands.setFourthOperand("V");
		assertEquals("6", calculator.calculateResult(operands));
	}
	
	@Test
	public void testInValidRepetitionFail(){
		operands = new Operands();
		operands.setFirstOperand("I");
		operands.setSecondOperand("I");
		operands.setThirdOperand("I");
		operands.setFourthOperand("I");
		assertEquals(Double.toString(Double.NaN), calculator.calculateResult(operands));
	}

	@Test
	public void testValidCalculationSuccess(){
		operands = new Operands();
		operands.setFirstOperand("X");
		operands.setSecondOperand("X");
		operands.setThirdOperand("I");
		operands.setFourthOperand("V");
		System.out.println(calculator.calculateResult(operands));
		assertEquals("24", calculator.calculateResult(operands));
	}
	
	@Test
	public void testInValidCalculationFail(){
		operands = new Operands();
		operands.setFirstOperand("I");
		operands.setSecondOperand("X");
		operands.setThirdOperand("I");
		operands.setFourthOperand("V");
		assertEquals(Double.toString(Double.NaN), calculator.calculateResult(operands));
	}

	
}
