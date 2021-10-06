package com.nopcommerse.qa.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopcommerce.qa.Base.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;

	private By loginLink = By.cssSelector(".ico-login");
	private By UserEmailid = By.cssSelector("#Email");
	private By password = By.id("Password");
	private By LoginBttn = By.xpath("(//button[@type='submit'])[2]");
	private By ForgotLoginLink = By.linkText("Forgot password?");
	private By WelcomeMesg = By.cssSelector(".topic-block-title h2");
	private By Catalogtitle = By.cssSelector(".title a");
	private By HeaderLogo = By.cssSelector(".header-logo a img");
	private By CatalogList = By.cssSelector(".title a");
	private By CategoryList = By.xpath("/html/body/div[6]/div[2]/ul[1]/li/a");
	private By SelectProduct=By.cssSelector(".product-title a");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String loginPageTittle() {
		return driver.getTitle();
	}

	public void loginlinkclick() {
		driver.findElement(loginLink).click();
	}

	public boolean ForgotLoginLinkcheck() {

		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		WebElement forgotlink = driver.findElement(ForgotLoginLink);
		return wait.until(ExpectedConditions.visibilityOf(forgotlink)).isDisplayed();

	}

	public boolean HeaderLogoCheck() {
		return driver.findElement(HeaderLogo).isDisplayed();
	}

	public List<String> CatalogTitleslist() {
		List<String> getList = new ArrayList<String>();
		List<WebElement> ItemList = driver.findElements(Catalogtitle);
		for (WebElement e : ItemList) {
			System.out.println(e.getText());
			getList.add(e.getText());
		}
		System.out.println(getList);
		return getList;
	}

	public String doLogin(String emailid, String password) {
		driver.findElement(UserEmailid).sendKeys(emailid);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(LoginBttn).click();
		return driver.findElement(WelcomeMesg).getText();
	}

	public void SelectFromSubCategories(String CategoryName, String SubCategoryName) {

		List<WebElement> Categorylist1 = driver.findElements(CategoryList);
		for (WebElement e : Categorylist1)

		{
			if (e.getText().equals(CategoryName)) {
				e.click();
				break;
			}
		}
		List<WebElement> CategoryList2 = driver.findElements(CatalogList);
		for (WebElement e : CategoryList2) {
			System.out.println(e.getText());
			if (e.getText().equals(SubCategoryName)) {
				e.click();
				break;
			}
		}

		
		
		
	}
}
