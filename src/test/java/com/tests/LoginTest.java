package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;


public class LoginTest {
	
	//What is log? : capturing info/activities at the time of program excecution.
	//types of logs:
	  //1. info
	  //2. warn
	  //3. debug
	  //4. fatal
	
	//how to generate the logs? : use log4j API
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create : create inside resources folder
	
	WebDriver driver;
	
	Logger log = LogManager.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/meghamapalagama/eclipse-workspace/Log_four_j_naveen/chromedriver 2");
		driver=new ChromeDriver();
		log.info("launching chrome browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		log.info("entering application URL");
		log.warn("Hey this is just a warning");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		
	}
	
	@Test(priority=1)
	public void googletitleTest() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println("Amazon title is ----->  "+title);
		log.info("login page title is-->"+title);
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		//Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void logo_of_Googletest() throws InterruptedException {
		boolean b=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
		Assert.assertTrue(b);
		//Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
