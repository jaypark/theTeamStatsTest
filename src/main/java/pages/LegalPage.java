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
 * CCPA legal page during the onboarding flow.
 */
@Getter
public class LegalPage extends BasePage {

    @FindBy(id = "com.fivemobile.thescore:id/accept_button")
    private MobileElement continueBtn;

    // TODO: Refactor if this page is specific to CA users since others may not see this page or may see in different verbiage.
    @FindBy(xpath = "//android.widget.TextView[@text='Hey California! Your rights under the California Consumer Privacy Act (CCPA)']")
    private MobileElement legalHeaderText;

    public LegalPage(AppiumDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // Verify we are on the correct page, and wait for the page to load.
        wait.until(ExpectedConditions.visibilityOf(legalHeaderText));
    }
}
