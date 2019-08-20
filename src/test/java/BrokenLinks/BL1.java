package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BL1 {
	@Test
	public void test1() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qspiders.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class=\"close\"]")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement webElement : links) {
			URL U = new URL(webElement.getAttribute("href"));
			HttpURLConnection connection = (HttpURLConnection) U.openConnection();
			int i = connection.getResponseCode();
			if (i == 200) {
				Thread.sleep(2000);
				System.out.println("link is not broken");
			}

			else {
				System.out.println("link is broken ");
			}

		}
		driver.close();
	}
}
