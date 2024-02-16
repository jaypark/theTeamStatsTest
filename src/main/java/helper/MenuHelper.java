package helper;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * All Menu-related functionalities.
 */
public class MenuHelper extends BasePage {

    public final String subMenuShovelerXpath = "//android.widget.HorizontalScrollView[@resource-id='com.fivemobile.thescore:id/tabLayout']/android.widget.LinearLayout";
    public final String subMenuXpath = "//android.widget.HorizontalScrollView[@resource-id='com.fivemobile.thescore:id/tabLayout']/" +
            "descendant::*/android.widget.TextView[@text='%s']";

    public MenuHelper(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Navigate to the specified sub menu on the Team page.
     * TODO: Implement scroll right on the menu shoveler to the end when necessary.
     *      Currently, only scrolls to the right once if the menu item is not found on the current screen.
     * @param subMenu - Any menu-related Enum value to be passed
     */
    public <T extends Enum<T> & EnumHandler> void goToSubMenu(T subMenu) {
        MobileElement menu;
        try {
            menu = driver.findElement(By.xpath(String.format(subMenuXpath, subMenu.getDisplayedMenuName())));
        } catch (NoSuchElementException e) {
            // In case the menu item is beyond the current screen.
            MobileElement subMenuShoveler = driver.findElement(By.xpath(subMenuShovelerXpath));
            ScrollHelper.scrollRightOnShoveler(driver, subMenuShoveler);
            menu = driver.findElement(By.xpath(String.format(subMenuXpath, subMenu.getDisplayedMenuName())));
        }
        menu.click();
    }
}
