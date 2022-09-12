package drivers.web;

import com.codeborne.selenide.Configuration;
import config.web.WebConfig;
import org.aeonbits.owner.ConfigFactory;

public class BrowserWebDriver {
    public static WebConfig config = ConfigFactory.create(WebConfig.class);

    public static void configure() {
        Configuration.baseUrl = config.baseURL();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
    }
}
