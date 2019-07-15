package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase
{
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";


    @Override
    protected void setUp() throws Exception
    {
        super.setUp(); // использовать setUp из TestCase
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("orientation", "PORTRAIT"); // всегда начинать тесты с портретной ориентации
        capabilities.setCapability("app",System.getProperty("user.dir") + "/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }


    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();

        super.tearDown(); // использовать tearDown из TestCase
    }


    protected void rotateToPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }


    protected void rotateToLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }


    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(seconds);
    }
}
