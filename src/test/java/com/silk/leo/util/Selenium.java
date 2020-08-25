package com.silk.leo.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Selenium {
	private static Logger logger = Logger.getLogger(Selenium.class);
	public static int  timeout=10;
	public static Connection conn=null;
	public static ResultSet rs=null;
	
	/**
	 * 
	 * @param locator
	 * @param driver
	 * @return element
	 */
	public static WebElement findElement(String locator,WebDriver driver){
		By by = parseLocator(locator);
		WebElement element = null;
		try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions
                    .presenceOfElementLocated(by));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Can't locate the web element by the locator" + locator);
        }
		return element;	
		
	}
	
	/**
	 * 
	 * @param localtername
	 * @param tablename
	 * @param driver
	 * @return driver.findelement
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static WebElement findElementInDB(String locatorname,String tablename,WebDriver driver) throws SQLException {
		//需要先链接数据库
//		try{
//			return driver.findElement(By.xpath(getdbData(locatorname, tablename)));
//		}catch(NoSuchElementException e){
//			return driver.findElement(By.cssSelector(getdbData(locatorname, tablename)));
//		}
		
		
//		By by =null;
//		WebElement element = null;
//		try{
//			by = By.xpath(getdbData(locatorname, tablename));	
//		}catch(Exception e){
//			by = By.cssSelector(getdbData(locatorname, tablename));
//		}
//		try {
//          WebDriverWait wait = new WebDriverWait(driver, timeout);
//           element = wait.until(ExpectedConditions
//                    .presenceOfElementLocated(by));
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("Can't locate the web element by the locator" + locatorname);
//        }
//		return element;	
		
		
		WebElement element = null;
		try{
    		WebDriverWait wait = new WebDriverWait(driver,timeout);
    		try{
    			//启用xpath
    			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getdbData(locatorname,tablename))));
    		}catch(Exception e){
    			//报错后启用css
    			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(getdbData(locatorname,tablename))));
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error("Can't locate the web element by the locator "
                   + locatorname);
    	}
    	return element;
	}
	
	
	
    /**
     * 根据元素路径，返回WebElement组件
     *
     * @param locator 元素路径
     * @return WebElement
     */
    public static List<WebElement> findElements(String locator,WebDriver driver) {
        By by = parseLocator(locator);
        List<WebElement> elements = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            e.printStackTrace();
          logger.error("Can't locate the web element by the locator "
                   + locator);
        }
        return elements;
    }
	
    
    
    /**
     * 根据元素路径，返回WebElement组件,数据库取值
     * @param locatorname
     * @param tablename
     * @param driver
     * @return
     */
    public static List<WebElement> findElementsInDB(String locatorname,String tablename,WebDriver driver){
    	List<WebElement> elements = null;
    	try{
    		WebDriverWait wait = new WebDriverWait(driver,timeout);
    		try{
    			elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(getdbData(locatorname,tablename))));
    		}catch(NoSuchElementException e){
    			elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(getdbData(locatorname,tablename))));
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error("Can't locate the web element by the locator "
                   + locatorname);
    	}
    	return elements;
    }
    
    
    
	/**
	 * selenium原生输入内容
	 * @param locator
	 * @param value
	 * @param driver
	 */
	public static void input(String locator,String value,WebDriver driver){
		WebElement element = findElement(locator,driver);
		if(null != element){
			try{
				element.sendKeys(Keys.BACK_SPACE);
				element.clear();
				element.sendKeys(value);
				logger.info("input success");
			}catch(Exception e){
				e.printStackTrace();
				logger.debug("Failed to input something  查看截图");   
			}
		}
	}
	
	
	/**
	 * selenium原生输入内容,数据库取值
	 * @param locatorname
	 * @param tablename
	 * @param value
	 * @param driver
	 * @throws SQLException
	 */
	public static void inputInDB(String locatorname,String tablename,String value,WebDriver driver) throws SQLException{
		WebElement element = findElementInDB(locatorname, tablename, driver);
		if(null != element){
			try{
				element.sendKeys(Keys.BACK_SPACE);
				element.clear();
				element.sendKeys(value);
				logger.info(locatorname+" input success");
			}catch(Exception e){
				e.printStackTrace();
				logger.debug(locatorname+" Failed to input the web element  查看截图");   
			}
		}
	}
	
	
	
	
	/**
	 * selenium原生点击
	 * @param locator
	 * @param driver
	 * @throws IOException 
	 * @throws WebDriverException 
	 */
	public static void button(String locator,WebDriver driver){
		WebElement element = findElement(locator,driver);
		if (null != element) {
            try {
                element.click();
                logger.info("Clicked on the element " +locator);
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("Failed to click the web element 查看截图");    
            }
        }
	}
	
	
	/**
	 * selenium原生点击,数据库取值
	 * @param locatorname
	 * @param tablename
	 * @param driver
	 * @throws SQLException
	 */
	public static void buttonInDB(String locatorname,String tablename,WebDriver driver) throws SQLException{
		WebElement element = findElementInDB(locatorname, tablename, driver);
		if (null != element) {
            try {
                element.click();
                logger.info("Clicked on the element " +locatorname);
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("Failed to click the web element "+locatorname);    
            }
        }
	}
	/**
	 * 调用javascript点击
	 * @param locator
	 * @param driver
	 */
	public static void JavaScriptClick(String locator,WebDriver driver){
		WebElement element = findElement(locator,driver);
		if (element.isEnabled() && element.isDisplayed()){
			((JavascriptExecutor) driver ).executeScript("arguments[0].click();",element);
			 logger.info("JS  Click on the page element " + locator);
		}else{
			logger.debug("JS Failed to click the page element " + locator);		
		}
	}
	
	
	/**
	 * 调用js鼠标点击操作
	 * @param locator
	 * @param driver
	 */
    public static void mouseClick(String locator,WebDriver driver) {
    	WebElement element = findElement(locator,driver);
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('click',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("JS  Click on the page element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("JS Failed to click the page element " + locator);
            }
        }
    }
    
    
    /**
     * 调用js鼠标点击操作,数据库取值
     * @param locatorname
     * @param tablename
     * @param driver
     * @throws SQLException
     */
    public static void mouseClickInDB(String locatorname,String tablename,WebDriver driver) throws SQLException {
    	WebElement element = findElementInDB(locatorname, tablename, driver);
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('click',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("JS  Click on the page element " + locatorname);
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("JS Failed to click the page element " + locatorname);
            }
        }
    }
	
	
	
    /**
     * 通过调用js，使光标悬浮在某个元素上方
     *
     * @param locator
     */
    public static void mouseOver(String locator,WebDriver driver) {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        WebElement element = findElement(locator,driver);
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('mouseover',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("JS  Mouse over the page element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("JS Failed to mouseover the page element " + locator);
            }
        }
    }
	
    
    /**
     * 通过调用js，使光标悬浮在某个元素上方,数据库取值
     * @param locatorname
     * @param tablename
     * @param driver
     * @throws SQLException
     */
    public static void mouseOverInDB(String locatorname,String tablename,WebDriver driver) throws SQLException {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        WebElement element = findElementInDB(locatorname, tablename, driver);
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('mouseover',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("JS  Mouse over the page element " + locatorname);
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("JS Failed to mouseover the page element " + locatorname);
            }
        }
    }
    
    /**
     * 切换window
     *
     * @param partialTitleName 页面标题
     */
    public static void toSpecificWindow(String partialTitleName,WebDriver driver){
    	Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
			if(titlename.contains(partialTitleName));
			break;
		}	
    }
    
    
    /**
     * 切换到另一窗口,当两个页面的标题相同的时候，删除第一个，切换到第二个
     */
    public static void switchToAnotherWindow(WebDriver driver) {
        String current = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(current);
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }
    
    
    
    /**
     * 切换到Frame
     */
    public static void accessFrame(String nameOrId,WebDriver driver) {
        driver.switchTo().frame(nameOrId);
        logger.info("Entered iframe " + nameOrId);
    }
    
    
    /**
     * 截图，保存在   项目目录/test-output/screen-shot下
     * @throws IOException 
     * @throws WebDriverException 
     */
    public static void takesScreenshot(WebDriver driver) throws WebDriverException, IOException  {
       String SCREEN_SHOT_PATH = "test-output/screen-shot";  
        String SCREEN_SHOT_NAME = null; 
        File screenShotDir = new File(SCREEN_SHOT_PATH);  
        if (!screenShotDir.exists()) {  
            screenShotDir.mkdirs();  
    }  
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = df.format(new Date());//取当前时间的年月日时分秒为截图的名称
        SCREEN_SHOT_NAME = dateStr + ".jpg";  
        FileUtils.copyFile( ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), 
                new File(SCREEN_SHOT_PATH + "/" + SCREEN_SHOT_NAME));
        logger.info("已截图，查看test-output/screen-shot/"+SCREEN_SHOT_NAME);
    }  
 

	/**
	 * 
	 * @param date
	 * @return 当前时间加1天
	 */
		public static String getNextDay(Date date){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
			date=calendar.getTime();
			return df.format(date);
			}
		
		
		/**
		 * 
		 * @return  当前时间
		 */
		public static String getToday(){
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			return df.format(new Date());
					}
		
		public static String getTodayYYMMDD(){
			Date date = new Date();//先获取当前日期
	    	String todatDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    	return todatDate;
		}
		
		
		/**
		 * 
		 * @param length
		 * @return 随机生成字符串
		 */
		
		public static String getRandomString(int length) {//length表示生成字符串的长度
			String base = "abcdefghijklmnopqrstuvwxyz0123456789";
			Random random = new Random();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				int number = random.nextInt(base.length());
				sb.append(base.charAt(number));
			}
			return sb.toString();
		}
		
		
		
		/**
		 * 链接数据库
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public static void connection()
			 throws ClassNotFoundException, SQLException {
					    // 设定mysql驱动
					Class.forName("com.mysql.cj.jdbc.Driver");
					    // 建立数据库连接
					conn = DriverManager.getConnection(
					        "jdbc:mysql://192.168.64.2:3306/test?useSSL=false", "root", "123456");
					    // 判断数据库连接是否成功
					if (!conn.isClosed()) {
					 System.out.println("数据库连接成功");
					  } else {
					    System.out.println("数据库连接失败");
					    }
				}
					   
		/**
		 * 关闭数据库连接
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
				public static void shutdown()
					      throws ClassNotFoundException, SQLException {
					 // 关闭数据集
				    rs.close();
				    System.out.println("关闭数据集");
					
				    // 关闭连接
				    conn.close();
				    System.out.println("关闭链接");
					   
				}
				
		/**
		 * 获取表中数据
		 * @param localtername
		 * @param tablename
		 * @return  元素路径  String elementpath
		 * @throws SQLException
		 */
				public static String getdbData(String locatorname,String tablename) throws SQLException{
					String elementpath=null;
				 // 创建Statement对象可以用对应的方法executeQuery(sql语句)获取测试数据
			    Statement sta = conn.createStatement();
			    // 创建一个结果集存放数据库执行完sql的数据
			    rs = sta.executeQuery("select * from " + tablename
			        + " where keyname = '" + locatorname + "';");

			    while (rs.next()) {
			        elementpath = rs.getString("path");// 获取“XpathOrCss”字段的值
			    }
			   
			    return elementpath;
			  
				}
				
				
				//等待时间
		public static void waitFor(long timeout){
		  try {
			Thread.sleep(timeout);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
  }		
		
		/**
		 * 
		 * @param locatorname
		 * @param tablename
		 * @param option
		 * @param driver
		 * @throws SQLException
		 */
	    public static void select(String locatorname,String tablename, String option,WebDriver driver) throws SQLException {
	        WebElement element = findElementInDB(locatorname, tablename, driver);
	        if (null != element) {
	            Select select = new Select(element);
	            try {
	                select.selectByVisibleText(option);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
	    /**
	     * 清除属性值，比如清除日期选择框的readonly属性，这样可以直接输入日期
	     * @param driver
	     * @param element
	     * @param attributeName
	     */
	    public static void removeAttribute(WebDriver driver,WebElement element,String attributeName) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//调用js代码删除页面元素的属性值，arguments[0]-[1]分别会用后面的element、attributeName参数进行替换，并执行
			//若想删除多个属性，后面再传参数，代替arguments[2]
			js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])", element,attributeName);
		}

		
	/**
	 * 路径解析
	 * @param locator
	 * @return by
	 */
	public static By parseLocator(String locator) {
        String lowerLocator = locator.toLowerCase();
        String actualLocator;
        By by = null;
        if (lowerLocator.startsWith("id=")) {
            actualLocator = locator.substring(3);
            by = By.id(actualLocator);
        } else if (lowerLocator.startsWith("name=")) {
            actualLocator = locator.substring(5);
            by = By.name(actualLocator);
        } else if (lowerLocator.startsWith("class=")) {
            actualLocator = locator.substring(6);
            by = By.className(actualLocator);
        } else if (lowerLocator.startsWith("tag=")) {
            actualLocator = locator.substring(4);
            by = By.tagName(actualLocator);
        } else if (lowerLocator.startsWith("link=")) {
            actualLocator = locator.substring(5);
            by = By.partialLinkText(actualLocator);
        } else if (lowerLocator.startsWith("css=")) {
            actualLocator = locator.substring(4);
            by = By.cssSelector(actualLocator);
        } else if (lowerLocator.startsWith("xpath=")) {
            actualLocator = locator.substring(6);
            by = By.xpath(actualLocator);
        } else {
            logger.error("Format Error: id=,class=,tag=,name=,link=,css=,xpath=");
        }
        return by;
    }
}
