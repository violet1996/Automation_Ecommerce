import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class APP
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		long s = System.currentTimeMillis();

		driver.get("https://www.linkedin.com/feed/");

		WebElement ele= driver.findElement(By.xpath("//span[@class='notification-badge__count ']/parent::span/parent::div[@id='ember15']"));
		System.out.println(ele.getText());

		driver.close();

	}
}
