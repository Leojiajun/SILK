package com.silk.leo.Product;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class hotelResources extends BaseTest{
	String hotelid;
	String houseid;
	@Test(priority=1,description = "获取酒店和房型id")
	public void getId() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("hotel", "hotel", driver);
		Selenium.buttonInDB("hotel_hotelinfo", "hotel", driver);
		Selenium.buttonInDB("hotel_hotelinfo_search", "hotel", driver);
		Selenium.waitFor(10000);
		hotelid=Selenium.findElementInDB("hotel_hotelinfo_firstid", "hotel", driver).getText().replace(" ", "");
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("hotel", "hotel", driver);
		Selenium.buttonInDB("housetype", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("housetype_search", "hotel", driver);
		Selenium.waitFor(10000);
		houseid=Selenium.findElementInDB("housetype_firstid", "hotel", driver).getText().replace(" ", "");
	}
	
	@Test(priority=2,description = "搜索所有酒店资源信息")
	public void searchAllhotelResources() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("hotel", "hotel", driver);
		Selenium.buttonInDB("hotelresources", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_search", "hotel", driver);
		Selenium.waitFor(15000);
		Assert.assertTrue(driver.getPageSource().contains("关联资源"));
	}
	@Test(priority=3,description = "新建酒店资源")
	public void addHotelResources() throws SQLException{
		Selenium.buttonInDB("hotelresources_add", "hotel", driver);
		Selenium.waitFor(3000);
		Assert.assertTrue(driver.getPageSource().contains("售卖信息"));
		Selenium.inputInDB("hotelresources_add_resourcesname", "hotel", "resources"+Selenium.getRandomString(5), driver);
		Selenium.inputInDB("hotelresources_add_hotelid", "hotel", hotelid, driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_hotelid_choice", "hotel", driver);
		Selenium.inputInDB("hotelresources_add_houseid", "hotel", houseid, driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_houseid_choice", "hotel", driver);
		Selenium.buttonInDB("hotelresources_add_compact", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_compact_choice", "hotel", driver);
		Selenium.buttonInDB("hotelresources_add_manage", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_manage_choice", "hotel", driver);
		Selenium.select("hotelresources_add_resourcesattribute", "hotel", "自签", driver);
		Selenium.buttonInDB("hotelresources_add_saleyes", "hotel", driver);
		//售卖信息
		Selenium.buttonInDB("hotelresources_add_salestartdata", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("hotelresources_add_salestartdata", "hotel", "2018-11-01", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_saleenddata", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("hotelresources_add_saleenddata", "hotel", "2018-12-31", driver);
		Selenium.waitFor(2000);
		Selenium.select("hotelresources_add_saleCurrency", "hotel", "RMB", driver);
		Selenium.select("hotelresources_add_baseCurrency", "hotel", "RMB", driver);
		Selenium.waitFor(2000);
		//保存
		Selenium.buttonInDB("hotelresources_add_info_savebtn", "hotel", driver);
		Selenium.waitFor(5000);
		Selenium.buttonInDB("hotelresources_add_info_savebtn", "hotel", driver);
		Selenium.waitFor(500);
     	Assert.assertTrue(driver.getPageSource().contains("操作成功"));
     	Selenium.waitFor(3000);
		//切换到退改政策
		Selenium.buttonInDB("hotelresources_add_Refundpolicy", "hotel", driver);
		Selenium.waitFor(3000);
		//切换到价格库存
		Selenium.buttonInDB("hotelresources_add_repertory", "hotel", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation_startdata", "hotel", driver);
		Selenium.inputInDB("hotelresources_add_repertory_bulkoperation_startdata", "hotel", "2018-11-01", driver);
//		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation_startdata_choice", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation_enddata", "hotel", driver);
		Selenium.inputInDB("hotelresources_add_repertory_bulkoperation_enddata", "hotel", "2020-12-31", driver);
//		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation_enddata_choice", "hotel", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("hotelresources_add_repertory_bulkoperation_add", "hotel", "50", driver);
		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation_addbtn", "hotel", driver);
		Selenium.inputInDB("hotelresources_add_repertory_bulkoperation_baseAdult", "hotel", "1000", driver);
		Selenium.inputInDB("hotelresources_add_repertory_bulkoperation_saleAdult", "hotel", "2000", driver);
		Selenium.select("hotelresources_add_repertory_bulkoperation_hasBreakfast", "hotel", "无早", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("hotelresources_add_repertory_bulkoperation_savebtn", "hotel", driver);
		Selenium.waitFor(10000);
		Assert.assertTrue(driver.getPageSource().contains("库存"));
		
		
	}
}
