package com.silk.leo.Product;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.video.stbio.Key;
import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class productList extends BaseTest{
	String productid="1000000084";
	/**
	 * 搜索全部产品
	 * @throws SQLException
	 */
	
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
		Selenium.select("product_add_bussinessType", "product", "主题亲子", driver);
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
		//行程描述
		Selenium.buttonInDB("modifyproduct_Tripdescription", "product", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("modifyproduct_Tripdescription_switch_surebtn", "product", driver);
		Selenium.waitFor(5000);
		Selenium.select("productlist_add_Tripdescription_TrafficDeparture", "product", "飞机", driver);
		Selenium.select("productlist_add_Tripdescription_TrafficArrival", "product", "飞机", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("productlist_add_Tripdescription_firstdaytitle", "product", "第一天行程标题", driver);
		Selenium.inputInDB("productlist_add_Tripdescription_seconddaytitle", "product", "第二天行程标题", driver);
		Selenium.inputInDB("productlist_add_Tripdescription_thirddaytitle", "product", "第三天行程标题", driver);
		Selenium.buttonInDB("productlist_add_Tripdescription_savebtn", "product", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(5000);
		//描述信息
		Selenium.buttonInDB("modifyproduct_descriptor", "product", driver);
		Selenium.waitFor(3000);
		driver.switchTo().frame("ueditor_0");
		Selenium.waitFor(2000);
		driver.findElement(By.tagName("body")).sendKeys("产品介绍");
		Selenium.waitFor(2000);
		driver.switchTo().defaultContent();//切回来
		Selenium.waitFor(2000);
/**		if(Selenium.findElementInDB("product_add_descriptor_surebtn", "product", driver).isDisplayed()==true){
			System.out.println("可见");
		}else{
			System.out.println("不可见");
		};
		if(Selenium.findElementInDB("product_add_descriptor_surebtn", "product", driver).isEnabled()==true){
			System.out.println("可点击");
		}else{
			System.out.println("不可点击");
		};**/
//      使用js强制点击保存按钮，因为jenkins执行的时候，保存按钮被覆盖，使用click点不到
		WebElement ele = Selenium.findElementInDB("product_add_descriptor_surebtn", "product", driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
//		Selenium.buttonInDB("product_add_descriptor_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//预订控制
		Selenium.buttonInDB("modifyproduct_budgetarycontrol", "product", driver);
		Selenium.waitFor(1000);
		Selenium.inputInDB("productlist_add_budgetarycontrol_advanceDays", "product", "0", driver);
		Selenium.inputInDB("productlist_add_budgetarycontrol_advanceTime", "product", "0000", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("productlist_add_budgetarycontrol_yes", "product", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("product_add_budgetarycontrol_surebtn", "product", driver);
		Selenium.waitFor(3000);
		
//		Selenium.waitFor(1000);
//		Selenium.buttonInDB("modifyproduct_budgetarycontrol", "product", driver);
//		Selenium.waitFor(2000);
//		Selenium.inputInDB("productlist_add_budgetarycontrol_advanceDays", "product", "0", driver);
//		Selenium.waitFor(1000);
//		Selenium.inputInDB("productlist_add_budgetarycontrol_advanceTime", "product", "0000", driver);
//		Selenium.findElementInDB("productlist_add_budgetarycontrol_advanceTime", "product", driver).sendKeys(Keys.ENTER);
//		Selenium.waitFor(2000);
//		Selenium.buttonInDB("productlist_add_budgetarycontrol_yes", "product", driver);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); //下拉到页面底部
//		Selenium.waitFor(3000);
//		Selenium.buttonInDB("product_add_budgetarycontrol_surebtn", "product", driver);
//		Selenium.waitFor(2000);
//		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//预定须知
		Selenium.buttonInDB("modifyproduct_Bookinginformation", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_sure_switchtoBookinginformation", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_Bookinginformation_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		//关联资源
		Selenium.buttonInDB("modifyproduct_Associatedresources", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_Associatedresources_new", "product", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("product_add_Associatedresources_add_days", "product", "3", driver);
		Selenium.inputInDB("product_add_Associatedresources_add_fromcity", "product", "shangh", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("product_add_Associatedresources_add_fromcity", "product", driver).sendKeys(Keys.ENTER);
		Selenium.waitFor(2000);
//		Selenium.buttonInDB("product_add_Associatedresources_add_fromcity_choiceshanghai", "product", driver);
		Selenium.inputInDB("product_add_Associatedresources_add_tocity", "product", "beijin", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("product_add_Associatedresources_add_tocity", "product", driver).sendKeys(Keys.ENTER);
//		Selenium.buttonInDB("product_add_Associatedresources_add_tocity_choicebeijin", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_Associatedresources_add_savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		//资源操作
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation", "product", driver);
		Selenium.waitFor(15000);
		Selenium.inputInDB("product_add_Associatedresources_add_Resourceoperation__ResourceID", "product", "1000000126", driver);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__search", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__choice", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__yes", "product", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("product_add_Associatedresources_add_Resourceoperation__usetime", "product", "3", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//退改政策
		Selenium.buttonInDB("modifyproduct_Refund policy", "product", driver);
		Selenium.waitFor(10000);
		Selenium.buttonInDB("product_add_Refundpolicy_new", "product", driver);
		Selenium.waitFor(6000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add1", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add1_canback", "product", driver);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add1_save", "product", driver);
		Selenium.waitFor(6000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add2", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add2_canback", "product", driver);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add2_save", "product", driver);
		Selenium.waitFor(6000);
		//价格库存
		Selenium.buttonInDB("modifyproduct_ priceofinventory", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule", "product", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("product_add_ priceofinventory_setrule_enddate", "product", "2021-05-30", driver);
//		Selenium.inputInDB("product_add_ priceofinventory_setrule_suggestPriceMarkup", "product", "10", driver);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_suggestPriceFlag", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_refreshSalePriceType", "product", driver);
		Selenium.select("product_add_ priceofinventory_setrule_selectpriceVal", "product", "固定金额", driver);
		Selenium.inputInDB("product_add_ priceofinventory_setrule_priceVal", "product", "200", driver);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_save", "product", driver);
		Selenium.waitFor(10000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_update", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_update_sure", "product", driver);
		Selenium.waitFor(2000);
		
		//优惠活动
		Selenium.buttonInDB("modifyproduct_ promotion", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_promotion_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//渠道设置
		Selenium.buttonInDB("modifyproduct_ channelset", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ channelset_changepagesure", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ channelset_selectall", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_channelset_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		//图片信息
		Selenium.buttonInDB("modifyproduct_ pictureinfo", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_ pictureinfo_add", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ pictureinfo_add_choicefirst", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ pictureinfo_add_savebtn", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ pictureinfo_savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		//内部预定须知
		Selenium.buttonInDB("product_add_ bookinginformation", "product", driver);
		Selenium.waitFor(3000);
		Selenium.accessFrame("ueditor_2", driver);
		Selenium.waitFor(3000);
		driver.findElement(By.tagName("body")).sendKeys("内部预定须知");
		driver.switchTo().defaultContent();//切回来
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ bookinginformation_save", "product", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		
	}
	
	@Test(priority=3,description = "新建跟团游产品")
	public void addPackageTour() throws SQLException{
		Selenium.buttonInDB("productlistbtn", "product", driver);
		Selenium.buttonInDB("productlist_add", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("productlist_add_packagetour", "product", driver);
		Selenium.waitFor(2000);
		//基本信息
		Selenium.inputInDB("productlist_add_subhead", "product", "myPackageTest"+Selenium.getRandomString(5), driver);
		Selenium.buttonInDB("productlist_add_packagetour_startfrom", "product", driver);
		Selenium.buttonInDB("productlist_add_china", "product", driver);
		Selenium.inputInDB("productlist_add_fromcity", "product", "shangh", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("productlist_add_fromcitychoice", "product", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("productlist_add_tocity", "product", "beijin", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("productlist_add_tocitychoice", "product", driver);
		Selenium.inputInDB("productlist_add_manager", "product", "00T008", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("productlist_add_manager", "product", driver).sendKeys(Keys.ENTER);
//		Selenium.buttonInDB("productlist_add_manager_choiceone", "product", driver);
		Selenium.inputInDB("productlist_add_tripDays", "product", "3", driver);
		Selenium.inputInDB("productlist_add_tripNights", "product", "2", driver);
		Selenium.select("product_add_bussinessType", "product", "主题亲子", driver);
		Selenium.inputInDB("productlist_add_startdata", "product", "2018-11-01", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("productlist_add_enddata", "product", "2021-11-01", driver);
		Selenium.waitFor(2000);
		Selenium.select("productlist_add_salecurrency", "product", "RMB", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("product_add_ minsaleprice", "product", "20", driver);
		Selenium.waitFor(4000);
		Selenium.buttonInDB("productlist_add_basicinfo_savebtn", "product", driver);
		Selenium.waitFor(5000);
		Selenium.buttonInDB("productlist_add_basicinfo_savebtn", "product", driver);
		Selenium.waitFor(2000);
//		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//行程描述
		Selenium.buttonInDB("modifyproduct_Tripdescription", "product", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("modifyproduct_Tripdescription_switch_surebtn", "product", driver);
		Selenium.waitFor(5000);
		Selenium.select("productlist_add_Tripdescription_TrafficDeparture", "product", "飞机", driver);
		Selenium.select("productlist_add_Tripdescription_TrafficArrival", "product", "飞机", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("productlist_add_Tripdescription_firstdaytitle", "product", "第一天行程标题", driver);
		Selenium.inputInDB("productlist_add_Tripdescription_seconddaytitle", "product", "第二天行程标题", driver);
		Selenium.inputInDB("productlist_add_Tripdescription_thirddaytitle", "product", "第三天行程标题", driver);
		Selenium.buttonInDB("productlist_add_Tripdescription_savebtn", "product", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(5000);
		//描述信息
		Selenium.buttonInDB("modifyproduct_descriptor", "product", driver);
		Selenium.waitFor(3000);
		driver.switchTo().frame("ueditor_0");
		Selenium.waitFor(2000);
		driver.findElement(By.tagName("body")).sendKeys("产品介绍");
		Selenium.waitFor(2000);
		driver.switchTo().defaultContent();//切回来
		Selenium.waitFor(2000);
		
//      使用js强制点击保存按钮，因为jenkins执行的时候，保存按钮被覆盖，使用click点不到
		WebElement ele = Selenium.findElementInDB("product_add_descriptor_surebtn", "product", driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
//		Selenium.buttonInDB("product_add_descriptor_surebtn", "product", driver);
		
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//预订控制
		Selenium.buttonInDB("modifyproduct_budgetarycontrol", "product", driver);
		Selenium.waitFor(1000);
		Selenium.inputInDB("productlist_add_budgetarycontrol_advanceDays", "product", "0", driver);
		Selenium.inputInDB("productlist_add_budgetarycontrol_advanceTime", "product", "0000", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("productlist_add_budgetarycontrol_yes", "product", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("product_add_budgetarycontrol_surebtn", "product", driver);
		Selenium.waitFor(1000);
//		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//预定须知
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_Bookinginformation", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_sure_switchtoBookinginformation", "product", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("productlist_add_packagetour_Bookinginformation_notreamresion", "product", "不成团说明", driver);
		Selenium.buttonInDB("modifyproduct_Bookinginformation_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//关联资源
		Selenium.buttonInDB("modifyproduct_Associatedresources", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_Associatedresources_new", "product", driver);
		Selenium.inputInDB("product_add_Associatedresources_add_days", "product", "3", driver);
		Selenium.inputInDB("product_add_Associatedresources_add_fromcity", "product", "shanghai", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("product_add_Associatedresources_add_fromcity", "product", driver).sendKeys(Keys.ENTER);
//		Selenium.buttonInDB("product_add_Associatedresources_add_fromcity_choiceshanghai", "product", driver);
		Selenium.inputInDB("product_add_Associatedresources_add_tocity", "product", "beijin", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("product_add_Associatedresources_add_tocity", "product", driver).sendKeys(Keys.ENTER);
//		Selenium.buttonInDB("product_add_Associatedresources_add_tocity_choicebeijin", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_Associatedresources_add_savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		//资源操作
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation", "product", driver);
		Selenium.waitFor(15000);
		Selenium.inputInDB("product_add_Associatedresources_add_Resourceoperation__ResourceID", "product", "1000000126", driver);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__search", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__choice", "product", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__yes", "product", driver);
		Selenium.waitFor(1000);
		Selenium.inputInDB("product_add_Associatedresources_add_Resourceoperation__usetime", "product", "3", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("product_add_Associatedresources_add_Resourceoperation__savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//退改政策
		Selenium.buttonInDB("modifyproduct_Refund policy", "product", driver);
		Selenium.waitFor(10000);
		Selenium.buttonInDB("product_add_Refundpolicy_new", "product", driver);
		Selenium.waitFor(6000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add1", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add1_canback", "product", driver);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add1_save", "product", driver);
		Selenium.waitFor(6000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add2", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add2_canback", "product", driver);
		Selenium.buttonInDB("product_add_Refundpolicy_new_add2_save", "product", driver);
		Selenium.waitFor(6000);
		//价格库存
		Selenium.buttonInDB("modifyproduct_ priceofinventory", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule", "product", driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("product_add_ priceofinventory_setrule_enddate", "product", "2021-05-30", driver);
//		Selenium.inputInDB("product_add_ priceofinventory_setrule_suggestPriceMarkup", "product", "10", driver);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_suggestPriceFlag", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_refreshSalePriceType", "product", driver);
		Selenium.select("product_add_ priceofinventory_setrule_selectpriceVal", "product", "固定金额", driver);
		Selenium.inputInDB("product_add_ priceofinventory_setrule_priceVal", "product", "200", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_save", "product", driver);
		Selenium.waitFor(10000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_update", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ priceofinventory_setrule_update_sure", "product", driver);
		Selenium.waitFor(2000);
		//优惠活动
		Selenium.buttonInDB("modifyproduct_ promotion", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_promotion_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//渠道设置
		Selenium.buttonInDB("modifyproduct_ channelset", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ channelset_changepagesure", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ channelset_selectall", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_channelset_surebtn", "product", driver);
		Selenium.waitFor(3000);
		//图片信息
		Selenium.buttonInDB("modifyproduct_ pictureinfo", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("product_add_ pictureinfo_add", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ pictureinfo_add_choicefirst", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ pictureinfo_add_savebtn", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ pictureinfo_savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//内部预定须知
		Selenium.buttonInDB("product_add_ bookinginformation", "product", driver);
		Selenium.waitFor(3000);
		Selenium.accessFrame("ueditor_2", driver);
		Selenium.waitFor(3000);
		driver.findElement(By.tagName("body")).sendKeys("内部预定须知");
		driver.switchTo().defaultContent();//切回来
		Selenium.waitFor(2000);
		Selenium.buttonInDB("product_add_ bookinginformation_save", "product", driver);
		Selenium.waitFor(500);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		
	}
	
	/**
	 * 按产品id搜索
	 * @throws SQLException
	 */
	//@Test(priority=4,description = "按产品id查询")
	public void searchProductByproID() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("packagebtn", "product", driver);
		Selenium.buttonInDB("productlistbtn", "product", driver);
		Selenium.waitFor(3000);
		Selenium.inputInDB("productlist_searchbox_productId", "product", productid, driver);
		Selenium.buttonInDB("productlist_searchbox_searchbtn", "product", driver);
		Selenium.waitFor(5000);
		String testsearchsuccess2 = Selenium.findElementInDB("productlist_list_productid", "product", driver).getText().replace(" ","");
		Assert.assertTrue(testsearchsuccess2.contains(productid));	
	}
	
	//@Test(priority=5,description = "产品修改")
	public void modifyProduct() throws SQLException{
		String subTitle=Selenium.getToday();//产品副标题
		Selenium.buttonInDB("productlist_list_modify", "product", driver);
		Selenium.waitFor(5000);
		String testmodifyprosuccess = Selenium.findElementInDB("modifyproduct_productid", "product", driver).getText().replace(" ","");
		Assert.assertTrue(testmodifyprosuccess.contains(productid));
		Selenium.inputInDB("modifyproduct_subhead", "product", subTitle, driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("modifyproduct_basicinformation_savebtn", "product", driver);
		Selenium.waitFor(6000);
		Selenium.buttonInDB("modifyproduct_basicinformation_savebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到行程描述页面
		Selenium.buttonInDB("modifyproduct_Tripdescription", "product", driver);
		Selenium.buttonInDB("modifyproduct_Tripdescription_switch_surebtn", "product", driver);
		Selenium.waitFor(5000);
		Selenium.buttonInDB("modifyproduct_Tripdescription_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到描述信息页面
		Selenium.buttonInDB("modifyproduct_descriptor", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_descriptor_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到预定控制页面
		Selenium.buttonInDB("modifyproduct_budgetarycontrol", "product", driver);
		Selenium.waitFor(1000);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_budgetarycontrol_surebtn", "product", driver);
//		Selenium.waitFor(500);
//		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到预定须知页面
		Selenium.buttonInDB("modifyproduct_Bookinginformation", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_sure_switchtoBookinginformation", "product", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("modifyproduct_Bookinginformation_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到关联资源页面
		Selenium.buttonInDB("modifyproduct_Associatedresources", "product", driver);
		Selenium.waitFor(3000);
		Assert.assertEquals(Selenium.findElementInDB("modifyproduct_Associatedresources_new", "product", driver).isDisplayed(), true);
		//切换到退改政策
		Selenium.buttonInDB("modifyproduct_Refund policy", "product", driver);
		Selenium.waitFor(3000);
		Assert.assertTrue(driver.getPageSource().contains("直接使用资源的退改政策"));
		//切换到价格库存界面
		Selenium.buttonInDB("modifyproduct_ priceofinventory", "product", driver);
		Selenium.waitFor(3000);
		Assert.assertTrue(driver.getPageSource().contains("批量修改"));
		//切换到优惠活动界面
		Selenium.buttonInDB("modifyproduct_ promotion", "product", driver);
		Selenium.buttonInDB("modifyproduct_ promotion_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到渠道设置
		Selenium.buttonInDB("modifyproduct_ channelset", "product", driver);
		String test = Selenium.findElementInDB("modifyproduct_ channelset_inside", "product", driver).getText().replace(" ", "");
		Assert.assertTrue(test.contains("内部渠道"));
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//页面下拉到底部
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_ channelset_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		//切换到图片信息
		Selenium.buttonInDB("modifyproduct_ pictureinfo", "product", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_ pictureinfo_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_submit", "product", driver);
		Selenium.buttonInDB("modifyproduct_submit_surebtn", "product", driver);
		Selenium.waitFor(1000);
		Assert.assertTrue(driver.getPageSource().contains("操作成功"));
		Selenium.waitFor(3000);
		Selenium.buttonInDB("modifyproduct_publish", "product", driver);
		Selenium.buttonInDB("modifyproduct_publish_surebtn", "product", driver);
		Selenium.waitFor(3000);
		Assert.assertTrue((Selenium.findElementInDB("modifyproduct_publish", "product", driver).getText()).contains("下线"));
		
	}
}
