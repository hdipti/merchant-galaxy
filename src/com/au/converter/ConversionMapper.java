package com.au.converter;

import java.util.StringTokenizer;

import com.au.common.CommonConstants;

/**
 * This class maps the conversion between the word and it's roman value
 */
public class ConversionMapper implements CommonConstants {
	
	/**
	 * This method maps the word and it's roman value
	 * 
	 * @param input
	 * @return
	 */
	public boolean addToMap(String input){
		
		boolean isAddedToMap = false;
		StringTokenizer tokenizer = new StringTokenizer(input);
		
		if(tokenizer.countTokens() == TOKEN_SIZE_3){
			String key = tokenizer.nextToken();
			tokenizer.nextToken();
			String value = tokenizer.nextToken();
			CommonConstants.NUMERIC_CONVERSION_MAP.put(key, value);
			isAddedToMap = CommonConstants.NUMERIC_CONVERSION_MAP.containsValue(value);
		}
		
		return isAddedToMap;
	}

}
