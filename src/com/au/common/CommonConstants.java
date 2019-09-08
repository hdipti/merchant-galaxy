package com.au.common;

import java.util.HashMap;

public interface CommonConstants {
	
	/**
	 * This map contains the mapping between metals and their values
	 */
	public static HashMap<String, Double> MULTIPLIER_CONVERSION_MAP = new HashMap<>();
	/**
	 * This map contains the mapping between words and their roman values
	 */
	public static HashMap<String, String> NUMERIC_CONVERSION_MAP = new HashMap<>();
	/**
	 * This is an empty string
	 */
	public static String EMPTY_STRING = "";
	/**
	 * This is the pattern to identify if the string is numeric	
	 */
	public static String NUMBERS_ONLY_PATTERN = "[0-9]*";
	/**
	 * This is a pattern to identify if the string contains only alphabets 
	 */
	public static String ALPHABETS_ONLY_PATTERN = "[a-zA-Z]+";
	/**
	 * The constant to check that the input has exactly 3 tokens
	 */
	public static int TOKEN_SIZE_3 = 3;
	/**
	 * The constant to check that the input has exactly 6 tokens
	 */
	public static int TOKEN_SIZE_6 = 6;
	/**
	 * error statement for invalid input question or statements
	 */
	public static String UNKNOWN_STATEMENT_ERROR = "I have no idea what you are talking about";
	/**
	 * This is a space delimiter
	 */
	public static String SPACE = " ";

}
