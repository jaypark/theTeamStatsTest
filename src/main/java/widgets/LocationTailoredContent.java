package widgets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TimeUtils;

import static utils.TimeUtils.WAIT_DURATION_IN_SEC;

@Getter
public class LocationTailoredContent {

    @FindBy(id = "com.fivemobile.thescore:id/btn_allow")
    private MobileElement allowLocationBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Tailored Content']")
    private MobileElement locationTitle;

    public LocationTailoredContent(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, TimeUtils.WAIT_DURATION_IN_SEC);
        // verify we are on the correct page, and wait for the page to load.
        wait.until(ExpectedConditions.visibilityOf(locationTitle));
    }
}

