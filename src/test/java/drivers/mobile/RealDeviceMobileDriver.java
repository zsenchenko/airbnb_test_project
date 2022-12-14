package drivers.mobile;

import com.codeborne.selenide.WebDriverProvider;
import config.mobile.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class RealDeviceMobileDriver implements WebDriverProvider {
    static RealDeviceConfig realDeviceConfig = ConfigFactory.create(RealDeviceConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(realDeviceConfig.localURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(realDeviceConfig.platform());
        options.setDeviceName(realDeviceConfig.device());
        options.setPlatformVersion(realDeviceConfig.osVersion());
        options.setApp(app.getAbsolutePath());
        options.setAppPackage("com.airbnb.android");
        options.setAppActivity("com.airbnb.android.feat.homescreen.HomeActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appUrl = "https://disk.yandex.ru/d/MCvp5E2ihbGm0Q";
        String appPath = "src/test/resources/apk/Airbnb_v22.31_apkpure.com.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }
}