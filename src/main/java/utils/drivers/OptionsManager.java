package utils.drivers;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class OptionsManager {

    private OptionsManager() {
        throw new IllegalStateException("OptionsManager class");
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions geckoOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        geckoOptions.addArguments("--headless");
        geckoOptions.setCapability("marionette", true);
        geckoOptions.setLogLevel(FirefoxDriverLogLevel.ERROR);
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        geckoOptions.setCapability(FirefoxDriver.PROFILE, profile);
        return geckoOptions;
    }

}
