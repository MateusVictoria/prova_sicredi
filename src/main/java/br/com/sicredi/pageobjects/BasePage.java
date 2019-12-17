package br.com.sicredi.pageobjects;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;


    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitForVisibilityOf(WebElement element){
        wait.until(webDriver -> element.isDisplayed());
        return element;
    }

    public WebElement waitForClickabilityOf(WebElement element) {
        wait.until(driverLambda -> element.isDisplayed() && element.isEnabled());
        return element;
    }

    public WebElement waitForInvisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }


}
