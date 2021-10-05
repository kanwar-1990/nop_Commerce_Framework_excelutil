package com.nopcommerce.qa.Test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.qa.Base.BaseTest;
import com.nopcommerce.qa.utils.excelutils;
import com.nopcommerse.qa.Constants.Constants;

public class RegisterPageTest extends BaseTest {

	@Test(priority = 1)
	public void registerlinkClickTest() {
		Assert.assertTrue(registerpage.registerlinkClick());
	}

	@Test(priority = 2, enabled = false)
	public void registrationPagetitleTest() {
		Assert.assertEquals(registerpage.RegistrationPagetitle(), Constants.RegistrationPage_Title);
	}

	@DataProvider
	public Object[][] getTestDataTest() {
		Object[][] data = excelutils.getTestData("Registration");
		return data;
	}
	
	public String getRandomEmailid()
	{
		Random randomnumber=new Random();
		
		String random="Noc_Commerce"+randomnumber.nextInt(1000)+"@gmail.com";
		return random;
	}
	

	@Test(priority = 3, dataProvider = "getTestDataTest")
	public void RegistrationPageTest(String Gender, String FirstName, String LastName, String Date, String month,
			String year, String CompanyName, String Password, String ConfirmPassword) {

		Assert.assertTrue(registerpage.registerDetailsFile(Gender, FirstName, LastName, Date, month, year, getRandomEmailid(),
				CompanyName, Password, ConfirmPassword));
		registerpage.registerlinkClick();
	}
}
