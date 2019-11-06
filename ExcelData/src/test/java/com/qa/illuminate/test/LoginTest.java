package com.qa.illuminate.test;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.illluminate.utility.TestUtil;
import com.qa.illuminate.base.Baseclass;
import com.qa.illuminate.page.Loginpage;

public class LoginTest extends Baseclass {
	Loginpage loginpage;
	TestUtil testutil;
	
	public static ITestResult result;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		browserName();
		loginpage = new Loginpage();
		testutil = new TestUtil();
	}

	@DataProvider
	public Object[][] getTestLoginData() {
		Object data[][] = TestUtil.getTestData("login");
		return data;
	}

	@Test(dataProvider = "getTestLoginData")
	public void verifyLogintest(String username, String password) {
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		loginpage.login(username, password);
	}


	@AfterMethod
	public void tearDown() {
	    
		driver.quit();
		}

}
