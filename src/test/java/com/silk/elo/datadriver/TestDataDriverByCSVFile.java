package com.silk.elo.datadriver;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.silk.leo.Launch.Browsers;

import com.silk.leo.Launch.BrowsersType;

public class TestDataDriverByCSVFile {
	static WebDriver driver;
	@BeforeClass
	public void loadDriver(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;		
	}
	
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException{
		return getTestData("D:/workspace/SILK/Tools/e.csv");
	}
	
	@Test(dataProvider="testData")
	public void testSearch(String searchWord1,String searchWord2,String searchResult){
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		driver.findElement(By.id("stb")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains(searchResult));
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
		System.out.println("浏览器关闭成功");
	}
	
	   //这是一个读取csv文件的静态方法，使用csv文件的绝对路径作为函数参数
	public static Object[][] getTestData(String fileName) throws IOException{
		List<Object[]> records = new ArrayList<Object[]>();
		String record;
	   //设定GBK字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"GBK"));
	   //忽略读取csv文件的标题行（第一行）
			file.readLine();
		/*遍历读取文件中除第一行外的其他所有行内容
		 * 并存储在名为records的ArrayList中
		 * 每一个records中存储的对象为一个String数组
		 */
		while ((record = file.readLine()) != null){
			String fields[]=record.split(",");
			records.add(fields);
		}
		//关闭对象
		file.close();
		//将存储测试数据的list转换为一个Object的二维数组
		Object[][] results = new Object[records.size()][];
		//设置二维数组每行的值，每行是一个Object对象
		for (int i = 0; i<records.size(); i++){
			results[i] = records.get(i);
		}
		return results;
	}
	
}
