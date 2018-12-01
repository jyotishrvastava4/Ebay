package FrameworkFiles;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import PageObject.CartnCheckoutPage;
import PageObject.ProductDetailPage;
import PageObject.SearchProductPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.File;

public class EBayAutomation //extends AndroidBaseFunction
{
	
	public static void main(String[] args) throws InterruptedException, IOException, BiffException {
		String sDeviceName ="Mi A2";
		String sPlatformName = "Android";
		String sAppPackage = "com.ebay.mobile";
		String sAppActivity ="com.ebay.mobile.activities.MainActivity";
		String sAppiumURL ="http://127.0.0.1:4723/wd/hub";
		
		EBayAutomation EBay = new EBayAutomation();
		
		DesiredCapabilities _capibility = EBay.SetDesireCapibilities(sDeviceName, sPlatformName, sAppPackage, sAppActivity);
		URL AppiumServerUrl = new URL(sAppiumURL);
		AndroidDriver<AndroidElement> _driver = new AndroidDriver<AndroidElement>(AppiumServerUrl,_capibility);
		EBay.SearchAndAddingProductIntoCard(_driver);
	}
	public DesiredCapabilities SetDesireCapibilities(String sDeviceName,String sPlatformName,String sAppPackage,String sAppActivity)
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName",sDeviceName);
		cap.setCapability("platformName", sPlatformName);
		cap.setCapability("appPackage", sAppPackage);
		cap.setCapability("appActivity", sAppActivity);
		cap.setCapability("noReset", true);
		return cap;
	}
	
	public void SearchAndAddingProductIntoCard(AndroidDriver<AndroidElement> _driver) throws InterruptedException, IOException, BiffException
	{
				SearchProductPage Search_Prod= new SearchProductPage();
				ReadFromExcel sExcel = new ReadFromExcel();
				Search_Prod.ClickOnSearchBox(_driver); //Click on Search text box
				String sCategry = sExcel.ReadCategoryFromExcel();
				//sCategry = "Headphone";
				Search_Prod.EnterProductNameInSearchBox(_driver,sCategry ); //Enter product Name and tap on 1st suggestion
				Search_Prod.SelectProduct(_driver); //Select Product
				
				ProductDetailPage productDetail=new ProductDetailPage();
				productDetail.ClickToCart(_driver); // Click on Add to Cart button
				productDetail.ClickViewCart(_driver); // Click on View Cart button
				Thread.sleep(7000);
				
				CartnCheckoutPage checkout= new CartnCheckoutPage();
				checkout.ClickOnCheckout(_driver); //Click on Checkout button
				Thread.sleep(7000);
				checkout.VerifyConfirmAndPaybtn(_driver); // Verify the Confirm and Pay button is disabled
	}
}
