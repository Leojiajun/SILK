package com.silk.leo.Product;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class playResources extends BaseTest{
	@Test(priority=1,description = "搜索全部玩乐资源")
	public void searchPlayResources() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("play", "play", driver);
		Selenium.buttonInDB("play_playresources", "play", driver);
		Selenium.buttonInDB("play_playresources_search", "play", driver);
		Selenium.waitFor(6000);
		Assert.assertTrue(driver.getPageSource().contains("停售"));	
	}
	@Test(priority=2,description = "新建玩乐资源")
	public void addPlayResources() throws SQLException{
		//基础信息
		Selenium.buttonInDB("play_playresources_add", "play", driver);
		Selenium.inputInDB("play_playresources_add_resourcename", "play", "testplay"+Selenium.getRandomString(5), driver);
		Selenium.inputInDB("play_playresources_add_city", "play", "guangzh", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("play_playresources_add_city", "play", driver).sendKeys(Keys.ENTER);
//		Selenium.inputInDB("play_playresources_add_city_choiceone", "play", "guangzh", driver);
		Selenium.inputInDB("play_playresources_add_Contract", "play", "Be", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("play_playresources_add_Contract", "play", driver).sendKeys(Keys.ENTER);
		Selenium.inputInDB("play_playresources_add_manager", "play", "00T008", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("play_playresources_add_manager", "play", driver).sendKeys(Keys.ENTER);
		Selenium.select("play_playresources_add_resourceAttribute", "play", "自签", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("play_playresources_add_cansell", "play", driver);
		Selenium.waitFor(2000);
		Selenium.removeAttribute(driver,Selenium.findElementInDB("play_playresources_add_saleStartDate", "play", driver), "readonly");
		Selenium.inputInDB("play_playresources_add_saleStartDate", "play", Selenium.getTodayYYMMDD(), driver);
		Selenium.waitFor(2000);
		Selenium.removeAttribute(driver,Selenium.findElementInDB("play_playresources_add_saleEndDate", "play", driver), "readonly");
		Selenium.inputInDB("play_playresources_add_saleEndDate", "play","2019-12-31", driver);
		Selenium.waitFor(2000);
		Selenium.select("play_playresources_add_saleCurrency", "play", "RMB", driver);
		Selenium.select("play_playresources_add_baseCurrency", "play", "RMB", driver);
		Selenium.buttonInDB("play_playresources_add_savebtn", "play", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		//退改政策
		Selenium.buttonInDB("play_playresources_add_Refundpolicy", "play", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("play_playresources_add_Refundpolicy_add1", "play", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("play_playresources_add_Refundpolicy_add1_save", "play", driver);
		Selenium.waitFor(3000);
		//Selenium.buttonInDB("play_playresources_add_Refundpolicy_add2", "play", driver);
		Selenium.mouseClickInDB("play_playresources_add_Refundpolicy_add2", "play", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("play_playresources_add_Refundpolicy_add2_save", "play", driver);
		Selenium.waitFor(3000);
		//价格库存
		Selenium.buttonInDB("play_playresources_add_priceofinventory", "play", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("play_playresources_add_priceofinventory_batch", "play", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("play_playresources_add_priceofinventory_batch_startdate", "play", Selenium.getTodayYYMMDD(), driver);
		Selenium.inputInDB("play_playresources_add_priceofinventory_batch_enddate", "play", "2019-12-31", driver);
		Selenium.inputInDB("play_playresources_add_priceofinventory_batch_Addinventoryinput", "play", "50", driver);
		Selenium.buttonInDB("play_playresources_add_priceofinventory_batch_Addinventorybtn", "play", driver);
		Selenium.inputInDB("play_playresources_add_priceofinventory_batch_baseAdult", "play", "100", driver);
		Selenium.inputInDB("play_playresources_add_priceofinventory_batch_saleAdult", "play", "200", driver);
		Selenium.buttonInDB("play_playresources_add_priceofinventory_batch_save", "play", driver);
		Selenium.waitFor(8000);
		Assert.assertTrue(driver.getPageSource().contains("库存"));
		//预定控制信息
		Selenium.buttonInDB("play_playresources_add_budgetary", "play", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("play_playresources_add_budgetary_save", "play", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//预定人员控制
		Selenium.buttonInDB("play_playresources_add_personnelcontrol", "play", driver);
		Selenium.buttonInDB("play_playresources_add_personnelcontrol_add", "play", driver);
		Selenium.select("play_playresources_add_personnelcontrol_add_name", "play", "Gender", driver);
		Selenium.inputInDB("play_playresources_add_personnelcontrol_add_description", "play", "test", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("play_playresources_add_personnelcontrol_add_save", "play", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//预定时间控制
		Selenium.buttonInDB("play_playresources_add_time", "play", driver);
		Selenium.buttonInDB("play_playresources_add_time_add", "play", driver);
		Selenium.inputInDB("play_playresources_add_time_add_starttime", "play", "08:00", driver);
		Selenium.waitFor(1000);
		Selenium.inputInDB("play_playresources_add_time_add_endtime", "play", "20:00", driver);
		Selenium.inputInDB("play_playresources_add_time_add_mappingid", "play", "test"+Selenium.getRandomString(5), driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("play_playresources_add_time_add_save", "play", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
	}
	
}
