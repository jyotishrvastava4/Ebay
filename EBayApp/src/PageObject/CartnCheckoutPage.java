package PageObject;

import org.openqa.selenium.By;

import FrameworkFiles.AndroidBaseFunction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class CartnCheckoutPage extends AndroidBaseFunction {
    public String confirmnPay="purchase_link";
    
	public void ClickOnCheckout(AndroidDriver<AndroidElement> driver){
	TouchAction Action= new TouchAction(driver);
	Action.tap(PointOption.point(505, 1901)).perform();
	}
	
	
	public void VerifyConfirmAndPaybtn(AndroidDriver<AndroidElement> driver){
		try
		{
			boolean bConfirmAndPaybtn = AndroidFindElementByID(driver, confirmnPay).isEnabled();
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

