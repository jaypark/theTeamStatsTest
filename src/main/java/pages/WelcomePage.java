package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TimeUtils;

/**
 * Welcome page-specific attributes and methods.
 */
@Getter
public class WelcomePage extends BasePage {
    @FindBy(id = "com.fivemobile.thescore:id/btn_primary")
    private MobileElement getStartedBtn;

    @FindBy(id = "com.fivemobile.thescore:id/txt_welcome")
    private MobileElement welcomeText;

    public WelcomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        // Define a WebDriverWait instance with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // verify we are on the correct page, and wait for the page to load..
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
    }
}
