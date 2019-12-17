package br.com.sicredi.tests;

import br.com.sicredi.pageobjects.HomePage;
import org.testng.annotations.Test;

public class FirstChallengeTests extends TestBase {

    @Test
    public void openHomePage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.goToHomePage();
    }
}
