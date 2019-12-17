package br.com.sicredi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.commons.CommonsGenerator;

import java.util.Iterator;
import java.util.List;

public class CustomerPage extends BasePage {


    @FindBy(how = How.CSS, using = "input[class=\"form-control\"]")
    private List<WebElement> formFields;

    @FindBy(how = How.CSS, using = "a[class^=\"chosen-single\"]")
    private WebElement selectFromEmployeer;

    @FindBy(how = How.CSS, using = "li[class^=\"active-result\"]")
    private List<WebElement> employeerDropDown;

    @FindBy(how = How.CSS, using = "#field-creditLimit")
    private WebElement creditLimitField;

    @FindBy(how = How.CSS, using = "#form-button-save")
    private WebElement saveButton;

    @FindBy(how = How.CSS, using = "#save-and-go-back-button")
    private WebElement saveAndGoBackButton;

    @FindBy(how = How.ID, using = "report-success")
    private WebElement successMessage;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public CustomerPage fillForm() {
        Iterator<String> formDataAsIterator = CommonsGenerator.generateFormInfo();

        formFields.forEach(element -> waitForVisibilityOf(element).sendKeys(formDataAsIterator.next()));

        waitForVisibilityOf(selectFromEmployeer).click();
        getEmployeer("Fixter").click();

        waitForVisibilityOf(creditLimitField).sendKeys("200");
        return this;
    }

    public CustomerPage saveForm() {
        waitForVisibilityOf(saveButton).click();
        return this;
    }

    public HomePage saveFormAndGoBack(){
        waitForVisibilityOf(saveAndGoBackButton).click();
        return GeneratePage.homePage();
    }

    public String getSuccessMessage() {
        return waitForVisibilityOf(successMessage).getText();
    }

    private WebElement getEmployeer(String text){
        return employeerDropDown.
                stream().
                filter(element -> waitForVisibilityOf(element).getText().equals(text)).findFirst().
                orElse(null);
    }
}
