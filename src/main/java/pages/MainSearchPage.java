package pages;

import core.SearchBasePage;
import enums.SearchResultsSubMenu;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.CommonUtils.waitForElementToBeVisible;

/**
 * This is the Main Search Page entered through clicking into the top search bar.
 */
public class MainSearchPage extends SearchBasePage {

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.fivemobile.thescore:id/recyclerView']/android.widget.LinearLayout")
    protected List<MobileElement> rowsElems;

    public MainSearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        // To ensure we're on the right page...
        waitForElementToBeVisible(driver, typableSearchBar);
    }

    /**
     * Search without search type will by default display the results under the ALL sub-tab.
     * @param searchStr
     */
    public void search(String searchStr) {
        search(searchStr, SearchResultsSubMenu.ALL);
    }

    /**
     * This search helper method will search for the specified string, then click on the sub menu
     * according to the SearchResultsSubMenu to display the data of specific type.
     * @param searchStr
     * @param searchResultsSubMenu
     */
    private void search(String searchStr, SearchResultsSubMenu searchResultsSubMenu) {
        typableSearchBar.sendKeys(searchStr);
        MobileElement subMenu = null;
        switch (searchResultsSubMenu) {
            case ALL:
            case TEAMS:
            case PLAYERS:
            case NEWS:
                subMenu = (MobileElement) driver.findElement(By.xpath(
                        "//android.widget.TextView[@text='" + searchResultsSubMenu.getDisplayedMenuName() + "']"));
                break;
            default:
                throw new RuntimeException("Unknown sub menu!");
        }
        if (subMenu != null) {
            subMenu.click();
        } else {
            throw new NoSuchElementException("No such submenu found.");
        }
    }
    public void searchForTeam(String teamName) {
        search(teamName, SearchResultsSubMenu.TEAMS);
    }
}
