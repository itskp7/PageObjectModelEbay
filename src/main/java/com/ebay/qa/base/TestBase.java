package com.ebay.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ebay.qa.util.TestUtil;
import com.ebay.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;   // public so that can be used in the child classes too
	public static Properties prop;  // global variable so can be used throughout the program in (child classes + base class) too
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){        // constructor
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Selenium_Workspace\\PageObjectModelEbay\\src\\main"
					+ "\\java\\com\\ebay\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {        //initialization method for browser setup
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\SeleniumJars\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No browser value found");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();                         // object of class from util package
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  // inside testutil class so values are not hardcoded
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	

}
