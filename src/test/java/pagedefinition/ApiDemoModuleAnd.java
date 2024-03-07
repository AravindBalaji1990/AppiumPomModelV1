package pagedefinition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ApiDemoModuleAnd {
    private AndroidDriver driver;
    //constructor
    public ApiDemoModuleAnd(AndroidDriver driver) {
    this.driver= driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // this does not workout in POM model
//    WebElement element =  driver.findElement(AppiumBy.xpath(""));
    //Android
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    public static WebElement btn_views;

    //ios
//    @iOSXCUITFindBy(xpath = "")
//    public static WebElement btn_name;


    public boolean validatebutton(){
        return btn_views.isDisplayed();

    }
}
