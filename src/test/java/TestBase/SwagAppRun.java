package TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagedefinition_swagmobile.*;


import java.net.MalformedURLException;
import java.net.URL;

public class SwagAppRun {
    public static AndroidDriver driver;
    loginPageDefinition loginPageDefinition ;
    dashboardPageDefinition dashboardpagedefinition;

    @BeforeMethod
    public void prerequisite() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
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
