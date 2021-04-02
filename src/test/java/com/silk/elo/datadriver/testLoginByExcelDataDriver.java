package com.silk.elo.datadriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testLoginByExcelDataDriver {
	public WebDriver driver;
	String baseUrl = "http://resuat.thomascookonline.cn/";
	static TestDataDriverByExcelFile tdexcel = new TestDataDriverByExcelFile();
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException{
		return tdexcel.getTestData("D:/workspace/SILK/Tools","testdatadriverbyexcel.xlsx","Sheet1");
	}
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver();
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	@Test(dataProvider = "testData")
	public void testLogin(String username1,String password1,String result){
		driver.get(baseUrl);
		driver.findElement(By.id("userName")).sendKeys(username1);
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("loginBtn")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String aa = (driver.findElement(By.xpath("//a[@class='item user']"))).getText();
		Assert.assertTrue(aa.contains(result));
	}
}
