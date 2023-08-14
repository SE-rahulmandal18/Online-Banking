package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateUser {
	WebDriver driver;
	@BeforeTest
	public void setUp() {


		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\chromedriver_win32\\chromedriver.exe");
		
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
	}
	/*
	@Test(priority = 1)
	public  void loginUser() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("rahul610@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Rahul#0000");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000L);
		
		//Here i have to add the step 
		driver.findElement(By.xpath("//div[@id=\"navbarResponsive\"]/ul[2]/li/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id=\"navbarResponsive\"]/ul[2]/li/div/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("editbtn")).click();
		
		driver.findElement(By.id("fname")).sendKeys("RahulM");
		Thread.sleep(2000);
		driver.findElement(By.id("lname")).sendKeys("Mandal");
		Thread.sleep(2000);
		driver.findElement(By.id("mail")).sendKeys("rahulM610gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("Mobile")).sendKeys("7894561234");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("rahul12345");
		Thread.sleep(2000);
		driver.findElement(By.id("address")).sendKeys("Mumbai");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@style=\"background-color: blue;\"]")).click();
		Thread.sleep(2000);
	}
*/
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
