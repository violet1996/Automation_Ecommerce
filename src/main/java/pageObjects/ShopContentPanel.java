package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopContentPanel
{
	public WebDriver driver;
	
	By continueShoppingBtn= By.xpath("//button[contains(text(),'Continue')]");
	By checkoutBtn = By.linkText("PROCEED TO CHECKOUT");
	
	public ShopContentPanel(WebDriver driver) {
		this.driver=driver;		
	}
	
	public WebElement getcontinueShoppingBtn() {
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getcheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
	
}
