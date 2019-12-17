package br.com.sicredi.tests;


import br.com.sicredi.tests.listeners.TestListener;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.drivers.TLDriverFactory;


@Listeners({TestListener.class})
public class TestBase {
    private static final Object lock = new Object();

    @BeforeClass(description = "Downloading and Setting browser drivers")
    @Parameters(value = {"driverClass"})
    public void setupDrivers(String driverClass) {
        if (driverClass.equals("ChromeDriver")){
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (driverClass.equals("FirefoxDriver")){
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        }
    }


    @BeforeMethod(description = "Configuring drivers")
    @Parameters(value = {"browser"})
    public void setup(@Optional String browser) {
        synchronized (lock) {
            TLDriverFactory.setTLDriver(browser);
            TLDriverFactory.getTLDriver().manage().window().maximize();
        }
    }

    @AfterMethod(description = "Quitting drivers and removing ThreadLocal varibles")
    public void teardown() {
        synchronized (lock) {
            TLDriverFactory.getTLDriver().quit();
            TLDriverFactory.flushTLDriver();
        }
    }

    public WebDriver getDriver() {
        return TLDriverFactory.getTLDriver();
    }

}