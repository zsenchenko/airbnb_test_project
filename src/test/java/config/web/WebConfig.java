package config.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web/browserLocal.properties",
        "classpath:config/web/browserSelenoid.properties"})
public interface WebConfig extends Config {

    String baseURL();

    String userLogin();

    String userPassword();

    String selenoidURL();

    String selenoidLogin();

    String selenoidPassword();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("102")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();
}
