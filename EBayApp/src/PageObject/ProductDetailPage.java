package PageObject;

import org.openqa.selenium.By;

import FrameworkFiles.AndroidBaseFunction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductDetailPage extends AndroidBaseFunction {

	public String Cartbtn="button_add_to_cart";
	public String ViewCartbtn="button_view_in_cart";
	public void ClickToCart(AndroidDriver<AndroidElement> driver)
		{
			WaitUntilElementVisible(driver, By.id(Cartbtn)); 
			AndroidElement addToCart = AndroidFindElementByID(driver, Cartbtn);
			addToCart.click();
		}
	
	public void ClickViewCart (AndroidDriver<AndroidElement> driver){
		
		WaitUntilElementVisible(driver, By.id(ViewCartbtn)); 
		AndroidElement viewInCart = AndroidFindElementByID(driver, ViewCartbtn);
		viewInCart.click();
	}
}

