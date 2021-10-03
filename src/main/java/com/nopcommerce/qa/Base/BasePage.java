package com.nopcommerce.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver(String BrowserName) {
		System.out.println("The browser value is :" + BrowserName);

		if (BrowserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (BrowserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();

			driver = new SafariDriver();
		}
		if (BrowserName.equals("IE")) {
			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Check the browser details Shared is : " + BrowserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/main/java/com/nopcommerse/qa/properties/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
