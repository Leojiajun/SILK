package com.silk.leo.Product;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.silk.leo.integration.BaseTest;
import com.silk.leo.util.Selenium;

public class flight extends BaseTest{
	@Test(priority=1,description = "搜索所有航班信息")
	public void searchFlight() throws SQLException{
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("flight", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo_search", "flight", driver);
		Selenium.waitFor(5000);
		Assert.assertTrue(driver.getPageSource().contains("置为无效"));
	}
	
	@Test(priority=2,description = "创建航班信息")
	public void addFlightInfo() throws SQLException{
		//基本信息
		Selenium.buttonInDB("productbtn", "product", driver);
		Selenium.buttonInDB("flight", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo_add", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo_add_flightcompany", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo_add_flightcompany_choice", "flight", driver);
		Selenium.inputInDB("flight_flightinfo_add_flighcode", "flight", "AT"+Selenium.getRandomString(4), driver);
		Selenium.waitFor(2000);
		Selenium.inputInDB("flight_flightinfo_add_flighmodel", "flight", "波音772", driver);
		Selenium.waitFor(2000);
		Selenium.findElementInDB("flight_flightinfo_add_flighmodel", "flight", driver).sendKeys(Keys.ENTER);
		Selenium.waitFor(2000);
//		Selenium.buttonInDB("flight_flightinfo_add_flighmodel", "flight", driver);
//		Selenium.buttonInDB("flight_flightinfo_add_flighmodel_choice", "flight", driver);
		Selenium.buttonInDB("flight_flightinfo_add_AirportTerminalDeparture", "flight", driver);
		Selenium.waitFor(1000);
		Selenium.buttonInDB("flight_flightinfo_add_AirportTerminalDeparture_choice", "flight", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("flight_flightinfo_add_AirportTerminalArrival", "flight", driver);
		Selenium.waitFor(500);
		Selenium.buttonInDB("flight_flightinfo_add_AirportTerminalArrival_choice", "flight", driver);
		Selenium.inputInDB("flight_flightinfo_add_departureTime", "flight", "08:00", driver);
		Selenium.inputInDB("flight_flightinfo_add_arrivalTime", "flight", "14:00", driver);
		Selenium.select("flight_flightinfo_add_foodType", "flight", "正餐", driver);
		Selenium.buttonInDB("flight_flightinfo_add_saveBtn", "flight", driver);
		Selenium.waitFor(5000);
		//班期
		Selenium.buttonInDB("flight_flightinfo_add_FlightSchedule", "flight", driver);
		Selenium.waitFor(3000);
		Selenium.buttonInDB("flight_flightinfo_add_FlightSchedule_add", "flight", driver);
		Selenium.waitFor(5000);
		Selenium.inputInDB("flight_flightinfo_add_FlightSchedule_add_startDate", "flight", "2019-08-01", driver);
		Selenium.inputInDB("flight_flightinfo_add_FlightSchedule_add_endDate", "flight", "2020-08-01", driver);
		Selenium.buttonInDB("flight_flightinfo_add_FlightSchedule_add_days", "flight", driver);
		Selenium.waitFor(2000);
		Selenium.buttonInDB("flight_flightinfo_add_FlightSchedule_add_save", "flight", driver);
		Selenium.waitFor(5000);
		Assert.assertTrue(driver.getPageSource().contains("删除"));
	}
	

}
