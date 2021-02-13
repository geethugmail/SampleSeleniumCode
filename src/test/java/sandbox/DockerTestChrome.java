package sandbox;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DockerTestChrome {
	
	@Test
	public void loadUrl() throws MalformedURLException, InterruptedException {
		
// 		DesiredCapabilities cap= new DesiredCapabilities();
// 		cap.setBrowserName(BrowserType.CHROME);
		System.setProperty("webdriver.chrome.driver", "/app/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		WebDriver driver = new ChromeDriver(options);
// 		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("https://buycloud.telstra.com");
		driver.findElement(By.partialLinkText("Log")).click();
        Assert.assertEquals(driver.getTitle(),"Cloud Services Store");
		Thread.sleep(5000);
		driver.quit();
	}

}
