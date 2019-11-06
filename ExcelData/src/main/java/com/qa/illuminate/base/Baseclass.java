package com.qa.illuminate.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Baseclass {
	
	
	public static WebDriver driver;
	public static Properties prop;

	public Baseclass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/home/dev/eclipse-workspace/ExcelData/src/main/java/com/qa/illuminate/config/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void browserName() {
		String br = prop.getProperty("browser");

		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/dev/Downloads/chrome/chromedriver");
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}


}
