package com.au.converter;

import java.util.StringTokenizer;

import com.au.common.CommonConstants;
import com.au.common.Metals;
import com.au.common.RomanNumerals;
import com.au.common.WordBank;

/**
 * This class validates the input and verifies if it is a valid conversion or a question
 */
public class StatementValidator implements CommonConstants {

	/**
	 * This method validates the valid question
	 * 
	 * @param input
	 * @return
	 */
	public boolean isValidQuestion(String input){
		boolean isValidQuestion = false;
		if(input.endsWith(WordBank.QUESSTIONMARK.getWord())){
			StringTokenizer tokenizer = new StringTokenizer(input);
			do {
				String word = tokenizer.nextToken();
				if(WordBank.isQuestionWord(word)){
					isValidQuestion = true;
					continue;
				}
				isValidQuestion = isValidQuestionParameter(word);
			} while(tokenizer.hasMoreTokens() && isValidQuestion);
		}
		return isValidQuestion;
	}

	/**
	 * This method checks for valid question words
	 * 
	 * @param word
	 * @return
	 */
	private boolean isValidQuestionParameter(String word) {
		return NUMERIC_CONVERSION_MAP.containsKey(word) || Metals.isMetal(word) || word.equals(WordBank.QUESSTIONMARK.getWord());
	}
	
	/**
	 * This method checks if the input is a valid conversion
	 * 
	 * @param input
	 * @return
	 */
	public boolean isValidConversion(String input) {
		boolean isValidConversion = false;
		StringTokenizer tokenizer = new StringTokenizer(input);

		if (tokenizer.countTokens() == TOKEN_SIZE_3) {
			isValidConversion = isAphabetic(tokenizer.nextToken())
					&& (WordBank.IS == WordBank.getQuestionWord(tokenizer.nextToken()))
					&& RomanNumerals.isRomanNumeral(tokenizer.nextToken());
		}
		return isValidConversion;
	}

	/**
	 * This method checks if the input is a valid calculation
	 * 
	 * @param input
	 * @return
	 */
	public boolean isValidCalculation(String input){
		boolean isValidCalculation = false;
		StringTokenizer tokenizer = new StringTokenizer(input);
		
		if(tokenizer.countTokens() == TOKEN_SIZE_6) {
			isValidCalculation = NUMERIC_CONVERSION_MAP.containsKey(tokenizer.nextToken()) &&
					NUMERIC_CONVERSION_MAP.containsKey(tokenizer.nextToken()) &&
					isAphabetic(tokenizer.nextToken()) &&
					(WordBank.IS == WordBank.getQuestionWord((tokenizer.nextToken()))) &&
					isNumeric(tokenizer.nextToken()) &&
					(WordBank.CREDITS == WordBank.getQuestionWord((tokenizer.nextToken())));
		}
		return isValidCalculation;
	}
	
	/**
	 * This method checks if the string is alphabets only
	 * 
	 * @param text
	 * @return
	 */
	private boolean isAphabetic(String text){
	return text.matches(ALPHABETS_ONLY_PATTERN);
	}
	
	/**
	 * This method checks if the string is numbers only
	 * 
	 * @param text
	 * @return
	 */
	private boolean isNumeric(String text) {
		return text.matches(NUMBERS_ONLY_PATTERN);
	}

}
