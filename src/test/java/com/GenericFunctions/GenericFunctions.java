package com.GenericFunctions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {
	
	
	public static  WebDriver driver;

	
	

	/*************************************************
	
	
	Function Name:launchApplication
	
	Purpose:-This Function is used to launch the HRM Application when ever the user is required
	
	Input Parameters:-User must send in which browser does the application need to be launch
	
	Output Parameters:-This method will return a boolean value stating wheter the user logged into in the system
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/30/2017
	
	
	**************************************************/
	
	
	
	
	
	public static boolean launchApplication(String browser) {
		
		boolean status=true;
		
		
		switch (browser.toLowerCase()) {
		case "ie":
			
			break;

		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			
			String url=getCommontestdata("Url");
			
			System.out.println(url);
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
			break;
			
		case "chrome":
			System. setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");		
			
			driver =new ChromeDriver();
			String url1=getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();

			break;
			
			
			
		default:
			break;
		}
		
	return status;	
		
	}
	

	/*************************************************
	
	
	Function Name:GetCommonTestdata 
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/
	
	
	
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	public static void waitForElement(WebElement element)
	{
	
		for(int i=1;i<=10;i++)
		{
		try
		{
			System.out.println("Wait is executing");
			Actions acc=new Actions(driver);
			acc.moveToElement(element).build().perform();
			
			System.out.println("Element Found");
			break;
			
		}
		catch(Exception e)
		{
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
		}
		}	
		
	}
	
	
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		
		
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
		return status;
	}
	//========================================================================
		public static boolean hover(WebElement element)
		{
		boolean status=true;
			
			try
			{
				waitForElement(element);
				Actions acc=new Actions(driver);
				acc.moveToElement(element).build().perform();
		
			}
			catch(Exception e)
			{
				
				status=false;
			
			}	
		
	
	
	return status;
	}	
		
//========================================================================
				public static void Link_response(String xpath ) throws IOException
				{
					boolean status=true;
					String response ="";
					
					try
					{
						List<WebElement> links_Women=driver.findElements(By.xpath(xpath));
						
						
						for(WebElement LL:links_Women)
						{
							String href = LL.getAttribute("href");
							
							URL myurl = new URL(href);
							HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
							
							con.connect();
							int response_got = con.getResponseCode();
							response = String.valueOf(response_got);
									// Integer.toString(response_got);
							if(response.startsWith("2"))
							{
								System.out.println(response +"Link is in active state");
								logEvent("pass", response + "Link is in active state");
							}
							
							else
							{
								System.out.println(response +"Link is not in active state");
								logEvent("fail", response + "Link is  not in active state");
							}
						}

					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
						logEvent("fail", response + "Link is  not in active state");
					}
					
			}	
//==============================================================================
	
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void maximize()
	{
		driver.manage().window().maximize();
	}
	
	public static void Imp_wait()
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	
	
	
	public static boolean label_Validation(WebElement Web_Element,String columnname,int Iteration)
	{
		boolean flag = false;
		String expecteddata=	getdata("TestcaseData", columnname, Iteration);
		
		try{
		
		
		
		//Now from the expected data , take the first character and save in a variable
		
		String expectdata_firstcharacter = String.valueOf(expecteddata.charAt(0));
		
		
		//Now from the expected data , take the whole string from position 1 
		String expecteddata_wholestring = expecteddata.substring(1);
		
		
		
		//Get the current webelement data		
		String string_Element_Text = Web_Element.getText();
		
		//get the first char ofwebelemnt text
		String char_at_FirstPosition = String.valueOf(string_Element_Text.charAt(0));
		
		String sub_str = string_Element_Text.substring(1);
		
		
		if(expectdata_firstcharacter.equals(char_at_FirstPosition) && expecteddata_wholestring.equals(sub_str))
		{
			logEvent("pass", "The Filed "+string_Element_Text+ " is same as expected Result "+expecteddata);
			flag=true;
		}
		else
		{
			logEvent("pass", "The Filed "+string_Element_Text+ " is not same as expected Result "+expecteddata);
			flag=false;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			System.out.println("Unable to validate the label for "+expecteddata);
			
			logEvent("fail", "Unable to validate the label for "+expecteddata+e.getStackTrace());
			flag=false;
		}
			
		return flag;
	}
	
	//=========================================================================================================================
	public static boolean Title_Validation(WebElement Web_Element,String columnname,int Iteration)
	{
		boolean flag = false;
		String expecteddata=getdata("TestcaseData", columnname, Iteration);
		
		try{
		
		//Get the current webelement data		
		String Actual_Element_Text = Web_Element.getText();
		
		 String font_weight = Web_Element.getCssValue("font-weight");
		
		
		if(Actual_Element_Text.equals(expecteddata) && font_weight.equals("600") )
		{
			logEvent("pass", "The Filed "+Actual_Element_Text+ " is same as expected Result "+expecteddata);
			flag=true;
		}
		else
		{
			logEvent("pass", "The Filed "+Actual_Element_Text+ " is not same as expected Result "+expecteddata);
			flag=false;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			System.out.println("Unable to validate the Title for "+expecteddata);
			
			logEvent("fail", "Unable to validate the Tile for "+expecteddata+e.getStackTrace());
			flag=false;
		}
			
		return flag;
	}
	
	
	

}


