package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class testParalllel {
      public static DesiredCapabilities capabilities;
      public AndroidDriver<MobileElement> driver;
      String PKG;
      
      @BeforeTest(alwaysRun=true)
      @Parameters({"port","device"})
      public void setupCapabilities(String port, String device) throws MalformedURLException, InterruptedException {
/*            if (Device_ID.equalsIgnoreCase("emulator-5554")) {
                   setcapabilities("com.android.dialer", "DialtactsActivity",Device_ID);
            }
            if (Device_ID.equalsIgnoreCase("yourdeviceID")) {
                   capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                   capabilities.setCapability("deviceName", Device_ID);
                   capabilities.setCapability("automationName", "Appium");
                   capabilities.setCapability("platformName", "ANDROID");
                   capabilities.setCapability("udid", Device_ID);
            }*/
            
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capabilities.setCapability(MobileCapabilityType.APP, PKG);
            driver = new AndroidDriver<>(new URL("http://localhost:"+port+"/wd/hub"),capabilities);
            System.out.println("Session ID is...."+driver.getSessionId());
            /*URL = "http://127.0.0.1:4444/wd/hub";
            driver = new AndroidDriver(new URL(URL), capabilities);*/
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      }
      
      
/*      public void setcapabilities(String apppackage, String appActivity,String device) {
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "ANDROID");
            capabilities.setCapability("androidPackage", apppackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("udid", device);
      }*/
      
/*      @Test
      public void calculate() throws Exception {
            Thread.sleep(1000);
             driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();
            Thread.sleep(1000);
             driver.findElement(By.id("com.android.dialer:id/digits")).sendKeys("mobileno.");
            Thread.sleep(1000);
             driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
      }*/
      
      @Test
      public void Sum() throws Exception{

       driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

       driver.findElement(By.name("2")).click();
       driver.findElement(By.name("+")).click();
       driver.findElement(By.name("5")).click();
       driver.findElement(By.name("=")).click();
       
       driver.findElement(By.name("History")).click();
       driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_00")).click();

       // Get result from result text box.
       String result = driver.findElement(By.className("android.widget.EditText")).getText();
       System.out.println("Number sum result is : " + result);

      }
      @AfterTest
      public void TearDown() {
            driver.quit();
      }
}
