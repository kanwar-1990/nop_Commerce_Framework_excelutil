package com.nopcommerce.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutils {

	private static final String Test_Data_Sheet = "./src/main/java/com/nopcommerce/qa/TestData/nop_Commerce.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getTestData(String SheetName)

	{
		Object[][] data = null;
		try {
			FileInputStream ip = new FileInputStream(Test_Data_Sheet);

			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(SheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

		return data;
	}

}
