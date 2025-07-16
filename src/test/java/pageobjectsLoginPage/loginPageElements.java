package pageobjectsLoginPage;

import TestBase.SwagAppRun;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginPageElements extends SwagAppRun {
    AndroidDriver driver;

    public loginPageElements(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    public static WebElement txt_username;

    // identify only andorid
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    public static WebElement txt_password;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    public static WebElement btn_login;
}
