package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_Mystore;

public class TC_06_Summer_Dresses extends GenericFunctions {
	
	
	
	@Test
	public static void Summer_Dresses()
	{
	launchApplication("firefox");
	Imp_wait();
	maximize();
	Login_Mystore lgn =PageFactory.initElements(driver,Login_Mystore.class);
	lgn.SignIn_Click();
	
	

	}
}
