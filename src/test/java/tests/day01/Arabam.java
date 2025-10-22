package tests.day01;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Arabam {
    WebElement logoArabam;
    AndroidDriver<AndroidElement> driver;
    WebElement ilanAraButon;
    WebElement wolksVagenArabaButon;

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

      //  Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

//uygulamanın basarılı birşekilde açıldıgı dogrulanır

       logoArabam=driver.findElementById("com.dogan.arabam:id/ivArabamLogo");
        Assert.assertTrue(logoArabam.isDisplayed());

//

        ilanAraButon=driver.findElementByXPath("//*[@text='İlan Ara']");
        Thread.sleep(3000);
        ilanAraButon.click();



//NOT notasyonların aynı dependency den geldiğinden emin ol ...mesela biri tetng den diğeri junitten olursa hata verecektir

//Kategori olarak kiralık araç secilir

 WebElement kiralikAracButon=driver.findElementByXPath("//*[@text='Kiralık Araçlar']");
 kiralikAracButon.click();

 //Arac olarak Minivan&Panelvan secilir
  WebElement minivanPanelvanButon=driver.findElementByXPath("//*[@text='Minivan & Panelvan']");
  Thread.sleep(1000);
  minivanPanelvanButon.click();

 //Arac markası olarak mercedes Benz secilir

WebElement mercedesBenzButton= driver.findElementByXPath("//*[@text='Mercedes - Benz']");
mercedesBenzButton.click();

//vito secilir

        WebElement vitoButon=driver.findElementByXPath("//*[@text='Vito']");
         vitoButon.click();

//listenin geldigi dogrulanır

WebElement aracSayisiListe=driver.findElementById("com.dogan.arabam:id/texViewSubtitle");

String aracSaysisi= aracSayisiListe.getText().replaceAll("\\D","");

int aracSay=Integer.parseInt(aracSaysisi);

Assert.assertTrue((aracSay>0));


    }


    @Test
    public void test02Arabam() throws InterruptedException {

     //uygulamanın basarılı bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
     //uygulamanın basarili bir sekilde acildigi dogrulanir
        logoArabam=driver.findElementById("com.dogan.arabam:id/ivArabamLogo");

        Thread.sleep(1000);
        Assert.assertTrue(logoArabam.isDisplayed());
     //alt menuden ilan ara butonuna tıklanir
       // Thread.sleep(1500);
         ilanAraButon=driver.findElementByXPath("//*[@text='İlan Ara']");
         ilanAraButon.click();
     //kategori olarak otomabil secilir
       WebElement otomobilKategoriButon=driver.findElementByXPath("//*[@text='Otomobil']");
       otomobilKategoriButon.click();
//arac olarak Volkswagen secilir
        Thread.sleep(1500);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(530,1830)).
        waitAction(WaitOptions.waitOptions(Duration.ofMillis(80))).
        moveTo(PointOption.point(530,400)).release().perform();
//Başlangıc noktasıyla bitis noktası arasındaki gecen sure (wait action)
//eger sure azalırsa; gidilen yol mesafesi artareger sureyi arttırısak gidilen yol mesafesş AZALIR
//yani tamamen bir ters oranti vardir.ekranda daha fazla asagi ya da yukari gitmek istiyorsak birim zamanda bekleme süresi az olmalı
wolksVagenArabaButon=driver.findElementByXPath("//*[@text='Volkswagen']");
wolksVagenArabaButon.click();

     //arac olarak Volkswagen secilir

     //arac markasi olarak passat secilir
//Passat
     //1.4 TSI BlueMotion secilir

     //Paket secimi comfortline yapilir

     //Ucuzdan pahaliya siralama yaparak filtreleme yapilir

     //Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanır



    }


}
