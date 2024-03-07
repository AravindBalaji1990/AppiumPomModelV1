package utilitypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandlingElementValidation {
	private static final Logger log = LoggerFactory.getLogger(HandlingElementValidation.class);

	public static Properties OR;
	public static boolean ElementPresent(WebDriver driver, WebElement element) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			log.info("The element is visible : " + element);
			return true;
		} else {
			log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static boolean ElementPresentAndSelected(WebDriver driver, WebElement element) {
		if (element.isDisplayed() == true && element.isSelected() == true) {
			log.info("The element is visible : " + element);
			return true;
		} else {
			log.error("The element is not visible : " + element);
			return false;
		}
	}


	public static boolean TypeElement(WebDriver driver, WebElement element, String data) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			element.clear();
			element.sendKeys(data);
			log.info("The element is visible : " + element);
			return true;
		} else {
			log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static boolean TypeElementJavaScript(WebDriver driver, WebElement element, String data) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			element.clear();
			JavascriptExecutor sk = (JavascriptExecutor) driver;
			sk.executeScript("arguments[0].value='" + data + "';", element);
			log.info("The element is visible : " + element);
			return true;
		} else {
			log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static void expectedcondition(WebDriver driver, By locator, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void scrollintoview(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}


	public static void screenshot(WebDriver driver, String Screenshotname) throws IOException {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Calendar calobj = Calendar.getInstance();
		System.out.println("this is todays date and time : " + df.format(calobj.getTime()));
		String dirname = "./Screenshots_";
		// to check whether folder is there or not
		// if its not there we will create it
		File d = new File(dirname);
		if (d.exists() == true) {
			log.info("Screenshot folder available");
		} else {
			d.mkdirs();
		}

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source,
				new File(dirname + "/" + Screenshotname + "_" + df.format(calobj.getTime()) + ".jpeg"));
	}
	

	
	public static Properties getDataFromProperties() throws IOException {
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Constants\\Constants.properties");
		OR = new Properties(System.getProperties());
		OR.load(fs);
		return OR;
	}
}
