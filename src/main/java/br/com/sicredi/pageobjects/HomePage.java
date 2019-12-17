package br.com.sicredi.pageobjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
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

    @FindBy(how = How.CSS, using = "a[class=\"btn btn-primary search-button t5\"]")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = "input[name=\"search\"]")
    private WebElement searchField;

    @FindBy(how = How.CSS, using = "input[class=\"select-all-none\"]")
    private WebElement selectAllCheckbox;

    @FindBy(how = How.CSS, using = "span[data-growl=\"message\"]")
    private WebElement popUpMessages;

    @FindBy(how = How.CSS, using = "div[class=\"container-fluid gc-container loading-opacity\"]")
    private WebElement loadingState;

    @FindBy(how = How.CSS, using = "a[class=\"btn btn-outline-dark delete-selected-button\"]")
    private WebElement deletePopUpButton;

    @FindBy(how = How.CSS, using = "p[class=\"alert-delete-multiple-one\"]")
    private WebElement deleteWarning;

    @FindBy(how = How.CSS, using = "button[class=\"btn btn-danger delete-multiple-confirmation-button\"]")
    private WebElement deleteButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        driver.get(BASEURL);
        return this;
    }

    public HomePage selectTheme() {
        waitForClickabilityOf(themeSelector).click();
        waitForClickabilityOf(themeV4).click();
        return this;
    }

    public CustomerPage goToCustomerPage() {
        waitForClickabilityOf(addCustomerButton).click();
        return GeneratePage.customerPage();
    }

    public HomePage searchForUser() {
        waitForVisibilityOf(popUpMessages);
        waitForClickabilityOf(searchButton).click();
        waitForVisibilityOf(searchField).sendKeys("Teste Sicredi" + Keys.RETURN);
        return this;
    }

    public HomePage selectAll(){
        try {
            waitForVisibilityOf(selectAllCheckbox).click();
        } catch (ElementClickInterceptedException e){
            waitForInvisibilityOf(loadingState);
            selectAllCheckbox.click();
        }
        return this;
    }

    public HomePage openDeletePopUp() {
        waitForVisibilityOf(deletePopUpButton).click();
        return this;
    }

    public String getDeleteWarningMessage() {
        return waitForVisibilityOf(deleteWarning).getText();
    }

    public HomePage deleteEntries() {
        waitForClickabilityOf(deleteButton).click();
        waitForInvisibilityOf(popUpMessages);
        return this;
    }

    public String getSuccessfulDeleteMessage(){
        return waitForVisibilityOf(popUpMessages).getText();
    }

}
