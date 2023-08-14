package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminPrimaryTrancasctionView {
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
		driver.findElement(By.xpath("//*[@id=\"userTable\"]/tbody/tr/td[5]/p[1]")).click();
		Thread.sleep(2000);
		assertEquals(driver.getCurrentUrl(), "http://localhost:4201/primaryTransaction/22113345");

	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}