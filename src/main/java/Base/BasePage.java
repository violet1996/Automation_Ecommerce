package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage
{

	public static WebDriver driver;
	private String url;
	private Properties prop;

	public BasePage() throws IOException
	{
		prop = new Properties();
		FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(data);
	}

	public WebDriver getDriver() throws IOException
	{
		if (prop.getProperty("browser").equals("chrome"))
		{
			/*
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\Drivers\\chromedriver.exe");
			 */

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox"))
		{
			/*
			 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
			 * "\\src\\Drivers\\geckodriver.exe");
			 */
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		} else
		{
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public String getUrl() throws IOException
	{
		url = prop.getProperty("url");
		return url;
	}

	public void takeSnapShot(String name) throws IOException
	{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File("Z:\\Selenium SS" + timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);
	}

	public String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
