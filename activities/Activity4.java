package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
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
	driver.get("https://training-support.net/webelements/target-practice");
	}
	@Test(priority = 1)
	public void verifyPageTitle() {
	assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	//Find the third header and assert the text in the h3 tag.
	@Test(groups = {"HeaderTest"})
	public void header3() {
	String message = driver.findElement(By.xpath("//h3[contains(@class,'text-orange-600')]")).getText();
	assertEquals(message, "Heading #3");
	}
	//Find and assert the colour of the fifth header tag element.
	@Test(groups = {"HeaderTest"})
	public void header5() {
	String colour = driver.findElement(By.xpath("//h5[text()='Heading #5']")).getCssValue("color");
	assertEquals(colour, "rgb(147, 51, 234)");
	}
	//Find the button with the class emerald and assert it text.
	@Test(groups = {"ButtonTest"})
	public void emeraldButton() {
	String message = driver.findElement(By.cssSelector("button.bg-emerald-200")).getText();
	assertEquals(message,"Emerald");
	}
	//Find and assert the colour of the first button in the third row.
	@Test(groups = {"ButtonTest"})
	public void purpleButton() {
	String col = driver.findElement(By.className("bg-purple-200")).getCssValue("color");
	assertEquals(col, "rgb(88, 28, 135)");
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
	driver.quit(); //browser will close even if there were errors
	}
}
