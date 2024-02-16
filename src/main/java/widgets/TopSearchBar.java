package widgets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

@Getter
public class TopSearchBar {

    @FindBy(id = "com.fivemobile.thescore:id/search_bar_text_view")
    private MobileElement searchBar;

    public TopSearchBar(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        CommonUtils.waitForElementToBeVisible(driver, searchBar);
    }
}

