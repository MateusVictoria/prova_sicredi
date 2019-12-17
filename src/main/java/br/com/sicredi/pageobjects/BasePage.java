package br.com.sicredi.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;


    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected Boolean waitForSpinnerToBeGone() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class=\"Loader__Container-sc-1salt4h-0 ektexx\"]")));
    }

    private WebElement waitVisibility(WebElement element) {
        wait.until(driverLambda -> element.isDisplayed());
        wait.until(driverLambda -> element.isEnabled());
        return element;
    }

    protected void click(WebElement element) {
        try {
            waitVisibility(element).click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            waitForSpinnerToBeGone();
            waitVisibility(element).click();
        }
    }

    protected void writeText(WebElement element, String text) {
        waitVisibility(element).sendKeys(text);
    }

    protected String readText(WebElement element) {
        waitForSpinnerToBeGone();
        return waitVisibility(element).getText();
    }

}
