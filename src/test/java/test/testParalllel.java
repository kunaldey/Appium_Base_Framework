package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testParalllel {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      AppiumDriver driver;
      String URL;
      @Parameters("Device_ID")
      @BeforeTest
      public void setupCapabilities(String Device_ID) throws Exception {
            if (Device_ID.equalsIgnoreCase("emulator-5554")) {
                   setcapabilities("com.android.dialer", "DialtactsActivity",Device_ID);
            }
            if (Device_ID.equalsIgnoreCase("yourdeviceID")) {
                   capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                   capabilities.setCapability("deviceName", Device_ID);
                   capabilities.setCapability("automationName", "Appium");
                   capabilities.setCapability("platformName", "ANDROID");
                   capabilities.setCapability("udid", Device_ID);
            }
            URL = "http://127.0.0.1:4444/wd/hub";
            driver = new AndroidDriver(new URL(URL), capabilities);
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      }
      public void setcapabilities(String apppackage, String appActivity,String device) {
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "ANDROID");
            capabilities.setCapability("androidPackage", apppackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("udid", device);
      }
      @Test
      public void dial() throws Exception {
            Thread.sleep(1000);
             driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();
            Thread.sleep(1000);
             driver.findElement(By.id("com.android.dialer:id/digits")).sendKeys("mobileno.");
            Thread.sleep(1000);
             driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
      }
      @AfterTest
      public void TearDown() {
            driver.quit();
      }
}
