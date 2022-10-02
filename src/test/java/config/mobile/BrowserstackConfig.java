package config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("browserstackUser")
    String login();

    @Key("browserstackKey")
    String password();

    @Key("app")
    String appURL();

    String device();

    String osVersion();

    String baseURL();
}

