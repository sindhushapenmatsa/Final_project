package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_Mystore;

public class TC_05_Link_Validations extends GenericFunctions {
	
	@Test
	public static void Links_check() throws IOException
	{
	launchApplication("firefox");
	Imp_wait();
	maximize();
	Login_Mystore lgn =PageFactory.initElements(driver,Login_Mystore.class);
	lgn.SignIn_Click();
	lgn.hover_Sections();
	
	}

}
