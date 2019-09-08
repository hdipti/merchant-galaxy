package com.au.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum is the list of valid words used to denote question or conversion
 */
public enum WordBank {
    HOW("how"),
    MANY("many"),
    MUCH("much"),
    CREDITS("Credits"),
    IS("is"),
    QUESSTIONMARK("?");
	
	/**
	 * The map for valid words used in questions and conversions
	 */
	private static final Map<String, WordBank> wordMap = new HashMap<String, WordBank>();

	private final String word;
	
	static { // Generate the word map
		for(WordBank word : EnumSet.allOf(WordBank.class)){
			wordMap.put(word.getWord(), word);
		}
	}
	
	/**
	 * Constructor to create Word with valid name
	 * @param faceName
	 */
	WordBank(String word) {
		this.word = word;
	}

	public String getWord(){
		return this.word;
	}
	
	/**
	 * This method retrieves the Word by its name
	 * 
	 * @param word
	 * @return
	 */
	public static WordBank getQuestionWord(String word) {
		return wordMap.get(word);
	}
	
	/**
	 * This method checks if the input is a valid question word
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isQuestionWord(String word){
		return wordMap.containsKey(word);
	}
	
}
