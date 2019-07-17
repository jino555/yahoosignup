package com.yahoo.com.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.TestUtil;




public class Signup_test {

	WebDriver  driver;
	
	@BeforeMethod
	  public  void beforeTest() {
		 
		 System.setProperty("webdriver.chrome.driver" ,"E:\\Jino_testing\\Automation_project\\com.yahoo\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 String baseurl = "https://login.yahoo.com/account/create?intl=in&lang=en-IN&src=fpctx&specId=usernameReg&context=reg&done=https%3A%2F%2Fin.yahoo.com";
		 driver.get(baseurl);
		 driver.manage().window().maximize();
		 System.out.println("Chrome Browser Started");
		 
	  
	 }

	  
	 @Test(priority=2,dataProvider ="testdata",description="this test case is to verify signup positive test cases and sucess registration till verification page  ")

	public  void VerifySignup(String name,String lastname, String email, String password, String month,String day,String year,String Gender ) throws Exception

	{
		 Signup_locators signup = new Signup_locators(driver);
		  signup.signup(name,lastname,email,password, month,day,year,Gender );
		 
		}
	
	
	 
	 @Test (priority=1,description ="This test case is to verify signup negative cases")
	 public void Verifynegativetestcases() {
		 
		 
		 Signup_locators neg = new Signup_locators(driver);
		 neg.signup_negtestcase();
	 }
	 
	 
	 
	 
	 
	 @Test (priority=0,description="This test case is to verify terms and privacy links")
	 public void Verifylinks() {
		 
		 Signup_locators links = new Signup_locators(driver);
		 links.linksverify();
	 }
	 
	 
	 
	 
	 
	 
	
	 @DataProvider(name = "testdata")
	 public Object [][] getdata(){
	 	
	 	
	 	Object data [][] = TestUtil.testdata(Constants.path_TestData, Constants.firstsheet_TestData);
	 	
	 	return data;
	 }
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

