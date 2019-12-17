package br.com.sicredi.tests;

import br.com.sicredi.pageobjects.CustomerPage;
import br.com.sicredi.pageobjects.GeneratePage;

import br.com.sicredi.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengeTests extends TestBase {

    @Test(priority = 2)
    public void firstChallenge() {

        CustomerPage customerPage = GeneratePage.homePage().
                goToHomePage().
                selectTheme().
                goToCustomerPage().
                fillForm().
                saveForm();

        Assert.assertEquals(customerPage.getSuccessMessage(), "Your data has been successfully stored into the database. Edit Customer or Go back to list");
    }

    @Test(priority = 1)
    public void secondChallenge() {
        HomePage homePage = GeneratePage.homePage().
                goToHomePage().
                selectTheme().
                goToCustomerPage().
                fillForm().
                saveFormAndGoBack().
                searchForUser().
                selectAll().
                openDeletePopUp();

        Assert.assertEquals(homePage.getDeleteWarningMessage(), "Are you sure that you want to delete this 1 item?");

        homePage.deleteEntries();

        Assert.assertEquals(homePage.getSuccessfulDeleteMessage(), "Your data has been successfully deleted from the database.");
    }
}
