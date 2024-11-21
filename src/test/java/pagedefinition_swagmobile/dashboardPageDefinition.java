package pagedefinition_swagmobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilitypack.CommonUtils;
import utilitypack.HandlingElementValidation;

import java.util.List;

public class dashboardPageDefinition {
    public AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    static List<WebElement> lbl_products;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    static WebElement lbl_product;

    public dashboardPageDefinition(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void validateDashgboard(){
        HandlingElementValidation.waitForElmentSize(driver, 60, AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"), 1);
        Assert.assertTrue(lbl_products.size()>0);
    }

}
