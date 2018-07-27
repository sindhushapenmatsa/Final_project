package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_Mystore;

public class TC04_New_Registration extends GenericFunctions{
	
	@Test
	public static void User_Reg()
	{
		
		launchApplication("firefox");
		Imp_wait();
		maximize();
		Login_Mystore lgn =PageFactory.initElements(driver,Login_Mystore.class);
		lgn.SignIn_Click();
		lgn.Enter_Email();
		lgn.Create_Account();
		
	}
	
	
	
	

}
