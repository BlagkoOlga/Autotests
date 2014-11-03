package com.test.result;
import com.test.fw.ApplicationManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Created by admin on 31.10.14.
 */
public class Tests{
    protected ApplicationManager app = new ApplicationManager();

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) throws Exception
    {
        if(browser.equalsIgnoreCase("firefox"))
        {
            app.driver = new FirefoxDriver();
        }

        else if(browser.equalsIgnoreCase("chrome"))
        {

            System.setProperty("webdriver.chrome.driver", "./src/resourses/chromedriver");
            app.driver = new ChromeDriver();
        }
        //app.driver = new FirefoxDriver();
        String baseUrl = "http://www.openforbeta.com";
        app.driver.get(baseUrl);
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @AfterTest
    public void tearDown() throws Exception
    {
        app.driver.quit();

    }



   @Test
    public void correctLogin() {

        app.getIndexPage().openLoginForm();
        app.getIndexPage().fillLoginForm();
        app.getIndexPage().submitLogin();
        Assert.assertTrue(app.getHomePage().assertPage(), "User is login");
       app.getHomePage().logout();

    }

    @Test
    public void incorrectRegistration(){
        app.getIndexPage().openRegistrationForm();
        app.getRegistrationPage().fillRegistrationForm();
        app.getRegistrationPage().inputRandomCaptcha();
        app.getRegistrationPage().submitRegistration();
     //   Assert.assertEquals(app.getRegistrationPage().getErrorText(), "Error: Image code wrong, please try again.");
        Assert.assertTrue(app.getRegistrationPage().textPresent(), "User doesn't registrated");

    }
}
