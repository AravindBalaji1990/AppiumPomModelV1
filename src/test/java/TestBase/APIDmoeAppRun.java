package TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagedefinition_ApiDemo.ApiDemoModuleAnd;

import java.net.MalformedURLException;
import java.net.URL;

public class APIDmoeAppRun {
    public AndroidDriver driver ;
    // this will identify the elements as well as the actions to be performed onthe element
    public ApiDemoModuleAnd apidemomodule;

    // we will start the server by default from the code
//    AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();


    @BeforeMethod
    public void start() throws InterruptedException, MalformedURLException {
        System.out.println("this is start of my project");
        // this helpd top run the appium with out manual interventions
//        serviceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(200))
//                .build().start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

    }

    @AfterMethod
    public void teardown() {
        System.out.println("this is teardown of my project");
        driver.quit();
//        serviceBuilder.build().stop();
    }

    @Test
    public void testcase() {
        apidemomodule = new ApiDemoModuleAnd(driver);
        Assert.assertTrue(apidemomodule.validatebutton());
    }

}
