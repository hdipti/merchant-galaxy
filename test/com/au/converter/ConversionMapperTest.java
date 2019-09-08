package com.au.converter;

import org.junit.Test;

import com.au.common.AbstractMapInitializerTest;

public class ConversionMapperTest extends AbstractMapInitializerTest {
	
	ConversionMapper mapper = new ConversionMapper();
	
	@Test
	public void testAddToMappSuccess(){
		assertTrue(mapper.addToMap("tegj is L"));
	}
	
	@Test
	public void testAddToMapFail(){
		assertFalse(mapper.addToMap("tegh usdba is H"));
	}
	
}
