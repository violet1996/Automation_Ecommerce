import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Character
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		long s = System.currentTimeMillis();

		driver.get("https://sta-web.qa.xseeddigital.info/loginScreen");

		long e = System.currentTimeMillis();
		// compute time
		long r = e - s;
		System.out.println("Page load time in milliseconds: " + r);

		long startTime = System.currentTimeMillis();
		// continue with email button
		driver.findElement(By.xpath("//*[@id=\"flt-semantic-node-13\"]")).click();

		// email
		driver.findElement(By.xpath("//input[@aria-label=\"Enter your email address*\"]"))
				.sendKeys("automation@gmail.com");

		// password
		driver.findElement(By.xpath("//input[@aria-label='Enter Password*']")).sendKeys("hiring@123");

		// login button
		driver.findElement(By.xpath("//*[@id=\"flt-semantic-node-16\"]")).click();

		long endTime = System.currentTimeMillis();

		// Calculate login time in milliseconds
		long loginTime = endTime - startTime;

		System.out.println("Login time: " + loginTime + " milliseconds");

		driver.close();

	}
}
