package pages;

import core.BasePage;
import enums.TeamPageSubMenu;
import helper.FavoritesRow;
import helper.MenuHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TimeUtils;

import java.util.List;

/**
 * Team page-specific attributes and methods.
 */
@Getter
public class TeamPage extends BasePage {

    @FindBy(id = "com.fivemobile.thescore:id/team_name")
    private MobileElement teamName;

    @FindBy(id = "com.fivemobile.thescore:id/team_form_value")
    private MobileElement teamForm;

    @FindBy(id = "com.fivemobile.thescore:id/streak_value")
    private MobileElement streak;

    @FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='com.fivemobile.thescore:id/tabLayout']/android.widget.LinearLayout")
    private MobileElement subMenuShoveler;

    private List<FavoritesRow> leagueList;
    public TeamPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // verify we are on the correct page, and wait for the page to load..
        wait.until(ExpectedConditions.visibilityOf(teamName));
        wait.until(ExpectedConditions.visibilityOf(teamForm));
        wait.until(ExpectedConditions.visibilityOf(streak));
    }

    public void goToTeamStatsSubMenu() {
        (new MenuHelper(driver)).goToSubMenu(TeamPageSubMenu.TEAM_STATS);
    }
}
