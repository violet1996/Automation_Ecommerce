package Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test2
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("game");

		Thread.sleep(5000);
		WebElement rows = driver.findElement(By.xpath("//div[7]//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		String s = rows.getText();
		System.out.println("rows: "+s);
		}

	

}
