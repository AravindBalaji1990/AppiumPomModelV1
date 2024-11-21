package pagedefinition_ApiDemo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApiDemoModuleIos {
    private IOSDriver driver;
    //constructor
    public ApiDemoModuleIos(IOSDriver driver) {
    this.driver= driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // this does not workout in POM model
//    WebElement element =  driver.findElement(AppiumBy.xpath(""));


    //ios
    @iOSXCUITFindBy(xpath = "")
    public static WebElement btn_name;

    @iOSXCUITFindBy(xpath = "")
    public static List<WebElement> btn_names;

    public boolean validatebutton(){
        return btn_name.isDisplayed();

    }
}
