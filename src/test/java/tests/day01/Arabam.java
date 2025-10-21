package tests.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Arabam {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUpArabam() throws MalformedURLException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4-T160");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //bu çalıştıgımız app birden fazla sayfadan oluştugu için yeni capabilitiesleri ekledik...aşağıdakileri kastediyotum
        cap.setCapability("appPackage","com.dogan.arabam");
        cap.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);// http://127.0.0.1:4723/wd/hub bu appium server ından gelen yoldur
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    @Test
    public void Arabam() throws InterruptedException {

//uygulamanın basarili bir sekilde yüklendiği dogrulanır

        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

//uygulamanın basarılı birşekilde açıldıgı dogrulanır

      WebElement logoArabam=driver.findElementById("com.dogan.arabam:id/ivArabamLogo");
        Assert.assertTrue(logoArabam.isDisplayed());

//

WebElement ilanAraButon=driver.findElementByXPath("//*[@text='İlan Ara']");
Thread.sleep(3000);
ilanAraButon.click();




    }


}
