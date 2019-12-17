package br.com.sicredi.pageobjects;

import org.openqa.selenium.WebDriver;
import utils.commons.PropertiesManager;

public class HomePage extends BasePage {

    private static final String BASEURL = PropertiesManager.getInstance().getProperty("baseurl");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        driver.get(BASEURL);
        return this;
    }
}
