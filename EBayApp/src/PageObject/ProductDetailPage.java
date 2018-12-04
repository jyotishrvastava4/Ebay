package PageObject;

import org.openqa.selenium.By;

import FrameworkFiles.AndroidBaseFunction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductDetailPage extends AndroidBaseFunction {

	public By Cartbtn=By.id("button_add_to_cart");
	public By ViewCartbtn=By.id("button_view_in_cart");
	
	public void ClickToCart(AndroidDriver<AndroidElement> driver)
		{
			WaitUntilElementVisible(driver, Cartbtn); 
			AndroidElement addToCart = AndroidFindElement(driver, Cartbtn);
			addToCart.click();
		}
	
	public void ClickViewCart (AndroidDriver<AndroidElement> driver){
		
		WaitUntilElementVisible(driver, ViewCartbtn); 
		AndroidElement viewInCart = AndroidFindElement(driver, ViewCartbtn);
		viewInCart.click();
	}
}

