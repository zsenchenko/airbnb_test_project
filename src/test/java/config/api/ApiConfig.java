package config.api;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/api/api.properties"})
public interface ApiConfig extends Config {
    String xCsrfToken();

    String apiKey();

    String airbedSessionId();

    String aat();

    String csrfToken();
}
