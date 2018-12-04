package PageObject;

import org.openqa.selenium.By;
import FrameworkFiles.AndroidBaseFunction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class SearchProductPage extends AndroidBaseFunction {
	public By searchBox = By.id("com.ebay.mobile:id/search_box");
	public By searchBox2=By.id("search_src_text");
	public By Item=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView");
	public By product=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView");
	
			
	
	public void ClickOnSearchBox(AndroidDriver<AndroidElement> driver)
	{
		AndroidElement _searchItem =  AndroidFindElement(driver, searchBox);
		_searchItem.click();
	}
	public void EnterProductNameInSearchBox(AndroidDriver<AndroidElement> driver,String ProductName) throws InterruptedException
	{
		AndroidElement _searchProduct =  AndroidFindElement(driver, searchBox2);
		_searchProduct.sendKeys(ProductName);
		WaitUntilElementVisible(driver,product);

		AndroidElement _product = AndroidFindElement(driver, product);
		_product.click();
		
	}
	
	public void SelectProduct(AndroidDriver<AndroidElement> driver) throws InterruptedException
	{
		WaitUntilElementVisible(driver,Item);
		AndroidElement _Item = AndroidFindElement(driver, Item);
		_Item.click();
	}
}
