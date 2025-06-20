package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity1 {
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
			driver.get("https://training-support.net");
		}
		@Test(priority = 1)
		public void verifyHomePage(){
			//Use getTitle() to get and print the title of the page.
			assertEquals(driver.getTitle(),"Training Support");	
		}
		
		@Test(priority = 2)
		public void verifyAboutPage() {
			//Use findElement() to find the "About Us" Button on the page and click it.
			driver.findElement(By.linkText("About Us")).click();
			
			//wait till page loads
			wait.until(ExpectedConditions.titleContains("About"));
			
			//assert page title
			assertEquals(driver.getTitle(), "About Training Support");
		}

		
		@AfterClass
		public void tearDown() {
			//close the browser
			driver.quit();
		}

}
