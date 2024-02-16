import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import pages.WelcomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected AppiumDriver<MobileElement> driver = null;
    final String propPath = "//resources//config//config.properties";
    final String appUrl = "http://localhost:4723/wd/hub";

    /**
     * Initialize the driver by setting up the necessary desired capabilities.
     * @throws IOException
     */
    @BeforeSuite(alwaysRun = true)
    public void initializeDriver() throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        Properties prop = new Properties();
        String propFilePath = System.getProperty("user.dir") + propPath;
        FileInputStream propFile = new FileInputStream(propFilePath);
        prop.load(propFile);
        propFile.close();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
        cap.setCapability(MobileCapabilityType.APP, prop.getProperty("app"));

        // Create an instance of the AppiumDriver
        try {
            driver = new AndroidDriver<>(new URL(appUrl), cap);
            new WelcomePage(driver); // wait for the Welcome Page to appear.
        } catch (MalformedURLException e) {
            throw new RuntimeException("App cannot be found");
        }

        // Set global implicit wait to 10 sec.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
