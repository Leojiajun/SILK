package com.silk.leo.Product;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class hotelInfo extends BaseTest{
	String hotelname = "testHotel"+Selenium.getRandomString(5);
	@Test(priority=1,description = "搜索所有酒店信息")
	public void searchAllHotel() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("hotel", "hotel", driver);
		Selenium.buttonInDB("hotel_hotelinfo", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_hotelinfo_search", "hotel", driver);
		Selenium.waitFor(30000);
		Assert.assertTrue(driver.getPageSource().contains("房型管理"));
	}
	@Test(priority=2,description = "新建酒店")
	public void addHotel() throws SQLException{
		//基本信息
		Selenium.buttonInDB("hotel_hotelinfo_add", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("hotel_add_name",  "hotel", hotelname, driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_add_brand", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_add_brand_choiceone", "hotel", driver);
		Selenium.select("hotel_add_star", "hotel", "五星", driver);
		Selenium.buttonInDB("housetype_add_fkpoi", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("housetype_add_fkpoi",  "hotel", "test酒店1", driver);
		Selenium.findElementInDB("housetype_add_fkpoi", "hotel", driver).sendKeys(Keys.BACK_SPACE);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("housetype_add_fkpoi_chooseone", "hotel", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("hotel_add_basicinfo_save", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("hotel_add_basicinfo_save", "hotel", driver);
		Selenium.waitFor(700);
//		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(2000);
		//酒店介绍
		Selenium.buttonInDB("hotel_add_hotelintroduction", "hotel", driver);
		Selenium.waitFor(3000);
		driver.switchTo().frame("ueditor_0");//切换到富文本
		driver.findElement(By.tagName("body")).sendKeys("这是酒店介绍");//在body中输入内容
		driver.switchTo().defaultContent();//切回来
		Selenium.buttonInDB("hotel_add_hotelintroduction_surebtn", "hotel", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(2000);
		//酒店政策
		Selenium.buttonInDB("hotel_add_hotelpolicy", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_switchpage_surebtn", "hotel", driver);
		Selenium.buttonInDB("hotel_add_hotelpolicy_all", "hotel", driver);
		Selenium.buttonInDB("hotel_add_hotelpolicy_surebtn", "hotel", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//周边设施
		Selenium.buttonInDB("hotel_add_peripheral", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_switchpage_surebtn", "hotel", driver);
		Selenium.inputInDB("hotel_add_peripheral_Restaurant", "hotel", "餐饮", driver);
		Selenium.buttonInDB("hotel_add_peripheral_surebtn", "hotel", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//酒店设施
		Selenium.buttonInDB("hotel_add_hotelfacilities", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_add_hotelfacilities_all", "hotel", driver);
		Selenium.buttonInDB("hotel_add_hotelfacilities_surebtn", "hotel", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//图片信息
		Selenium.buttonInDB("hotel_add_PictureMessage", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_switchpage_surebtn", "hotel", driver);
		Selenium.buttonInDB("hotel_add_PictureMessage_addPicture", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_add_PictureMessage_addPicture_firstpicture", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_add_PictureMessage_addPicture_surebtn", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_add_PictureMessage_surebtn", "hotel", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//回到酒店信息主页
		Selenium.buttonInDB("hotel_hotelinfo", "hotel", driver);
		Selenium.buttonInDB("hotel_hotelinfo_search", "hotel", driver);
		Selenium.waitFor(40000);
		Assert.assertTrue(driver.getPageSource().contains(hotelname));
	}
}
