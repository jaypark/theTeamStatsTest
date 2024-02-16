package utils;

import enums.TeamPageSubMenu;
import helper.ScrollHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Common utilities that can be helpful in any context.
 */
public class CommonUtils {

    /**
     * Explicit wait method.
     * Sometimes, we have to do a hard wait for certain page to load.
     * Use this method very sparingly.
     * @param time
     */
    public static void waitInMillisec(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wait for a specified element to be visible, in given amount of time.
     * @param driver
     * @param elem
     * @param waitTime
     */
    public static void waitForElementToBeVisible(AppiumDriver<MobileElement> driver, MobileElement elem, long waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    /**
     * Wait for a specified element to be visible, in default amount of time.
     * @param driver
     * @param elem
     */
    public static void waitForElementToBeVisible(AppiumDriver<MobileElement> driver, MobileElement elem) {
        waitForElementToBeVisible(driver, elem, TimeUtils.WAIT_DURATION_IN_SEC);
    }
}
