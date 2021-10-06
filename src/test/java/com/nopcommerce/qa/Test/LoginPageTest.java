package com.nopcommerce.qa.Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.qa.Base.BaseTest;
import com.nopcommerse.qa.Constants.Constants;

public class LoginPageTest extends BaseTest {

	@BeforeClass
	public void LoginPageSetup() {
		loginpage.loginlinkclick();
	}

	@Test(priority = 2)
	public void loginPageTittleTest() {
		Assert.assertEquals(loginpage.loginPageTittle(), Constants.LoginPage_Title);
	}

	@Test(priority = 1)
	public void ForgotLinkTest() {
		Assert.assertTrue(loginpage.ForgotLoginLinkcheck());
	}

	@Test(priority = 4)
	public void loginPageHeaderLogoTest() {
		Assert.assertTrue(loginpage.HeaderLogoCheck());
	}

	@Test(priority = 3)
	public void doLoginTest() {
		String SuccessMesg = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(SuccessMesg, Constants.LoginPage_Header);
	}

	@Test(priority = 5)
	public void CataloglistTest() {
		List<String> titlelist = loginpage.CatalogTitleslist();
		Assert.assertEquals(titlelist, Constants.CatalogList());

	}

	@Test(priority = 6)
	public void selectFromCategoryTest() {
		loginpage.SelectFromSubCategories("Electronics", "Cell phones");
	}

}
