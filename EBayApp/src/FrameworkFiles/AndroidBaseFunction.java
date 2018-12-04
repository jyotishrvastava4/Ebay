package FrameworkFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidBaseFunction {
	
 public static AndroidElement AndroidFindElement(AndroidDriver<AndroidElement> driver,By sElementID)
 {
	 //Find Element by ID
	 System.out.println("Finding Element by Locator- "+sElementID);
	 return driver.findElement(sElementID);
 }
 
 public static void WaitUntilElementVisible(AndroidDriver<AndroidElement> driver,By By)
 {
	 //Wait for max 10 second till element visible 
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By));
	 System.out.println("Wait till element visible: Locator-"+By);
 }
 
 public static void WaitUntilElementPresent(AndroidDriver<AndroidElement> driver,By By)
 {
	 //Wait for max 10 second till element present 
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By));
	 System.out.println("Wait till element Present: Locator-"+By);
 }
 
}
