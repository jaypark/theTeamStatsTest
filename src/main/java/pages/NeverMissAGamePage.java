package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static utils.CommonUtils.waitForElementToBeVisible;

/***
 * "Never miss a game" page and its attributes during the onboarding flow.
 */
@Getter
public class NeverMissAGamePage extends BasePage {
    @FindBy(id = "com.fivemobile.thescore:id/btn_primary")
    private MobileElement DoneBtn;

    @FindBy(id = "com.fivemobile.thescore:id/title_onboarding")
    private MobileElement onboardingTitle;

    public NeverMissAGamePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        // To ensure we're on the right page...
        waitForElementToBeVisible(driver, onboardingTitle);
    }
}
