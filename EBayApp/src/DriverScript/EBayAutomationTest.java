package DriverScript;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import FrameworkFiles.EBayAutomation;
import FrameworkFiles.ReadFromExcel;
import PageObject.CartnCheckoutPage;
import PageObject.ProductDetailPage;
import PageObject.SearchProductPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jxl.read.biff.BiffException;

public class EBayAutomationTest {

	@BeforeTest
	public DesiredCapabilities SetDesireCapibilities()
	{
	    String sDeviceName ="Mi A2";
		String sPlatformName = "Android";
		String sAppPackage = "com.ebay.mobile";
		String sAppActivity ="com.ebay.mobile.activities.MainActivity";
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName",sDeviceName);
		cap.setCapability("platformName", sPlatformName);
		cap.setCapability("appPackage", sAppPackage);
		cap.setCapability("appActivity", sAppActivity);
		cap.setCapability("noReset", true);
		return cap;
	}
	
  @Test
  public void main() throws BiffException, InterruptedException, IOException {    
	String sAppiumURL ="http://127.0.0.1:4723/wd/hub";
	
	DesiredCapabilities _capibility = SetDesireCapibilities();
	URL AppiumServerUrl = new URL(sAppiumURL);
	AndroidDriver<AndroidElement> _driver = new AndroidDriver<AndroidElement>(AppiumServerUrl,_capibility);
	//_driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	SearchAndAddingProductIntoCard(_driver);
  }
  

	public void SearchAndAddingProductIntoCard(AndroidDriver<AndroidElement> _driver) throws InterruptedException, IOException, BiffException
	{
				SearchProductPage Search_Prod= new SearchProductPage();
				ReadFromExcel sExcel = new ReadFromExcel();
				Search_Prod.ClickOnSearchBox(_driver); //Click on Search text box
				String sCategry = sExcel.ReadCategoryFromExcel();
				Search_Prod.EnterProductNameInSearchBox(_driver,sCategry ); //Enter product Name and tap on 1st suggestion
				Search_Prod.SelectProduct(_driver); //Select Product
				
				ProductDetailPage productDetail=new ProductDetailPage();
				productDetail.ClickToCart(_driver); // Click on Add to Cart button
				productDetail.ClickViewCart(_driver); // Click on View Cart button
				
				CartnCheckoutPage checkout= new CartnCheckoutPage();
				checkout.ClickOnCheckout(_driver); //Click on Checkout button
				checkout.VerifyConfirmAndPaybtn(_driver); // Verify the Confirm and Pay button is disabled
	}
}
