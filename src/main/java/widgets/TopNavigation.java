package widgets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class TopNavigation {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backBtn;

    public TopNavigation(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        CommonUtils.waitForElementToBeVisible(driver, backBtn);
    }

    public void goToPreviousPage() {
        backBtn.click();
    }

}

