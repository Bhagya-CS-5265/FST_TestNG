package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	  //WebDriver declaration
		WebDriver driver;
		
		//WebDriver wait declaration
		WebDriverWait wait;
		
		@BeforeClass
		public void setUp() {
			//initialize driver
			driver = new FirefoxDriver();
			
			//Initialize wait 
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
			
		//open the page
		driver.get(" https://training-support.net/webelements/login-form/");
		}
		@Test(priority = 1)
		public void verifyTitle(){
			//Use getTitle() to get and print the title of the page.
			assertEquals(driver.getTitle(),"Selenium: Login Form");	
		}
		@Test(priority = 2)
		public void loginFail(){
			
			driver.findElement(By.id("username")).sendKeys("admin1");	
			driver.findElement(By.id("password")).sendKeys("wrongpassword");
			driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();;
			assertEquals(driver.findElement(By.id("subheading")).getText(),"Invalid credentials");
			
		}
		@Test(priority = 3)
		public void loginSuccess(){
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();;
			assertEquals(driver.getTitle(),"Selenium: Login Success!");
			
		}

		@AfterClass
		public void tearDown() {
			//close the browser
			driver.quit();
		}
		
		

}
