package com.au.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum is a list of the valid metals that can be traded
 */
public enum Metals {
	
	SILVER("Silver"),
    GOLD("Gold"),
    IRON("Iron");
	
	/**
	 * 
	 * The map for valid metals and their reference names
	 */
	private static final Map<String, Metals> metalMap = new HashMap<String, Metals>();
	
	private final String metal;
	
	static { // Generate metal map
		for(Metals metal : EnumSet.allOf(Metals.class)){
			metalMap.put(metal.getMetal(), metal);
		}
	}
	
	/**
	 * Constructor to create Metal with valid name
	 * @param meetal
	 */
	Metals(String metal) {
		this.metal = metal;
	}

	public String getMetal(){
		return this.metal;
	}
	
	/**
	 * This method retrieves the Metal by its name
	 * 
	 * @param metal
	 * @return
	 */
	public static Metals getMetalByName(String metal) {
		return metalMap.get(metal);
	}
	
	/**
	 * This method checks if the input is a valid metal name
	 * 
	 * @param metal
	 * @return
	 */
	public static boolean isMetal(String metal){
		return metalMap.containsKey(metal);
	}
	

}
