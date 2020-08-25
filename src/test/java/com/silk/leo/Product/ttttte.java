package com.silk.leo.Product;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class ttttte extends BaseTest{
	@Test(priority=1,description = "搜索所有产品信息")
	public void searchProduct() throws SQLException{
		Selenium.waitFor(3000);
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("packagebtn", "product", driver);
		Selenium.buttonInDB("productlistbtn", "product", driver);
		//Selenium.buttonInDB("productlist_searchbox_searchbtn", "product", driver);
		//Selenium.waitFor(15000);
		//验证搜索结果
		//String testsearchsuccess = Selenium.findElementInDB("productlist_list_numberbtn", "product", driver).getText().replace(" ","");
		//Assert.assertTrue(testsearchsuccess.contains("1"));	
	}
	
	@Test(priority=2,description = "新建自由行产品")
	public void addProduct_freewalker() throws SQLException{
		Selenium.buttonInDB("productlist_add", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("productlist_add_freewalker", "product", driver);
		Selenium.waitFor(2000);
		//基本信息
		Selenium.inputInDB("productlist_add_subhead", "product", "myTest"+Selenium.getRandomString(5), driver);
		Selenium.buttonInDB("productlist_add_china", "product", driver);
		Selenium.inputInDB("productlist_add_fromcity", "product", "shanghai", driver);
		Selenium.waitFor(3000);
		Selenium.findElementInDB("productlist_add_fromcity", "product",  driver).sendKeys(Keys.ENTER);
		Selenium.waitFor(2000);
		Selenium.inputInDB("productlist_add_tocity", "product", "beijin", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("productlist_add_tocity", "product",  driver).sendKeys(Keys.ENTER);
		Selenium.inputInDB("productlist_add_manager", "product", "00T008", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("productlist_add_manager", "product",  driver).sendKeys(Keys.ENTER);
		Selenium.inputInDB("productlist_add_tripDays", "product", "3", driver);
		Selenium.inputInDB("productlist_add_tripNights", "product", "2", driver);
		Selenium.inputInDB("productlist_add_startdata", "product", "2018-11-01", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("productlist_add_enddata", "product", "2021-11-01", driver);
		Selenium.waitFor(2000);
		Selenium.select("productlist_add_salecurrency", "product", "RMB", driver);
		Selenium.inputInDB("product_add_ minsaleprice", "product", "20", driver);
		Selenium.buttonInDB("productlist_add_basicinfo_savebtn", "product", driver);
		Selenium.waitFor(5000);
		Selenium.buttonInDB("productlist_add_basicinfo_savebtn", "product", driver);
		Selenium.waitFor(3000);
		
		//内部预定须知
				Selenium.buttonInDB("product_add_ bookinginformation", "product", driver);
				Selenium.waitFor(1000);
				Selenium.buttonInDB("modifyproduct_Tripdescription_switch_surebtn", "product", driver);
				Selenium.waitFor(3000);
				System.out.println("*****************1111111111111111*********************************");
//				driver.switchTo().frame("ueditor_0");
				Selenium.accessFrame("ueditor_0", driver);
//				driver.switchTo().frame(driver.findElement(By.xpath("//body[@class='view']")));
				System.out.println("*****************22222222222222222222*********************************");
				Selenium.waitFor(3000);
				driver.findElement(By.tagName("body")).sendKeys("内部预定须知");
				System.out.println("*****************33333333333333333333333333*********************************");
				driver.switchTo().defaultContent();//切回来
				System.out.println("*****************44444444444444444444444444444*********************************");
				Selenium.waitFor(2000);
				Selenium.buttonInDB("product_add_ bookinginformation_save", "product", driver);
				
		
}
}