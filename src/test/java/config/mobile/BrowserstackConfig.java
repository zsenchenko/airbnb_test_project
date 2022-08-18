package config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String login();

    @Key("browserstack.key")
    String password();

    @Key("app")
    String appURL();

    String device();

    String os_version();

    String baseURL();

}

