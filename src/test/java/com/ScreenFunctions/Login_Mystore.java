package com.ScreenFunctions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;
import com.ReportGeneration.GenerateReports;

public class Login_Mystore extends GenericFunctions {

	@FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Sign in']")
	public static WebElement btn_Sign_In;

	@FindBy(how = How.XPATH, using = "//input[@id='email_create']")
	public static WebElement Edi_Email_id;

	@FindBy(how = How.XPATH, using = "//button[@id='SubmitCreate']")
	public static WebElement btn_Create_Account;

	@FindBy(how = How.XPATH, using = "//div[@id='create_account_error']//ol//li")
	public static WebElement err_Account;
	
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/h1")
	public static WebElement hdr_Auth;
	
	@FindBy(how = How.XPATH, using = "//form[@id='create-account_form']/h3")
	public static WebElement hdr_create_Acc;
	
	@FindBy(how = How.XPATH, using = "//form[@id='login_form']/h3")
	public static WebElement hdr_Already_Reg;
	
	@FindBy(how = How.XPATH, using = "//form[@id='create-account_form']//label")
	public static WebElement lbl_create_Acc_Email;
	
	@FindBy(how = How.XPATH, using = "//form[@id='login_form']//label[text()='Email address']")
	public static WebElement lbl_Already_reg_Email;
	
	@FindBy(how = How.XPATH, using = "//form[@id='login_form']//label[text()='Password']")
	public static WebElement lbl_Already_reg_PW;
	

	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	public static WebElement section_Women;
	

//====================================================
	
	public void link_response_xpath() throws IOException
	{
		
		Link_response("//a[@title='Women']/..//a");
	}
	
	public void SignIn_Click() {

		btn_Sign_In.click();

	}

	public void Enter_Email() {

		Edi_Email_id.clear();
		String Emailid = getdata("TestcaseData", "Email_id", 1);
         StringBuffer SB = new StringBuffer(Emailid);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");

		StringBuffer s_new =SB.insert(Emailid.indexOf("@"),sdf.format(new Date()) );
		Edi_Email_id.sendKeys(s_new);
		Edi_Email_id.sendKeys(Keys.TAB);

	}

	public void Create_Account()

	{

		btn_Create_Account.click();
//		err_Account.isDisplayed();
//		System.out.println(err_Account.getText());
//		GenerateReports.logEvent("PASS", "Log :Email already exists");

	}
	
	//----------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//------------------------------------------------------------------------------------------------
	
	public static boolean validate_createAccountHeaders()
	{
		boolean status=true;
		
		try
		{
			label_Validation(lbl_create_Acc_Email,"Email_addr_CreateAccount",1);
			label_Validation(lbl_Already_reg_Email,"Email_addr_AlreadyRegister",1);
			label_Validation(lbl_Already_reg_PW,"Email_addr_AlreadyRegister",2);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			System.out.println("Unable to validate the label");
			logEvent("fail", "Unable to validate the label" +e.getStackTrace());
		}
		return status;
	}
	
	//=========================================================================================================================
	public static boolean validate_Titles()
	{
		boolean status=true;
		
		try
		{
			Title_Validation(hdr_Auth,"Titles",3);
			Title_Validation(hdr_create_Acc,"Titles",4);
			Title_Validation(hdr_Already_Reg,"Titles",5);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			System.out.println("Unable to validate the Title");
			logEvent("fail", "Unable to validate the Title" +e.getStackTrace());
		}
		return status;
	}
	
	
	//===================================================================================================
	
	//Hover onto sections
	public static void hover_Sections()
	{
		
		 hover(section_Women);
		 
	}
	
	
	
	
}	
