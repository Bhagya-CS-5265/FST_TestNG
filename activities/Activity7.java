package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	//WebDriver declaration
		WebDriver driver;
		//WebDriverWait declaration
		WebDriverWait wait;
		@BeforeClass(alwaysRun = true)
		public void setUp() {
		//Initialize driver
		driver = new FirefoxDriver();
		//Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Open the page
		driver.get(" https://training-support.net/webelements/login-form");
		}
		@BeforeMethod
		public void clearTextbox() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		}
		@Test(priority = 1)
		public void verifyTitle(){
			//Use getTitle() to get and print the title of the page.
			assertEquals(driver.getTitle(),"Selenium: Login Form");	
		}
		@DataProvider(name = "Credentials")
		public Object[][] creds(){
			//Return incorrect credentials for test
			return new Object[][] {
				{"adm1","pass1"},
				{"adm2","pass2"},
				{"adm3","pass3"},
				{"adm4","pass4"},
				{"adm5","pass5"}
			};
		}
		@Test(priority = 2, dataProvider="Authentication")
		public void loginFail(String username, String password){
			
			driver.findElement(By.id("username")).sendKeys(username);	
			driver.findElement(By.id("password")).sendKeys(password);
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
