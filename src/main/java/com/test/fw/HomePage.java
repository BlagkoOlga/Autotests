package com.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 02.11.14.
 */
public class HomePage extends Page {


    public HomePage(ApplicationManager manager) {
        super(manager);
    }

    public boolean assertPage() {
        return isElementPresent(By.xpath(".//div[@class='loginlink navigation']"));
    }

    public void logout() {
        WebElement element = driver.findElement(By.xpath(".//div[@class='loginlink navigation']/*/li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
      //click(By.xpath(".//div[@class='loginlink navigation']/*/li"));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //click(By.linkText("Logout"));
      click(By.xpath(".//a[@href='http://www.openforbeta.com/log_out']"));
    }
}
