package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.google.com/search?q=testing+tools");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Odp5De\"]/div/div/div[5]/div/span[1]/span[1]")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"Odp5De\"]/div/div/div[3]/div"));

		for (int i = 1; i <= list.size(); i++)
		{

			WebElement element = driver.findElement(By.xpath("//*[@id=\"Odp5De\"]/div/div/div[3]/div[" + i + "]"));
			element.click();
			
			WebElement text = driver
					.findElement(By.xpath("//*[@id=\"Odp5De\"]/div/div/div[3]/div[" + i + "]/div[2]/aside/div[1]/a"));
			System.out.println(text.getText());

			Thread.sleep(2000);

			
				WebElement Paratext = driver.findElement(By.xpath("//*[@id=\"Odp5De\"]/div/div/div[3]/div[" + i
						+ "]/div[2]/aside/div[2]/div[1]/div/div[2]/div/div/span[1]/span"));

				
				System.out.println(Paratext.getText());
			
			

			WebElement element2 = driver
					.findElement(By.xpath("//*[@id=\"Odp5De\"]/div/div/div[3]/div[" + i + "]/div[1]"));
			element2.click();

		}

	}

}
