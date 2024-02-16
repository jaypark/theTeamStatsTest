package widgets;

import core.BasePage;
import enums.LocationAllowOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TimeUtils;

import static utils.TimeUtils.WAIT_DURATION_IN_SEC;

@Getter
public class LocationAccess {

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement whileUsingAppOption;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private MobileElement onlyThisTimeOption;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement notAllowOption;

    @FindBy(id = "com.android.permissioncontroller:id/permission_message")
    private MobileElement permissionMessage;

    public LocationAccess(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // verify we are on the correct page, and wait for the page to load.
        wait.until(ExpectedConditions.visibilityOf(permissionMessage));
    }

    public void selectAllowOption(LocationAllowOption option) {
        switch (option) {
            case WHILE_USING_APP:
                whileUsingAppOption.click();
                break;
            case ONLY_THIS_TIME:
                onlyThisTimeOption.click();
                break;
            case NOT_ALLOW:
                notAllowOption.click();
                break;
            default: throw new IllegalArgumentException("Don't know what option to choose.");
        }
    }
}

