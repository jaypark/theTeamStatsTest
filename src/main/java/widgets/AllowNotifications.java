package widgets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TimeUtils;

@Getter
public class AllowNotifications {

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement allowBtn;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement notAllowBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Allow theScore to send you notifications?']")
    private MobileElement permissionMessage;

    public AllowNotifications(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // verify we are on the correct page, and wait for the page to load..
        wait.until(ExpectedConditions.visibilityOf(permissionMessage));
    }
}

