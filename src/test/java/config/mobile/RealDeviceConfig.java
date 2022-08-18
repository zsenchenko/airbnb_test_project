package config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/realDevice.properties"})
public interface RealDeviceConfig extends Config {

    String localURL();

    String platform();

    String device();

    String os_version();

}