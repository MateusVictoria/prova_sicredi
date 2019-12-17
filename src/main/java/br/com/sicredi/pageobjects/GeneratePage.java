package br.com.sicredi.pageobjects;

import org.openqa.selenium.support.PageFactory;
import utils.drivers.TLDriverFactory;

public class GeneratePage {

    private GeneratePage(){
        throw new IllegalStateException("GeneratePage cannot be instantiated");
    }

    private static synchronized <T extends BasePage> T instantiateNewPage(Class<T> tClass) {
        return PageFactory.initElements(TLDriverFactory.getTLDriver(), tClass);
    }

    public static HomePage homePage() {
        return instantiateNewPage(HomePage.class);
    }

    public static CustomerPage customerPage() {
        return instantiateNewPage(CustomerPage.class);
    }

}