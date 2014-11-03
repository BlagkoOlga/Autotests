package com.test.fw;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


/**
 * Created by admin on 31.10.14.
 */
public class ApplicationManager {

    public WebDriver driver;


    private RegistrationPage registrationPage;
    private HomePage homePage;
    private IndexPage indexPage;


    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage(this);
        }
        return registrationPage;
    }

    public IndexPage getIndexPage() {
        if (indexPage == null) {
            indexPage = new IndexPage(this);
        }
        return indexPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(this);
        }
        return homePage;
    }



}
