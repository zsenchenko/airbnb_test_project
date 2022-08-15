package drivers;

import config.mobile.AndroidEmulatorConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidEmulatorMobileDriver implements WebDriverProvider {
    static AndroidEmulatorConfig androidEmulatorConfig = ConfigFactory.create(AndroidEmulatorConfig.class, System.getProperties());


    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        Configuration.browserSize = null;

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setCapability("uiautomator2ServerInstallTimeout", 90000);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(androidEmulatorConfig.platform());
        options.setDeviceName(androidEmulatorConfig.device());
        options.setPlatformVersion(androidEmulatorConfig.os_version());
        options.setApp(getApk().getAbsolutePath());
        options.setAppPackage("com.airbnb.android");
//        options.setAppActivity("com.airbnb.android.activities.MainActivity");
        options.setAppActivity("com.airbnb.android.feat.homescreen.HomeActivity");

        try {
            return new AndroidDriver(new URL(androidEmulatorConfig.localURL()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

        private File getApk() {
           // return new File("src/test/resources/apps/Airbnb+18.43.apk");
            return new File("src/test/resources/apps/Airbnb_v22.31_apkpure.com.apk");
        }

}
