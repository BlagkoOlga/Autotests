package com.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by admin on 31.10.14.
 */
public class RegistrationPage extends Page {
    protected RegistrationData data = new RegistrationData();

    public RegistrationPage(ApplicationManager manager) {
        super(manager);
    }


    public void fillRegistrationForm() {
        type(By.xpath(".//input[@name ='username']"), data.generateUserName(5));
        String password = data.generateRandomAlphaNumeric(6);
        type(By.xpath(".//input[@name ='password']"), password);
        type(By.xpath(".//input[@name ='confirmpassword']"), password);
        type(By.xpath(".//input[@name='email']"), data.generateEmail(5));
    }



    public void inputRandomCaptcha() {
        type(By.xpath(".//input[@name='captcha']"), data.generateRandomNumber(5));
    }

    public void submitRegistration() {
        click(By.xpath(".//input[@type='submit']"));

    }
    public boolean textPresent(){
        return isElementPresent(By.xpath(".//p[@class='pasgood']"));
    }
    public String getErrorText(){
        WebElement element = driver.findElement(By.xpath(".//p[@class='pasgood']"));
        String str = element.getText();
        return str;
    }
}
