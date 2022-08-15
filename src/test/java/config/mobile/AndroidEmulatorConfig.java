package config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/androidEmulator.properties"})
public interface AndroidEmulatorConfig extends Config {
    @Key("localURL")
    String localURL();

    @Key("platform")
    String platform();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();
}
