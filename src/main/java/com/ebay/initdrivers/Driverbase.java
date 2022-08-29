package com.ebay.initdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ebay.config.Config;
import com.ebay.libraries.Log;


public class Driverbase extends Config {

	public static Driverbase oRDPDriver;
	public static WebDriver driver;

	/**
	 * This Constructor will initiate different explorer based on the browser name
	 * passed into INI file.
	 * 
	 * @author Gundeep Singh
	 */
	private Driverbase() {

		try {

			if (browserName.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", projPath + driverRelativePath + "chromedriver.exe");
				Driverbase.driver = new ChromeDriver();
				Log.logInfo(Driverbase.class, "Created Chrome driver instace");

			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", projPath + driverRelativePath + "IEDriverServer.exe");
				Driverbase.driver = new InternetExplorerDriver();
				Log.logInfo(Driverbase.class, "Created IE driver instace");

			} else if (browserName.equalsIgnoreCase("FIREFOX")) {
				System.setProperty("webdriver.gecko.driver", projPath + driverRelativePath + "geckodriver.exe");
				Driverbase.driver = new FirefoxDriver();
				Log.logInfo(Driverbase.class, "Created FireFox driver instace");
			}

			Driverbase.driver.manage().window().maximize();
			Log.logInfo(Driverbase.class, "Maximize the explorer window");
			Driverbase.driver.manage().timeouts().implicitlyWait(objectWaitTime, TimeUnit.SECONDS);

		} catch (Exception e) {
			Log.logError(Driverbase.class, e.getMessage());
		}
	}

	/**
	 * This method will help to call the constructor of this class only.
	 * 
	 * @author Gundeep Singh
	 */
	public static void setUpDriver() {

		try {

			if (Driverbase.driver == null) {
				Log.logInfo(Driverbase.class, "Setup the new driver");
				oRDPDriver = new Driverbase();
			}
		} catch (Exception e) {
			Log.logError(Driverbase.class, e.getMessage());
		}
	}

	/**
	 * Getting the driver instance.
	 * 
	 * @author Gundeep Singh
	 * @return Returning the driver instance.
	 */
	public static WebDriver getDriver() {
		return Driverbase.driver;
	}
}
