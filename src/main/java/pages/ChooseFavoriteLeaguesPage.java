package pages;

import core.OnboardingSearchPage;
import helper.FavoritesRow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.CommonUtils.waitForElementToBeVisible;

/**
 * "Choose your favorite leagues" page during the onboarding flow.
 */
public class ChooseFavoriteLeaguesPage extends OnboardingSearchPage {

    // TODO: Take out the @text clause if this page appears in different language.
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/title_onboarding' and @text='Choose your favorite leagues']")
    private MobileElement onboardingTitle;

    public ChooseFavoriteLeaguesPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        waitForElementToBeVisible(driver, onboardingTitle);
    }
}
