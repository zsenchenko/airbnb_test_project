package drivers.mobile;

import config.mobile.BrowserstackConfig;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", bsConfig.login());
        mutableCapabilities.setCapability("browserstack.key", bsConfig.password());

        mutableCapabilities.setCapability("app", bsConfig.appURL());

        mutableCapabilities.setCapability("device", bsConfig.device());
        mutableCapabilities.setCapability("os_version", bsConfig.osVersion());

        mutableCapabilities.setCapability("project", "Airbnb test project");
        mutableCapabilities.setCapability("build", "browserstack-build-5");
        mutableCapabilities.setCapability("name", "airbnb tests");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(bsConfig.baseURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
