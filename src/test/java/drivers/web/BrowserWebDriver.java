package drivers.web;

import com.codeborne.selenide.Configuration;
import config.web.WebConfig;
import org.aeonbits.owner.ConfigFactory;

public class BrowserWebDriver {
    public static WebConfig config = ConfigFactory.create(WebConfig.class);

    public static void configure() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
    }
}
