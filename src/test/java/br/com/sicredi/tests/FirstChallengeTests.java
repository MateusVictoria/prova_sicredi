package br.com.sicredi.tests;

import br.com.sicredi.pageobjects.CustomerPage;
import br.com.sicredi.pageobjects.GeneratePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstChallengeTests extends TestBase {

    @Test
    public void openHomePage() {

        CustomerPage customerPage = GeneratePage.homePage().
                goToHomePage().
                selectTheme().
                goToCustomerPage().
                fillFormAndSave();

        Assert.assertTrue(customerPage.getSuccessMessage().contains("Your data has been successfully stored into the database."));
            }

//    @Test
//    public void openHomePage2(){
//        HomePage homePage = GeneratePage.homePage().goToHomePage();
//        Assert.assertEquals(homePage.pageTitle(), "https://www.grocerycrud.com/demo/bootstrap_theme");
//
//    }
}
