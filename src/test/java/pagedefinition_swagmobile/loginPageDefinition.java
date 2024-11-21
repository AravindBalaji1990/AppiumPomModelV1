package pagedefinition_swagmobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginPageDefinition {
    public AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    static WebElement txt_username;

    // identify only andorid
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    static WebElement txt_password;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    static WebElement btn_login;

    public loginPageDefinition(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginSwagLab(){
        if (txt_username.isDisplayed()) {
            txt_username.sendKeys("standard_user");
        }

        if (txt_password.isDisplayed()) {
            txt_password.sendKeys("secret_sauce");
        }
        btn_login.click();

    }
}
