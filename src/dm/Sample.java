package dm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {

	WebDriver driver;
	
	@BeforeTest
	public void hookupbrowser() throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        String Node = "http://10.112.66.52:5555/wd/hub";
       // DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        
        driver = new RemoteWebDriver(new URL(Node), cap);
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void runtest() throws IOException {
	
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.navigate().to("http://www.womanwithin.com/");
	driver.findElement(By.id("register")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.findElement(
			By.id("ctl00_GlobalBodyPlaceHolder_ucAccountProfile_txtFirstName"))
			.sendKeys("Automation");
	driver.findElement(
			By.id("ctl00_GlobalBodyPlaceHolder_ucAccountProfile_txtLastName"))
			.sendKeys("Testing");
	driver.findElement(
			By.id("ctl00_GlobalBodyPlaceHolder_ucAccountProfile_txtAddress1"))
			.sendKeys("462 7th");

	driver.findElement(
			By.id("ctl00_GlobalBodyPlaceHolder_ucAccountProfile_txtCity"))
			.sendKeys("New York");
	}
	/*Select sel = new Select(
			driver.findElement(By
					.id("ctl00_GlobalBodyPlaceHolder_ucAccountProfile_ddlStates")));
	sel.selectByIndex(3);*/
	@AfterTest
	public void windup() {
		driver.quit();
	}


	
}
