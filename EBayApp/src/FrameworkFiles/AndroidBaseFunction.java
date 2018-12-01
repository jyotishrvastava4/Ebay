package FrameworkFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidBaseFunction {
	
 public static AndroidElement AndroidFindElementByID(AndroidDriver<AndroidElement> driver,String sElementID)
 {
	 //Find Element by ID
	 System.out.println("Finding Element by ID: "+sElementID);
	 return driver.findElement(By.id(sElementID));
 }
 
 public static AndroidElement AndroidFindElementByXpath(AndroidDriver<AndroidElement> driver,String Xpath)
 {
	//Find Element by Xpath
	 System.out.println("Finding Element by Xpath: "+Xpath);
	 return driver.findElement(By.xpath(Xpath));
 }
 
 
 public static AndroidElement AndroidFindElementByText(AndroidDriver<AndroidElement> driver,String Text)
 {
	//Find Element by Text
	 System.out.println("Finding Element by ID: "+Text);
	 return driver.findElementByName(Text);
 }
 
 public static void WaitUntilElementVisible(AndroidDriver<AndroidElement> driver,By By)
 {
	 //Wait for max 10 second till element visible 
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By));
	 System.out.println("Wait till element visible: Locator-"+By);
 }
 
}
