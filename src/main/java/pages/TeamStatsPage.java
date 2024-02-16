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
 * Team Stats page-specific attributes and methods.
 */
@Getter
public class TeamStatsPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/header_text']")
    private MobileElement headerCol1;

    @FindBy(id = "com.fivemobile.thescore:id/header_secondary_text")
    private MobileElement headerCol2;

    @FindBy(xpath = "//android.widget.TextView[@text='TEAM STATS']")
    private MobileElement teamStatsMenu;

    public TeamStatsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // verify we are on the correct page, and wait for the page to load.
        wait.until(ExpectedConditions.visibilityOf(headerCol1));
    }
}
