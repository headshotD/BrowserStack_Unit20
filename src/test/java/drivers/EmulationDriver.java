package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulationConfig;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulationDriver implements WebDriverProvider {

    private static final EmulationConfig config = ConfigFactory.create(EmulationConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options caps = new UiAutomator2Options();

        String platform = System.getProperty("platform", "emulation");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("emulation.url", config.url());
        caps.setCapability("emulation.device.name", config.emulationDevice());
        caps.setCapability("emulation.os", config.emulationOsVersion());
        caps.setCapability("emulation.app.path", new File(config.appPath()).getAbsolutePath());
        caps.setCapability("emulation.setAppPackage", config.emulationSetAppPackage());
        caps.setCapability("emulation.setAppActivity", config.emulationSetAppActivity());
        caps.setCapability("emulation.automation.name", config.automationName());

        try {
            return new RemoteWebDriver(new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL", e);
        }
    }
}