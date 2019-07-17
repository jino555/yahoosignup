package com.yahoo.com.yahoo;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Signup_locators {

	WebDriver driver;

	// Signup locators//

	By firstname = By.id("usernamereg-firstName");
	By surname = By.xpath("//input[@id='usernamereg-lastName']");
	By email = By.name("email");
	By password = By.id("usernamereg-password");
	By Birthmonth = By.id("usernamereg-month");
	By day = By.id("usernamereg-day");
	By year = By.id("usernamereg-year");
	By Gender = By.id("usernamereg-freeformGender");
	By submit = By.id("reg-submit-button");
	By verification = By.name("sendCode");

	
	
	//Constructor
	public Signup_locators(WebDriver driver)

	{
		this.driver = driver;

	}

	// Verify Signup Positve testcases

	public void signup(String nm, String lastnm, String eml, String ps, String mnth, String dy, String yr, String Gen)
			throws Exception

	{

		driver.findElement(firstname).sendKeys(nm);
		driver.findElement(surname).sendKeys(lastnm);
		driver.findElement(email).sendKeys(eml);
		driver.findElement(password).sendKeys(ps);
		new Select(driver.findElement(Birthmonth)).selectByVisibleText(mnth);
		driver.findElement(day).sendKeys(dy);
		driver.findElement(year).sendKeys(yr);
		driver.findElement(Gender).sendKeys(Gen);
		driver.findElement(submit).click();
		
		//checking sign up till verification
		String title = driver.findElement(verification).getText();
		System.out.println(title);
		Assert.assertTrue("Signup verified", title.contains("verification"));

	}

	
	
	
	// Verify Signup negative testcases

	public void signup_negtestcase() {

		// check whether system not allows blank submission

		driver.findElement(submit).click();
		String error = driver.findElement(By.xpath("//*[@id=\"reg-error-password\"]")).getText();
		System.out.println("validation message is present " + error);
		
	}

	
	
	
	// Verify links
	
	
	public void linksverify() {

		// verify Terms links


		driver.findElement(By.linkText("Terms")).click();
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> array = new ArrayList(set);
		driver.switchTo().window(array.get(1));
		String expected_title = "Oath Terms of Service | Oath Policies";
		String actual_title = driver.getTitle();
		System.out.println("Actual terms title " +actual_title);
		Assert.assertEquals( expected_title, actual_title);

		
		// verify Policy links

		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		driver.switchTo().window(window1);
		driver.findElement(By.linkText("Privacy Policy")).click();
		Set<String> set1 = driver.getWindowHandles();
		ArrayList<String> array1 = new ArrayList(set1);
		driver.switchTo().window(array1.get(2));
		String expected_privacytitle = "Welcome to the Oath Privacy Center | Oath Policies";
		String actual_privacytitle = driver.getTitle();
		System.out.println("Actual privacy title " +actual_privacytitle);
		Assert.assertEquals( expected_privacytitle, actual_privacytitle);

	}

}
