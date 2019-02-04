package com.valentine.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.valentine.qa.utils.TestUtils;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream("/home/manish/eclipse-workspace/com.webSite.test"
					+ "/src/main/java/com/valentine/qa/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void browserSetup() {
		String browserName = prop.getProperty("browser");
		if("firefox".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib" + "/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			driver = new FirefoxDriver();
					
		} else if("chrome".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/chromedriver_linux64");
			driver = new ChromeDriver();		
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICTLY_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}

}
