package pages;

import core.OnboardingSearchPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import static utils.CommonUtils.waitForElementToBeVisible;

/**
 * "Choose your favorite teams" page during the onboarding flow.
 */
public class ChooseFavoriteTeamsPage extends OnboardingSearchPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/title_onboarding' and @text='Choose your favorite teams']")
    private MobileElement onboardingTitle;
    
    public ChooseFavoriteTeamsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        // To ensure we're on the right page...
        waitForElementToBeVisible(driver, onboardingTitle);
    }

}
