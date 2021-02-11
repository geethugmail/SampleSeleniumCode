package sandbox;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DockerTestFirefox {
	
	@Test
	public void loadUrl() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName(BrowserType.FIREFOX);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),cap);
		driver.get("https://buycloud.telstra.com");
		driver.findElement(By.partialLinkText("Log")).click();
	    Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}

}
