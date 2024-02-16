package pages;

import core.SearchBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static utils.CommonUtils.waitForElementToBeVisible;

/**
 * This page is where favorite league or team is chosen.
 */
public class SearchFavoritePage extends SearchBasePage {

    public SearchFavoritePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        // To ensure we're on the right page...
        waitForElementToBeVisible(driver, typableSearchBar);
    }
}