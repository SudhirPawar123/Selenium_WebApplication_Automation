package com.bridgelabz.qa.util;

import com.bridgelabz.qa.base.BaseTest;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends BaseTest {
    public static long PAGE_LOAD_TIMEOUT = 50;
    public static long IMPLICIT_WAIT = 50;

    public static String TestDataPath = "C:\\Users\\dell\\Desktop\\PageObjectModel\\src\\main\\java\\com\\bridgelabz\\qa\\testdata\\OrangeHRM_Appication_datatest.xls";

    static Workbook book;
    public static org.apache.poi.ss.usermodel.Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TestDataPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

}
