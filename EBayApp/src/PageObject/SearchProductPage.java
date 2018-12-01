package PageObject;

import org.openqa.selenium.By;
import FrameworkFiles.AndroidBaseFunction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class SearchProductPage extends AndroidBaseFunction {
	public String searchBox = "com.ebay.mobile:id/search_box";
	public String searchBox2="search_src_text";
	public String Item="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView";
	//public String Item_name="BOSE QuietComfort 35 II Headphones (Black)";
	public void ClickOnSearchBox(AndroidDriver<AndroidElement> driver)
	{
		AndroidElement _searchItem =  AndroidFindElementByID(driver, searchBox);
		_searchItem.click();
	}
	public void EnterProductNameInSearchBox(AndroidDriver<AndroidElement> driver,String ProductName) throws InterruptedException
	{
		AndroidElement _searchProduct =  AndroidFindElementByID(driver, searchBox2);
		_searchProduct.sendKeys(ProductName);
		Thread.sleep(5000);
		TouchAction Action= new TouchAction(driver);
		Action.tap(PointOption.point(291,321)).perform();
		WaitUntilElementVisible(driver,By.xpath(Item));
	}
	
	public void SelectProduct(AndroidDriver<AndroidElement> driver) throws InterruptedException
	{
		AndroidElement _Item = AndroidFindElementByXpath(driver, Item);
		_Item.click();
		Thread.sleep(3000);
	}
}
