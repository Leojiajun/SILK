package com.silk.leo.integration;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.silk.leo.Launch.Browsers;
import com.silk.leo.Launch.BrowsersType;
import com.silk.leo.util.Selenium;
import com.silk.leo.util.TestData;
import com.silk.leo.util.TestngRetryListener;

@Listeners({TestngRetryListener.class})
public class BaseTest {
	public WebDriver driver;
	public TestData testdata;
	@BeforeClass
	public void loadDriver(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		testdata = new TestData(System.getProperty("user.dir")+"\\Tools\\testdata.csv");
	}
	@BeforeClass
	public void conect() throws ClassNotFoundException, SQLException{
		Selenium.connection();
	}
	
	/*
	 * 登录平台
	 */
	@Test(alwaysRun = true)
	public void loginSilk() throws SQLException, InterruptedException, WebDriverException, IOException{
		driver.get(testdata.getTestData("uaturl","integration_login"));
		Selenium.inputInDB("loginpage_username", "login", testdata.getTestData("username","integration_login"), driver);
		Selenium.inputInDB("loginpage_password", "login", testdata.getTestData("password","integration_login"), driver);
		Selenium.buttonInDB("loginpage_loginbtn", "login", driver);
		Selenium.waitFor(2000);
//		String testtext = Selenium.findElementInDB("homepage_verify", "login", driver).getText();
//		Assert.assertTrue(testtext.contains("首页"));
//		Selenium.takesScreenshot(driver);
	}
	
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
		System.out.println("浏览器关闭成功");
	}
	
	@AfterClass
	public void closeDB() throws ClassNotFoundException, SQLException{
		Selenium.shutdown();
		System.out.println("数据库关闭成功");
	}
}
