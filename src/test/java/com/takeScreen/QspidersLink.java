package com.takeScreen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QspidersLink {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver =new ChromeDriver();
		
	}
	@Test
	public void test1() throws IOException {
		
		driver.get("https://demo.actitime.com/login.do");
		WebElement at=driver.findElement(By.xpath("//td[@id=\"whiteBoxWithLogoBody\"]"));
		TakesScreenshot tk=(TakesScreenshot) at;
		File f1=tk.getScreenshotAs(OutputType.FILE);
		File des = new File("F:\\Selenium\\LikithSelenium\\Likith\\ScreenShot\\ScreenShot\\demo1.png");
		FileUtils.copyFile(f1, des);
	}
	@AfterClass
	public void teardrop() {
		driver.close();
	}

}
