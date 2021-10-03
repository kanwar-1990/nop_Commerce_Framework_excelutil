package com.nopcommerce.qa.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.nopcommerse.qa.Page.RegistrationPage;

public class BaseTest {
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public RegistrationPage registerpage;

	@BeforeTest
	public void Setup() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver("chrome");
		String browser = prop.getProperty("url");
		driver.get(browser);
		registerpage = new RegistrationPage(driver);

	}

	@AfterTest
	public void teardown() {
		//driver.quit();
	}
}
