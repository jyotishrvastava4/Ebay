package DriverScript;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
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
	public AndroidDriver<AndroidElement> _driver;
	
    @BeforeTest
	public void SetDesireCapibilities() throws MalformedURLException
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
		
        String sAppiumURL ="http://127.0.0.1:4723/wd/hub";
		
		//DesiredCapabilities _capibility = SetDesireCapibilities();
		URL AppiumServerUrl = new URL(sAppiumURL);
		_driver = new AndroidDriver<AndroidElement>(AppiumServerUrl,cap);
		System.out.println("Driver Launched");
	}
	
	@Test(priority=1)
	public void Find_product() throws BiffException, InterruptedException, IOException {    		
		SearchProductPage Search_Prod= new SearchProductPage();
		ReadFromExcel sExcel = new ReadFromExcel();
		Search_Prod.ClickOnSearchBox(_driver); //Click on Search text box
		String sCategry = sExcel.ReadCategoryFromExcel();
		Search_Prod.EnterProductNameInSearchBox(_driver,sCategry);
		Search_Prod.Product_Existence(_driver);
	  }
	
	
	@Test(priority=2)
	public void Find_EstimatedDate() throws BiffException, InterruptedException, IOException {    
		SearchProductPage Search_Prod= new SearchProductPage();
		Search_Prod.SelectProduct(_driver); //Select Product
		ProductDetailPage productDetail=new ProductDetailPage();
		productDetail.EstimatedDate(_driver);
		
	  }
	
  @Test(priority=3)
  public void AddProductToCart() throws BiffException, InterruptedException, IOException {    
	  ProductDetailPage productDetail=new ProductDetailPage();
		productDetail.ClickToCart(_driver); // Click on Add to Cart button
		productDetail.ClickViewCart(_driver); // Click on View Cart button
		
		CartnCheckoutPage checkout= new CartnCheckoutPage();
		checkout.ClickOnCheckout(_driver); //Click on Checkout button
		checkout.VerifyConfirmAndPaybtn(_driver); // Verify the Confirm and Pay button is disabled
  }
	
	@AfterTest
	public void CloseDriver()
	{
		_driver.quit();
		System.out.println("Driver successfully closed");
	}
}
