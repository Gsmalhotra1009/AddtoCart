package com.ebay.runner;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.ebay.Stepdefinition.AddtoCart;
import com.ebay.config.Config;
import com.ebay.initdrivers.Driverbase;
import com.ebay.libraries.Log;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "C:\\AddtoCart\\src\\main\\resources\\features\\AddToCart.feature", glue = {
				"com.ebay.Stepdefinition" }, plugin = {
						"com.cucumber.listener.ExtentCucumberFormatter:" }, tags = { "@Sanity"

		}, monochrome = true

)

public class CukeRunner extends AbstractTestNGCucumberTests {

	/**
	 * This method will run before each test cases.
	 * 
	 * @author Gundeep Singh
	 * 
	 */

	AddtoCart steps = null;

	@BeforeSuite

	@BeforeTest
	public void initDriver() {

		try {

			PropertyConfigurator.configure(Config.projPath + "\\src\\main\\java\\com\\ebay\\config\\Logger.properties");
			Log.logInfo(CukeRunner.class, "Initiating drivers");
			Driverbase.setUpDriver();
			Log.logInfo(CukeRunner.class, "Initialisation of drivers is completed successfully");

			if (steps == null) {
				steps = new AddtoCart();
			}

		} catch (Exception e) {
			Log.logError(CukeRunner.class, e.getMessage());
		}

	}

	/**
	 * This method will call initially before the start of test case. This will help
	 * user to create the extent reports.
	 * 
	 * @author Gundeep Singh
	 */
	@BeforeClass
	public static void setup() {

		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyyy HH_mm_ss");
			LocalDateTime now = LocalDateTime.now();

			String currenTimeFormat = dtf.format(now);
			String cucumberFileName = "eBAYReport" + currenTimeFormat;
			String loggerFileName = "eBAYLogger_" + currenTimeFormat;
			String loggerPropertyAbsolutePath = Config.projPath
					+ "\\src\\main\\java\\com\\ebay\\config\\Logger.properties";

			PropertiesConfiguration propertiesConfig = new PropertiesConfiguration(loggerPropertyAbsolutePath);
			propertiesConfig.setProperty("log4j.appender.fileAppender.File",
					(Config.projPath + "\\target\\TestLogs\\" + loggerFileName + ".log").replace("\\", File.separator));
			propertiesConfig.save();

			PropertyConfigurator.configure(loggerPropertyAbsolutePath);

			ExtentProperties extentProperties = ExtentProperties.INSTANCE;
			extentProperties
					.setReportPath(Config.projPath + "/target/CucumberTestReports/" + cucumberFileName + ".html");

			Log.logInfo(CukeRunner.class, "Initiating Loggers Instance with file name: " + loggerFileName);
			Log.logInfo(CukeRunner.class, "Initiating Extent Reports Instance with file name: " + cucumberFileName);

		} catch (Exception e) {
			Log.logError(CukeRunner.class, e.getMessage());
		}
	}

	/**
	 * This method will call after test cases are over.This will help user to load
	 * the extent reports.
	 * 
	 * @author Gundeep Singh
	 */

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(Config.projPath + "\\src\\main\\java\\com\\ebay\\config\\extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + " 64-Bit");
		Reporter.setSystemInfo("Selenium", "3.141.5");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_201");

	}

	@AfterSuite
	public static void teardown() {
		Driverbase.getDriver().close();
	}

	/**
	 * @author Gundeep Singh
	 * 
	 * @param daysBack
	 * @param directoryPath
	 * 
	 *            This method will delete all the files older than daysBack passed
	 *            in parameter.
	 * 
	 */

}
