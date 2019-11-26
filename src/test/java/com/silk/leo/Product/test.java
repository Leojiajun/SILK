package com.silk.leo.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.silk.leo.integration.BaseTest;

public class test{
	public static void main(String[] args) throws InterruptedException{
		  FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://resuat.thomascookonline.cn/login.html");
		  driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/input[1]")).sendKeys("admin");
		  driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/input[2]")).sendKeys("test1111");
		  driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/a")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("html/body/div[1]/div[1]/a[7]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[10]/a/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[10]/ul/li[1]/a")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/div/a")).click();
		  

	}
}
