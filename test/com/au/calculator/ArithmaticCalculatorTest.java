package com.au.calculator;

import org.junit.Test;

import com.au.common.AbstractMapInitializerTest;

public class ArithmaticCalculatorTest extends AbstractMapInitializerTest {
	
	ArithmeticCalculator calculator = new ArithmeticCalculator();
	Operands operands = new Operands();
	
	@Test
	public void testAddToMapSuccess(){
		operands = new Operands();
		operands.setFirstOperand("I");
		operands.setSecondOperand("V");
		operands.setMetal("Silver");
		operands.setCalculatedResult("500");
		assertTrue(calculator.calculateAndAddToMap(operands));
	}
	
	@Test
	public void testAddToMapFail(){
		operands = new Operands();
		operands.setFirstOperand("I");
		operands.setSecondOperand("V");
		operands.setThirdOperand("I");
		operands.setCalculatedResult("500");
		assertFalse(calculator.calculateAndAddToMap(operands));
	}
	
	@Test
	public void testCalculateFirstPatternSuccess(){
		operands = new Operands();
		operands.setFirstOperand("X");
		operands.setSecondOperand("X");
		operands.setThirdOperand("I");
		operands.setFourthOperand("V");
		calculator.performCalculation(operands);
		assertEquals("24", operands.getCalculatedResult());
	}
	
	@Test
	public void testCalculateSecondPatternSuccess(){
		operands = new Operands();
		operands.setFirstOperand("I");
		operands.setSecondOperand("V");
		operands.setMetal("Silver");
		calculator.performCalculation(operands);
		assertEquals("500", operands.getCalculatedResult());
	}
	
	@Test
	public void testCalculateQuestionFail(){
		operands = new Operands();
		operands.setFirstOperand("J");
		operands.setSecondOperand("O");
		operands.setMetal("Dirt");
		calculator.performCalculation(operands);
		assertTrue(Double.isNaN(Double.valueOf(operands.getCalculatedResult())));
	}

}
