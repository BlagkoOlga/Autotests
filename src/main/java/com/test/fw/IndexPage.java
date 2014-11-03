package com.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 31.10.14.
 */
public class IndexPage extends Page {


    public IndexPage(ApplicationManager manager) {
        super(manager);
    }

    public void openLoginForm() {

        click(By.linkText("Login"));
    }

    public void fillLoginForm() {

        type(By.xpath(".//input[@name='lusername']"), "zasx");
        type(By.xpath(".//input[@name='lpassword']"), "123456");

    }

    public void submitLogin() {
        click(By.xpath(".//em"));
    }

    public void openRegistrationForm() {
        click(By.linkText("Signup"));
    }

}
