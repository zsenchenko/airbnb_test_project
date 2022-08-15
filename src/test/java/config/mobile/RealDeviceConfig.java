package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/realDevice.properties"})
public interface RealDeviceConfig extends Config{
    @Key("localURL")
    String localURL();

    @Key("platform")
    String platform();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

}