package com.nopcommerce.qa.Base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

	private Properties prop;
	private ChromeOptions CO;
	private FirefoxOptions FO;

	public OptionManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOption() {
		CO = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			CO.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("--incognito")))
			CO.addArguments("--incognito");
		return CO;

	}

	public FirefoxOptions getFireFoxOptions() {
		FO = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			FO.addArguments("--headless");

		if (Boolean.parseBoolean(prop.getProperty("--incognito")))
			FO.addArguments("--incognito");

		return FO;

	}

}
