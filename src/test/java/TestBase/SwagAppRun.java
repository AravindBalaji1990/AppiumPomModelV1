package TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pagedefinition_swagmobile.*;


import java.net.MalformedURLException;
import java.net.URL;

public class SwagAppRun {
    private static final Logger logger = LoggerFactory.getLogger(SwagAppRun.class);
    public static AndroidDriver driver;
    loginPageDefinition loginPageDefinition ;
    dashboardPageDefinition dashboardpagedefinition;
    AppiumDriverLocalService service;

//    @BeforeSuite
//    public void startAppiumServer(){
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
//        System.out.println(service.isRunning());
//    }
//
//    @AfterSuite
//    public void closeAppiumServer(){
//        service.stop();
//    }


    @BeforeMethod
    public void prerequisite() throws MalformedURLException, InterruptedException {
        logger.info("starting server");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("55ZTINFYRW5T6DNR");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppWaitForLaunch(true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void postrequisite() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testcase(){
        loginPageDefinition = new loginPageDefinition(driver);
        loginPageDefinition.loginSwagLab();

        dashboardpagedefinition = new dashboardPageDefinition(driver);
        dashboardpagedefinition.validateDashgboard();

    }
}
