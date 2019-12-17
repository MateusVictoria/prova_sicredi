package br.com.sicredi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.commons.PropertiesManager;

public class HomePage extends BasePage {

    private static final String BASEURL = PropertiesManager.getInstance().getProperty("baseurl");

    @FindBy(how = How.CSS, using = "select[class=\"switch-version\"]")
    private WebElement themeSelector;

    @FindBy(how = How.CSS, using = "option[value=\"bootstrap_theme_v4\"]")
    private WebElement themeV4;

    @FindBy(how = How.CSS, using = "a[href=\"/demo/bootstrap_theme_v4/add\"]")
    private WebElement addCustomerButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        driver.get(BASEURL);
        return this;
    }

    public HomePage selectTheme() {
        waitForVisibilityOf(themeSelector).click();
        waitForVisibilityOf(themeV4).click();
        return this;
    }

    public CustomerPage goToCustomerPage() {
        waitForClickabilityOf(addCustomerButton).click();
        return GeneratePage.customerPage();
    }

    public String pageTitle() {
        return driver.getCurrentUrl();
    }
}
