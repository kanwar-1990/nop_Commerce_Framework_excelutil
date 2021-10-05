package com.nopcommerse.qa.Constants;

import java.util.ArrayList;
import java.util.List;

public  class Constants {

	public static final String RegistrationPage_Title="nopCommerce demo store. Register";
	public static final String LoginPage_Title="nopCommerce demo store. Login";
	public static final String LoginPage_Header="Welcome to our store";
	public static List<String> CatalogList()
	{
		List<String> list=new ArrayList<String>();
		list.add("Electronics");
		list.add("Apparel");
		list.add("Digital downloads");
		return list;
	}
}
