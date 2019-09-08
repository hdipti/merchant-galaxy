package com.au.calculator;

import org.junit.Test;

import com.au.common.AbstractMapInitializerTest;

public class StatementSolverTest extends AbstractMapInitializerTest{
	
	StatementSolver solver = new StatementSolver();
	
	@Test
	public void testComplexConversionSuccess(){
		assertTrue(solver.solveComplexConversion("glob prok Silver is 500 Credits"));
	}
	
	@Test
	public void testComplexConversionFail(){
		assertFalse(solver.solveComplexConversion("glob prok glob is 500 Credits"));
	}
	
	@Test
	public void testSolveQuestionFirstPatternSuccess(){
		assertTrue(solver.solveQuestion("how much is glob prok pish pish ?"));
	}
	
	@Test
	public void testSolveQuestionSecondPatternSuccess(){
		assertTrue(solver.solveQuestion("how many Credits is glob prok Silver ?"));
	}
	
}
