package com.silk.leo.Product;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.video.stbio.Key;
import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class houseType extends BaseTest{
	@Test(priority=1,description = "搜索所有房型")
	public void searchAllHousetype() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("hotel", "hotel", driver);
		Selenium.buttonInDB("housetype", "hotel", driver);
		Selenium.buttonInDB("housetype_search", "hotel", driver);
		Selenium.waitFor(15000);
		Assert.assertTrue(driver.getPageSource().contains("资源信息"));
	}
	
	@Test(priority=2,description = "新建房型")
	public void addHouseType() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("hotel", "hotel", driver);
		Selenium.buttonInDB("hotel_hotelinfo", "hotel", driver);
		Selenium.buttonInDB("hotel_hotelinfo_search", "hotel", driver);
		Selenium.waitFor(10000);
		String hotelid = Selenium.findElementInDB("hotel_hotelinfo_firstid", "hotel", driver).getText().replace(" ", "");
		Selenium.buttonInDB("housetype", "hotel", driver);
		Selenium.buttonInDB("housetype_add", "hotel", driver);
		Selenium.inputInDB("housetype_add_housename", "hotel", "house"+Selenium.getRandomString(5), driver);
		Selenium.inputInDB("housetype_add_hotelID", "hotel", hotelid, driver);
		Selenium.waitFor(1000);       
		Selenium.buttonInDB("housetype_add_choiceonehotel", "hotel", driver);
		Selenium.inputInDB("housetype_add_maxcheckinpeople", "hotel", "2", driver);
		Selenium.buttonInDB("housetype_add_HotelBedType", "hotel", driver);
		Selenium.buttonInDB("housetype_add_HotelBedType", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("housetype_add_choiceBedType", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("housetype_add_bedtypelist", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("housetype_add_bedtypelist_bigbed", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("housetype_add_bedtypelist_doublebed", "hotel", driver);
		Selenium.buttonInDB("housetype_add_info_savebtn", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("housetype_add_info_savebtn", "hotel", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(2000);
		Selenium.buttonInDB("housetype_add_pictureinfo", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotel_switchpage_surebtn", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("housetype_add_pictureinfo_add", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("housetype_add_pictureinfo_add_firstpicture", "hotel", driver);
		Selenium.buttonInDB("housetype_add_pictureinfo_add_surebtn", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("housetype_add_pictureinfo_surebtn", "hotel", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		
	}
}
