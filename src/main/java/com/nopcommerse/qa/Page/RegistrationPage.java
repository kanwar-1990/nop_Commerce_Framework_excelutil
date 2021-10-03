package com.nopcommerse.qa.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.nopcommerce.qa.Base.BasePage;

public class RegistrationPage extends BasePage {

	private WebDriver driver;
	private By RegisterLink = By.cssSelector(".ico-register");
	private By RegisterPageHeader = By.xpath("//strong[normalize-space()='Your Personal Details']");
	private By GenderMale = By.id("gender-male");
	private By GenderFemale = By.id("gender-female");
	private By FirstName = By.id("FirstName");
	private By LastName = By.id("LastName");
	private By email = By.id("Email");
	private By CompanyName = By.id("Company");
	private By NewsLetter = By.id("Newsletter");
	private By Password = By.xpath("(//input[@type='password'])[1]");
	private By ConfirmPassword = By.xpath("(//input[@type='password'])[2]");
	private By RegisterOption = By.name("register-button");
	private By SelectDay = By.name("DateOfBirthDay");
	private By SelectMonth = By.name("DateOfBirthMonth");
	private By SelectYear = By.name("DateOfBirthYear");
	private By RegistrationSuccessMesg = By.cssSelector("div.result");
    private By ContinueButton=By.linkText("Continue");
    private By Logout=By.linkText("Log out");
    
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String RegistrationPagetitle()
	{
		return driver.getTitle();
	}

	public boolean registerlinkClick() {
		driver.findElement(RegisterLink).click();
		String HeaderName = driver.findElement(RegisterPageHeader).getText();
		if (HeaderName.equalsIgnoreCase("Your Personal Details")) {
			return true;
		} else
			return false;
	}

	public void dateOFBirth(String Date, String month, String year) {
		WebElement day = driver.findElement(SelectDay);
		Select select = new Select(day);
		List<WebElement> DayList = select.getOptions();
		for (WebElement e : DayList) {
			if (e.getText().equals(Date)) {
				e.click();
				break;
			}
		}
		WebElement Month = driver.findElement(SelectMonth);
		Select select1 = new Select(Month);
		List<WebElement> MonthList = select1.getOptions();
		for (WebElement e1 : MonthList) {
			if (e1.getText().equals(month)) {
				e1.click();
				break;
			}
		}

		WebElement Year = driver.findElement(SelectYear);
		Select select2 = new Select(Year);
		List<WebElement> YearList = select2.getOptions();
		for (WebElement e3 : YearList) {
			if (e3.getText().equals(year)) {
				e3.click();
				break;
			}

		}
	}

	public boolean registerDetailsFile(String Gender, String FirstName, String LastName, String Date, String month,
			String year, String email, String CompanyName, String Password, String ConfirmPassword) {
		if (Gender.equals("Male")) {
			driver.findElement(GenderMale).click();
		} else {
			driver.findElement(GenderFemale).click();
		}
		driver.findElement(this.FirstName).sendKeys(FirstName);
		driver.findElement(this.LastName).sendKeys(LastName);
		dateOFBirth(Date, month, year);
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.CompanyName).sendKeys(CompanyName);
		driver.findElement(this.Password).sendKeys(Password);
		driver.findElement(this.ConfirmPassword).sendKeys(ConfirmPassword);
		driver.findElement(RegisterOption).click();
		String SuccessMesg = driver.findElement(RegistrationSuccessMesg).getText();
		driver.findElement(Logout).click();

		if (SuccessMesg.contains("Your registration completed")) {
			return true;
		} else {
			return false;
		}
	
	
	
	}

}
