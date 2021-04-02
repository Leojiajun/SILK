package com.silk.elo.datadriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDriverByExcelFile {
	public WebDriver driver;
	String baseUrl = "http://resuat.thomascookonline.cn/";
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException{
		return getTestData("D:/workspace/SILK/Tools","testdatadriverbyexcel.xlsx","Sheet1");
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
	
	
	
	
	
	public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException{
		//根据参数传入的数据文件路径和文件名称，组合出Excel数据文件的绝对路径
		//声明一个File文件对象
		File file = new File(filePath + "\\" +fileName);
		//创建FileInputStream 对象用于读取Excel文件
		FileInputStream inputStream = new FileInputStream(file);
		//声明WorkString[]book对象
		Workbook Workbook = null;
		//获取文件名参数的扩展名，判断是 .xlsx 文件还是  .xls 文件
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//判断文件类型如果是 .xlsx  则使用XSSFWorkbook对象进行实例化
		//判断文件类型如果是 .xls   则使用HSSFWorkbook对象进行实例化
		if (fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(inputStream);
		}
		//通过sheetName参数，生成Sheet对象
		Sheet Sheet = Workbook.getSheet(sheetName);
		//获取Excel数据文件Sheet1中数据的行数，getLastRowNum方法获取数据的最后一行行号
		//getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
		//注意：Excel文件的行号和列好都是从 0 开始的
		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		//创建名为records的list对象来存储从Excel数据文件读取的数据
		List<Object[]> records = new ArrayList<Object[]>();
		//使用两个for循环遍历Excel数据文件的所有数据（除了第一行，第一行是数据列名称）
		//所以i从1开始，而不是从0开始
		for (int i=1 ;i<rowCount + 1;i++){
			//使用getRow方法获取行对象
			Row row = Sheet.getRow(i);
			//声明一个数组，用来存储Excel数据文件每行中的3个数据，数组的大小用
			//getLastCellNum办法来进行动态声明，实现测试数据个数和数组大小相一致
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0;j<row.getLastCellNum();j++){
				//调用getCell和getStringCellValue方法获取Excel文件中的单元格数据
				fields[j] = row.getCell(j).getStringCellValue();
			}
			//将fields的数据对象存储到records的list中
			records.add(fields);
			//定义函数返回值，即Object[][]
			//将存储测试数据的list转换为一个Object的二维数据
		}
		Object[][] results = new Object[records.size()][];
		//设置二维数据每行的值，每行是一个Object对象
		for (int i = 0 ;i<records.size();i++){
			results[i] = records.get(i);
		}
		return results;
	}
}
