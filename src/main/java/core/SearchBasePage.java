package core;

import helper.ScrollHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SearchBasePage extends BasePage {

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.fivemobile.thescore:id/recyclerView']/android.widget.LinearLayout")
    protected List<MobileElement> searchResultsList;

    @Getter
    @FindBy(id = "com.fivemobile.thescore:id/search_src_text")
    protected MobileElement typableSearchBar;

    protected final static String rowIconCss = "[resource-id='com.fivemobile.thescore:id/img_logo']";
    protected final static String rowNameCss = "[resource-id='com.fivemobile.thescore:id/txt_name']";

    public SearchBasePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Search for the rowName in the list, on the first page only for now.
     * Enhancement would be to create search capability over multiple pages.
     * However, the searched string should be displayed, if exists, on the first result page.
     * @param rowName
     */
    public void selectRowByNameOnFirstResultsPage(String rowName) {
        for (MobileElement row : searchResultsList) {
            MobileElement rowNameInResult;
            if (row.isDisplayed()) {
                try {
                    rowNameInResult = row.findElement(By.cssSelector(rowNameCss));
                } catch (NoSuchElementException e) {
                    // In case the last row is hidden behind the Continue button.
                    ScrollHelper.scrollDown(driver);
                    rowNameInResult = row.findElement(By.cssSelector(rowNameCss));
                }
                if (rowNameInResult.getText().toLowerCase().contains(rowName.toLowerCase())) {
                    row.click();
                    return;
                }
            }
        }
        throw new NoSuchElementException("No item named '" + rowName + "' found in the list.");
    }
    /**
     * The search method will search for the specified string and generate result.
     * @param searchStr
     */
    public void search(String searchStr) {
        typableSearchBar.sendKeys(searchStr);
    }
}
