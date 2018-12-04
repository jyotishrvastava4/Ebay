package PageObject;

import org.openqa.selenium.By;

import FrameworkFiles.AndroidBaseFunction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class CartnCheckoutPage extends AndroidBaseFunction {
    public By confirmnPay=By.id("purchase_link");
	public By cart_page = By.id("com.ebay.mobile:id/toolbar_centered_title");

	public void ClickOnCheckout(AndroidDriver<AndroidElement> driver){
		WaitUntilElementVisible(driver, cart_page); 
		TouchAction Action= new TouchAction(driver);
	    Action.tap(PointOption.point(505, 1901)).perform();
	}
	
	
	public void VerifyConfirmAndPaybtn(AndroidDriver<AndroidElement> driver){
		WaitUntilElementPresent(driver,confirmnPay);
		try
		{
			boolean bConfirmAndPaybtn = AndroidFindElement(driver, confirmnPay).isEnabled();
			if (bConfirmAndPaybtn == false)
			{
				System.out.println("'Confirm and Pay' button is disabled: Expected");
			}
			else
			{
				System.out.println("'Confirm and Pay' button is enabled: Not Expected");
			}
		}
		catch(Exception e)
		{
			System.out.println("Element Not found");
		}
		}
	
}

