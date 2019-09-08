package com.au.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This is an enum for valid roman numericals
 */
public enum RomanNumerals {
	
	I("I", 1),
	V("V", 5),
	X("X", 10),
	L("L", 50),
	C("C", 100),
	D("D", 500),
	M("M", 1000);
	
	/** This map holds the mapping between roman numbers and their symbols */
	private static final Map<String, RomanNumerals> symbolMap = new HashMap<String, RomanNumerals>();
	/** This map holds the mapping between the roman numbers and their decimal equivalent	 */
	private static final Map<Integer, RomanNumerals> valueMap = new HashMap<Integer, RomanNumerals>();
	
	/** The decimal value for the Roman Numeral  */
	private final int value;
	/**  The roman symbol for the numeral */
	private final String symbol;
	
	static { // Generate the values and symbol map
		for(RomanNumerals numeral : EnumSet.allOf(RomanNumerals.class)){
			symbolMap.put(numeral.getSymbol(), numeral);
			valueMap.put(numeral.getValue(), numeral);
		}
	}
	
	/**
	 * Constructor to create Roman Numeral with the roman symbol and corresponding decimal value
	 * @param faceName
	 */
	RomanNumerals(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol(){
		return this.symbol;
	}
	
	public int getValue(){
		return this.value;
	}
	
	/**
	 * This method gets the roman numeral by the symbol given in the input
	 * 
	 * @param symbol
	 * @return
	 */
	public static RomanNumerals getRomanNumeralBySymbol(String symbol) {
		return symbolMap.get(symbol);
	}
	
	/**
	 * This method checks if the symbol in the input is a valid Roman Numeral
	 * 
	 * @param symbol
	 * @return
	 */
	public static boolean isRomanNumeral(String symbol){
		return symbolMap.containsKey(symbol);
	}
	
	/**
	 * This method gets the roman numeral by the value given in the input
	 * 
	 * @param value
	 * @return
	 */
	public static RomanNumerals getRomanNumeralByValue(int value) {
		return valueMap.get(Integer.valueOf(value));
		
	}

}
