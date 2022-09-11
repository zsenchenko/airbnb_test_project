package config.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web/selenoid.properties"})
public interface WebConfig extends Config {
    String baseUrl();

    String userLogin();

    String userPassword();

    String selenoidUrl();

    String selenoidLogin();

    String selenoidPassword();

    String browser();

    String browserVersion();

    String browserSize();
}
