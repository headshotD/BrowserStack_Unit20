package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String url();

    @Key("browserstack.app")
    String app();

    @Key("device.android")
    String androidDevice();

    @Key("os.android")
    String androidOsVersion();

    @Key("device.ios")
    String iosDevice();

    @Key("os.ios")
    String iosOsVersion();
}