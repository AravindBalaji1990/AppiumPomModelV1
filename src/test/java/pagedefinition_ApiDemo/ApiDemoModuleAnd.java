package pagedefinition_ApiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApiDemoModuleAnd {
    private AndroidDriver driver;

    //constructor
    public ApiDemoModuleAnd(AndroidDriver driver) {
        // from the AndoridRun class we pass the driver instance to the current class driver(assigning the driver to the new class via constructor)
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // this does not workout in POM model
//    WebElement element =  driver.findElement(AppiumBy.xpath(""));

    //Android
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    public static WebElement btn_views;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    public static List<WebElement> btn_totalitems;


    //ios
//    @iOSXCUITFindBy(xpath = "")
//    public static WebElement btn_name;


    // Aciton that will be perfomed onthe element
    public boolean validatebutton() {
        return btn_views.isDisplayed();
    }
}
