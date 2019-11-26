package com.silk.leo.Product;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class DMC extends BaseTest{
	@Test(priority=1,description = "搜索所有地接信息")
	public void searchDMC() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("DMC", "DMC", driver);
		Selenium.buttonInDB("DMCrsources", "DMC", driver);
		Selenium.buttonInDB("DMCrsources_search", "DMC", driver);
		Selenium.waitFor(10000);
		Assert.assertTrue(driver.getPageSource().contains("停售"));
	}
	
	@Test(priority=2,description = "新建地接资源")
	public void addDMC() throws SQLException{
		Selenium.buttonInDB("DMCrsources_add", "DMC", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("DMCrsources_add_resourcesname", "DMC", "TestDMC"+Selenium.getRandomString(5), driver);
		Selenium.inputInDB("DMCrsources_add_city", "DMC", "shangh", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("DMCrsources_add_city_choice", "DMC", driver);
		Selenium.waitFor(1000);
		Selenium.inputInDB("DMCrsources_add_contract", "DMC", "Vidotour", driver);
		Selenium.buttonInDB("DMCrsources_add_contract_choice", "DMC", driver);
		Selenium.inputInDB("DMCrsources_add_manager", "DMC", "00T008", driver);
		Selenium.buttonInDB("DMCrsources_add_manager_choice", "DMC", driver);
		Selenium.select("DMCrsources_add_property ", "DMC", "自签", driver);
		Selenium.buttonInDB("DMCrsources_add_cansell", "DMC", driver);
		Selenium.removeAttribute(driver, Selenium.findElementInDB("DMCrsources_add_saleStartDate", "DMC", driver), "readonly");//清除readonly属性
		Selenium.inputInDB("DMCrsources_add_saleStartDate", "DMC", Selenium.getTodayYYMMDD(), driver);
		Selenium.removeAttribute(driver, Selenium.findElementInDB("DMCrsources_add_saleEndDate", "DMC", driver), "readonly");//清除readonly属性
		Selenium.inputInDB("DMCrsources_add_saleEndDate", "DMC", "2021-12-01", driver);
//		Selenium.buttonInDB("DMCrsources_add_cansell", "DMC", driver);
		Selenium.waitFor(2000);
		Selenium.select("DMCrsources_add_saleCurrency", "DMC","RMB", driver);
		Selenium.waitFor(2000);
		Selenium.select("DMCrsources_add_baseCurrency", "DMC","RMB", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("DMCrsources_add_savebtn", "DMC", driver);
		Selenium.waitFor(5000);
		Selenium.buttonInDB("DMCrsources_add_savebtn2", "DMC", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//地接内容
		Selenium.buttonInDB("DMCrsources_add_DMCcontent", "DMC", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("DMCrsources_add_DMCcontent_savebtn", "DMC", driver);
		Selenium.waitFor(5000);
//		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//退改政策
		Selenium.buttonInDB("DMCrsources_add_Refundpolicy", "DMC", driver);
		Selenium.waitFor(2000);
//		Selenium.buttonInDB("DMCrsources_add_switchRefundpolicysurebtn", "DMC", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("DMCrsources_add_add1", "DMC", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("DMCrsources_add_add1_tdno", "DMC", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("DMCrsources_add_add1_savebtn", "DMC", driver);
		Selenium.waitFor(6000);
		Selenium.buttonInDB("DMCrsources_add_add2", "DMC", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("DMCrsources_add_add2_tdno", "DMC", driver);
		Selenium.buttonInDB("DMCrsources_add_add2_savebtn", "DMC", driver);
		Selenium.waitFor(6000);
		//价格库存
		Selenium.buttonInDB("DMCrsources_add_priceinventory", "DMC", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("DMCrsources_add_priceinventory_batchoperation", "DMC", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_startdate", "DMC", "2018-11-01", driver);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_enddate", "DMC", "2021-12-01", driver);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_addrepertory", "DMC", "50", driver);
		Selenium.buttonInDB("DMCrsources_add_priceinventory_batchoperation_addrepertorybtn", "DMC", driver);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_baseAdult", "DMC", "100", driver);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_saleAdult", "DMC", "200", driver);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_baseChild", "DMC", "50", driver);
		Selenium.inputInDB("DMCrsources_add_priceinventory_batchoperation_saleChild", "DMC", "50", driver);
		Selenium.buttonInDB("DMCrsources_add_priceinventory_batchoperation_savebtn", "DMC", driver);
		Selenium.waitFor(8000);
		Assert.assertTrue(driver.getPageSource().contains("库存"));
	}
		
}
