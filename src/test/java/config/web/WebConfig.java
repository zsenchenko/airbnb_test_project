package config.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/web/browserLocal.properties",
        "classpath:config/web/browserSelenoid.properties"})
public interface WebConfig extends Config {
    String baseURL();

    String userLogin();

    String userPassword();

    String selenoidURL();

    String selenoidLogin();

    String selenoidPassword();

    String browser();

    String browserVersion();

    String browserSize();
}
