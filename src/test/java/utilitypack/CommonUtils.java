package utilitypack;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;


public class CommonUtils {

	private static Properties prop = new Properties();
	public static int EXPLICIT_WAIT_TIME;
	public static int IMPLICIT_WAIT_TIME;
	public static int DEFAULT_WAIT_TIME;
	public static String APPLICATION_NAME;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String APP_PASSWORD;
	private static String APPIUM_PORT;
	public static String AUTOMATION_INSTRUMENTATION;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String NEW_COMMAND_TIMEOUT;
	public static String PLATFORM_VERSION;
	public static String DEVICE_READY_TIMEOUT;
	public static String DEVICE_NAME;
	public static String APP;
	public static String UDID;
//	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static URL serverUrl;
	private static AppiumDriver driver;
	static AppiumDriverLocalService service;
	static AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

	public static void loadConfigProp(String propertyFileName) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\CommonFiles\\" + propertyFileName);
		prop.load(fis);

		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
		APPLICATION_NAME = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		APPIUM_PORT = prop.getProperty("appium.server.port");
//		AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instumentation");
		DEVICE_NAME = prop.getProperty("device.name");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		NEW_COMMAND_TIMEOUT = prop.getProperty("new.command.timeout");
		DEVICE_READY_TIMEOUT = prop.getProperty("device.ready.timeout");

	}
	public static AppiumDriver getDriver() throws MalformedURLException {
		//windows path : Users/YourUserName/AppData/Roaming/npm/node_modules/appium/build/lib/main.js
		serviceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(200)).build().start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("emulator-5554");
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
		options.setAppWaitDuration(Duration.ofMillis(50000));
		options.setAppPackage("com.saucelabs.mydemoapp.rn");
		options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
		options.setAppWaitForLaunch(true);
		serverUrl = new URL("http://0.0.0.0:4723");
		driver = new AndroidDriver(serverUrl, options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static void loadIOSConfigProp(String propertyFileName) throws IOException
	 {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
		prop.load(fis);
		
		EXPLICIT_WAIT_TIME = Integer
				.parseInt(prop.getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer
				.parseInt(prop.getProperty("implicit.wait"));
		DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
		//APPLICATION_NAME = prop.getProperty("application.path");
		UDID = prop.getProperty("udid");
		APP = prop.getProperty("application.app");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		AUTOMATION_INSTRUMENTATION=prop.getProperty("automation.instumentation");
		DEVICE_NAME=prop.getProperty("device.name");
		BROWSER_NAME=prop.getProperty("browser.name");
		PLATFORM_NAME=prop.getProperty("platform.name");
		PLATFORM_VERSION=prop.getProperty("platform.version");
		NEW_COMMAND_TIMEOUT=prop.getProperty("new.command.timeout");
		DEVICE_READY_TIMEOUT=prop.getProperty("device.ready.timeout");
}

	public static AppiumDriver getIOSDriver() throws MalformedURLException {
//		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
		options.setAutoWebview(true);
		options.setAppPushTimeout(Duration.ofMillis(50000));
		options.setBundleId("com.moataz.dailycheck");
		serverUrl = new URL("http://localhost:4723");
		driver = new IOSDriver(serverUrl, options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
