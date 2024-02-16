package helper;

import enums.ScrollDirection;
import enums.ShovelerScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

/**
 * Various scroll functionalities.
 */
public class ScrollHelper {

    public static void scrollDown(AppiumDriver<MobileElement> driver) {
        scroll(driver, ScrollDirection.DOWN);
    }

    public static void scrollUp(AppiumDriver<MobileElement> driver) {
        scroll(driver, ScrollDirection.UP);
    }

    /**
     * Function to simulate swiping action on the screen. Only scroll up/down are implemented.
     * TODO: Implement scroll right/left functionality.
     * @param driver
     * @param direction
     */
    private static void scroll(AppiumDriver<MobileElement> driver, ScrollDirection direction) {
        // Get the size of the screen
        Dimension size = driver.manage().window().getSize();

        // Define starting and ending points for the swipe gesture
        int startX = size.width / 2;
        int startY;
        int endY;
        if (direction == ScrollDirection.UP) {
            startY = (int) (size.height * 0.8); // 80% of the screen height
            endY = (int) (size.height * 0.2); // 20% of the screen height
        } else {
            // ScrollDirection.RIGHT and ScrollDirection.LEFT not yet implemented.
            // For now, assume this 'else' clause will apply only for ScrollDirection.DOWN.
            startY = (int) (size.height * 0.2); // 20% of the screen height
            endY = (int) (size.height * 0.8); // 80% of the screen height
        }
        // Perform swipe gesture using TouchAction
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    /**
     * Scroll to the right on shoveler.
     * @param driver
     * @param shoveler
     */
    public static void scrollRightOnShoveler(AppiumDriver<MobileElement> driver, MobileElement shoveler) {
        scrollOnShoveler(driver, shoveler, ShovelerScrollDirection.RIGHT);
    }

    /**
     * Swipe right/left function on a shoveler.
     * @param driver
     * @param shoveler
     * @param direction
     */
    private static void scrollOnShoveler(AppiumDriver<MobileElement> driver, MobileElement shoveler, ShovelerScrollDirection direction) {
        int startX;
        int endX;
        // Get the location of the shoveler element
        if (direction == ShovelerScrollDirection.RIGHT) {
            startX = shoveler.getLocation().getX();
            endX = startX + shoveler.getSize().getWidth();
        } else {
            // ShovelerScrollDirection.LEFT
            startX = shoveler.getLocation().getX() + shoveler.getSize().getWidth();
            endX = shoveler.getLocation().getX();
        }
        int startY = shoveler.getLocation().getY();

        // Perform the swipe action
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }
}
