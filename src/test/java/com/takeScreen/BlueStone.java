package com.takeScreen;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class BlueStone {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws IOException, InterruptedException {

		driver.get("https://www.bluestone.com/store.html");
		Thread.sleep(2000);
		List<WebElement> frame = driver.findElements(By.xpath("//iframe[@width=\"100%\" and @height=\"300\"]"));
		System.out.println(frame.size());

		for (int i = 0; i < frame.size(); i++) {
			WebElement img = frame.get(i);
			Thread.sleep(2000);
			TakesScreenshot screen = (TakesScreenshot) img;
			Thread.sleep(2000);
			File fl = screen.getScreenshotAs(OutputType.FILE);
			File des = new File("F:\\Selenium\\LikithSelenium\\Likith\\ScreenShot\\ScreenShot\\" + i + ".png");
			FileUtils.copyFile(fl, des);

		}

	}

	@AfterClass
	public void teardrop() {
		driver.close();
	}

}
