package tests.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukle {

    AndroidDriver<AndroidElement>driver;

    //BU CLASS LARI OLUŞTURURKEN EMULATORDEN OLUŞTURULAN TELEFON
    // VE APPIUM SERVER AÇIK OLMALI ONCELİKLİ OLARAK
//APK nın ismi Turkçe karakter içermemeli ve noktadan sonra boşluk olmamalı
//yani şöyle olmalı Calculator_8.4 (503542421)_Apkpure (3).apk bu doğru bir kullanım

    @Test
    public void ApkYukle() throws MalformedURLException {

        //buraya testler yazılacak ama class seviyesinde hemen driver oluşturulu....
        DesiredCapabilities cap=new DesiredCapabilities();
       cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4-T160");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
       cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
       // cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\Hp\\IdeaProjects\\Team161_Appium\\Apss\\Calculator_8.4 (503542421)_Apkpure (3).apk");
      //  cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\Hp\\IdeaProjects\\Team161_Appium\\Apss\\Apk Bilgisi_2.3.4_apkcombo.com.apk");
        cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\Hp\\IdeaProjects\\Team161_Appium\\Apss\\arabam-com-5-4-1.apk");

////27 satırdaki desiredcap i test yapacağımız uygulamayı telefona yüklemek için yaptık...
//yüklü ise açer yüklü değilse yükler çok güzel bir özellik yani süper...

//***************************ŞİMDİ DRİVER AYARLARINA GELİYORUZ..

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);// http://127.0.0.1:4723/wd/hub bu appium server ından gelen yoldur
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
}
