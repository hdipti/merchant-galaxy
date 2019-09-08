package com.au.common;

import org.junit.BeforeClass;

import junit.framework.TestCase;

public abstract class AbstractMapInitializerTest extends TestCase{
	
	@BeforeClass
	public void setUp(){
		CommonConstants.NUMERIC_CONVERSION_MAP.put("glob", "I");
		CommonConstants.NUMERIC_CONVERSION_MAP.put("prok", "V");
		CommonConstants.NUMERIC_CONVERSION_MAP.put("pish", "L");
	}
	
}
