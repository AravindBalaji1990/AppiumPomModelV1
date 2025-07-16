package pagedefinition_swagmobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjectsLoginPage.loginPageElements;

import static pageobjectsLoginPage.loginPageElements.*;

public class loginPageDefinition extends loginPageElements{
    private static final Logger logger = LoggerFactory.getLogger(loginPageDefinition.class);
    public AndroidDriver driver;

    public loginPageDefinition(AndroidDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginSwagLab(){
        logger.info("I am entering the username and password");
        if (txt_username.isDisplayed()) {
            txt_username.sendKeys("standard_user");
        }else{
            logger.error("no field username available");
        }

        if (txt_password.isDisplayed()) {
            txt_password.sendKeys("secret_sauce");
        }
        btn_login.click();


    }
}
