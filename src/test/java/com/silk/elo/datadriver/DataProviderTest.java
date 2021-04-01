package com.silk.elo.datadriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.silk.leo.Launch.Browsers;
import com.silk.leo.Launch.BrowsersType;


public class DataProviderTest  {
	static WebDriver driver;
	@BeforeClass
	public void loadDriver(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		
	}	
	
	@DataProvider(name = "searchWords")
	
	public static Object[][] words(){
		
		return new Object[][]{
			{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}
		};
	}
	
	@Test(dataProvider = "searchWords")
	public void test(String searchWord1,String searchWord2,String SearchResult){
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		driver.findElement(By.id("stb")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains(SearchResult));		
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
		System.out.println("浏览器关闭成功");
	}
	
}
