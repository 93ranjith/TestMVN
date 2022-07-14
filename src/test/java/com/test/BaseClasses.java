package com.test;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasses {
	public static WebDriver driver;
	public static Action act;
	public static Robot rob;
	public static Select index;
	public static Select value;
	public static Select visibletext;
	public static Select option;
	public static Select sValue;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void toPassUrl(String Url) {
		driver.get(Url);

	}

	public static void maxWindow() {
		driver.manage().window().maximize();

	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void getTitleWebPage() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void closeAllWindow() {
		driver.quit();
	}

	public static void closeWindow() {
		driver.close();

	}

	public static void toInput(WebElement ref, String date) {

		ref.sendKeys(date);

	}

	public static void clickBtn(WebElement WebElement) {
		WebElement.click();
	}

	public static String getAttributeMethod(WebElement WebElement) {
		String attribute = WebElement.getAttribute("value");
		return attribute;

	}

	public static void getTextMethod(WebElement WebElement) {
		String text = WebElement.getText();
		System.out.println(text);

	}

	public static void waitMethod(int secounds) throws InterruptedException {
		Thread.sleep(secounds);
	}

	public static void select(WebElement element, String string) {
		sValue = new Select(element);
		sValue.selectByValue(string);
		
	}

	public static void screenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kumar\\eclipse-workspace\\GreenProject\\screenShot\\image.png");
		FileUtils.copyFile(src, dest);
	}

	public static String excelRead(int rownum, int cellnum) throws IOException {

		File src = new File("C:\\Users\\kumar\\eclipse-workspace\\GreenProject\\Excel folder\\Book1.xlsx");
		FileInputStream f = new FileInputStream(src);
		Workbook wb = new XSSFWorkbook(f);
		Sheet sheet = wb.getSheet("sheet1");
		Row allrow = sheet.getRow(rownum);
		Cell cell = allrow.getCell(cellnum);

		int cellType = cell.getCellType();
		String string = "";

		if (cellType == 1) {
			string = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
			string = sim.format(date);

		} else {
			double num = cell.getNumericCellValue();
			long l = (long) num;
			string = String.valueOf(l);
		}
		return string;

	}
}
