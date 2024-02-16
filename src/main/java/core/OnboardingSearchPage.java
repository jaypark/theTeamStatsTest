package core;

import helper.ScrollHelper;
import helper.FavoritesRow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.SearchFavoritePage;

import java.util.ArrayList;
import java.util.List;

public abstract class OnboardingSearchPage extends SearchBasePage {

    @Getter
    @FindAll({
        @FindBy(id = "com.fivemobile.thescore:id/btn_primary"),
        @FindBy(id = "com.fivemobile.thescore:id/accept_button")
    })
    private MobileElement continueBtn;

    @FindBy(id = "com.fivemobile.thescore:id/search_bar_placeholder")
    protected MobileElement searchBar;

    List<FavoritesRow> rowsList;

    private final String rowFavoriteIndicatorCss = "[resource-id='com.fivemobile.thescore:id/follow_icon']";

    public OnboardingSearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Search for the rowName in the list, on the first page only for now.
     * Enhancement would be to create search capability over multiple pages.
     * On the Onboarding page, a row consists of icon, name and favorites star.
     * @param rowName
     * @return
     */
    public FavoritesRow findRowByNameOnFirstPage(String rowName) {
        rowsList = new ArrayList<>();
        FavoritesRow searchListRow = new FavoritesRow();
        for (MobileElement row : searchResultsList) {
            MobileElement leagueName;
            if (row.isDisplayed()) {
                try {
                    leagueName = row.findElement(By.cssSelector(rowNameCss));
                } catch (NoSuchElementException e) {
                    // In case the last row is hidden behind the Continue button.
                    ScrollHelper.scrollDown(driver);
                    leagueName = row.findElement(By.cssSelector(rowNameCss));
                }
                if (leagueName.getText().toLowerCase().contains(rowName.toLowerCase())) {
                    searchListRow.setRowName(leagueName);
                    MobileElement icon = row.findElement(By.cssSelector(rowIconCss));
                    searchListRow.setRowIcon(icon);
                    MobileElement leagueFavoriteIndicator = row.findElement(By.cssSelector(rowFavoriteIndicatorCss));
                    searchListRow.setRowFavoriteIndicator(leagueFavoriteIndicator);
                    return searchListRow;
                }
            }
        }
        throw new NoSuchElementException("No item named '" + rowName + "' found in the list.");
    }

    /**
     * Mark the specified row favorite.
     * @param rowName
     */
    public void makeRowFavorite(String rowName) {
        FavoritesRow row = findRowByNameOnFirstPage(rowName);
        // TODO: Need to figure out what element holds the Favorite indicator state
        //       to determine whether the star got toggle on or off.
        //       For now, assume that it's not toggled on.
        row.getRowFavoriteIndicator().click();
    }

    /**
     * Enter the search word in the search bar.
     * @param rowName
     */
    public void search(String rowName) {
        searchBar.click(); // puts the cursor in the search bar
        SearchFavoritePage searchFavoritePage = new SearchFavoritePage(driver);
        searchFavoritePage.search(rowName);
    }
}
