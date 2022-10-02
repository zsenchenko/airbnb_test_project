package drivers.mobile;

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
    static AndroidEmulatorConfig config = ConfigFactory.create(AndroidEmulatorConfig.class, System.getProperties());


    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        Configuration.browserSize = null;

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setCapability("uiautomator2ServerInstallTimeout", 90000);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(config.platform());
        options.setDeviceName(config.device());
        options.setPlatformVersion(config.osVersion());
        options.setApp(getApk().getAbsolutePath());
        options.setAppPackage("com.airbnb.android");
        options.setAppActivity("com.airbnb.android.feat.homescreen.HomeActivity");

        try {
            return new AndroidDriver(new URL(config.localURL()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

        private File getApk() {
            return new File("src/test/resources/apk/Airbnb_v22.31_apkpure.com.apk");
        }
}
