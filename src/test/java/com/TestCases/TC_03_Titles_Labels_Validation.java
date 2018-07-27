package com.TestCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;

import com.ScreenFunctions.Login_Mystore;


public class TC_03_Titles_Labels_Validation extends GenericFunctions{
	
	
	@Test
	public static void Header(){
         try{
		launchApplication("firefox");
		Imp_wait();
		maximize();
		Login_Mystore lgn =PageFactory.initElements(driver,Login_Mystore.class);
		lgn.SignIn_Click();
		Login_Mystore.validate_Titles();
		Login_Mystore.validate_createAccountHeaders();
         }
         catch(Exception e)
         {
        	 System.out.println(e.getMessage());
         }
		
		}
	}
	


