package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ReportGeneration.GenerateReports;
import com.ScreenFunctions.Login_Mystore;
import org.openqa.selenium.support.PageFactory;

public class TC_02 extends GenericFunctions {
	  
	
	@Test

	public static void validation()
	{
		try{
		launchApplication("firefox");
		Imp_wait();
		maximize();
		Login_Mystore lgn =PageFactory.initElements(driver,Login_Mystore.class);
		lgn.SignIn_Click();
		lgn.Enter_Email();
		lgn.Create_Account();
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	

	
	

}
