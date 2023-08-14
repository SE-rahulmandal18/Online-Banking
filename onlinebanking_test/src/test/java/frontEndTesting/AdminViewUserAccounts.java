package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminViewUserAccounts {
	WebDriver driver;
	@BeforeTest
	public void setUp() {


		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\chromedriver_win32\\chromedriver.exe");
		
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("http://localhost:4201/login");
	}
	
	@Test(priority = 1)
	public  void loginUser() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//a[@routerlink='/userAccount']")).click();
		Thread.sleep(1000L);
		assertEquals(driver.getCurrentUrl(), "http://localhost:4201/userAccount");

	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}