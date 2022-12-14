package config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/androidEmulator.properties"})
public interface AndroidEmulatorConfig extends Config {

    String localURL();

    String platform();

    String device();

    String osVersion();

    String userLogin();

    String userPassword();
}
