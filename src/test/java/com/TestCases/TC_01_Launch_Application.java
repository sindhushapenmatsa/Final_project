package com.TestCases;

import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;

public class TC_01_Launch_Application extends GenericFunctions {
	
	
	@Test
	
	public static void launchapplication()
	{
		
		launchApplication("firefox");
		
	}
	
	

}
