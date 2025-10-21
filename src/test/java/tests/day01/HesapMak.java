package tests.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMak {

//uygulamanın yuklendigini dogrular
//uygulamanın acıldıgını dogrular
//

    AndroidDriver<AndroidElement> driver;
    //onceden tek bir driver vardı.o da appiumDriver di. zamanla appium kendini geliştirdi
    //android için ayrı ios icin ayrı özellikleri bulunan driverlar uretti.IOSDriver<IOSElement>iosDriver;

    @Test
    public void HesapMak() throws MalformedURLException {
        // kullanici gerekli kurulumu yapar

        DesiredCapabilities cap=new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4-T160");
       cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
       cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\Hp\\IdeaProjects\\Team161_Appium\\Apss\\Calculator_8.4 (503542421)_Apkpure (3).apk");

//27 satırdaki desiredcap i test yapacağımız uygulamayı telefona yüklemek için yaptık...
//yüklü ise açar yüklü değilse yükler çok güzel bir özellik yani süper...

//***************************ŞİMDİ DRİVER AYARLARINA GELİYORUZ..

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);// http://127.0.0.1:4723/wd/hub bu appium server ından gelen yoldur
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//uygulamanın yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
//bundleid bulunacak

//uygulamanın açıldıgı dogrulanır

        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/op_sqrt").isDisplayed());

//400 un 3 katının 1200 oldgunu hesap makinesinden dogrulayın

 driver.findElementByAccessibilityId("4").click();
 driver.findElementByAccessibilityId("0").click();
 driver.findElementByAccessibilityId("0").click();
 driver.findElementByAccessibilityId("multiply").click();
 driver.findElementByAccessibilityId("3").click();

 int  expectedSonuc=1200;
 String actualSonuc=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
 Assert.assertEquals(expectedSonuc,Integer.parseInt(actualSonuc));


    }


}
