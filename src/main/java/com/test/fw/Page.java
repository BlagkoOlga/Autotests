package com.test.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

/**
 * Created by admin on 31.10.14.
 */
public class Page {
    protected ApplicationManager manager;
    protected WebDriver driver;
    public boolean acceptNextAlert = true;

    public Page (ApplicationManager manager)
    {
        this.manager = manager;
        this.driver = manager.driver;

    }

    public boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public String closeAlertAndGetItsText()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            if (acceptNextAlert)
            {
                alert.accept();
            }
            else
            {
                alert.dismiss();
            }
            return alert.getText();
        }
        finally
        {
            acceptNextAlert = true;
        }
    }

    protected void type(By locator, String text)
    {
        if (text != null)
        {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator)
    {
        driver.findElement(locator).click();
    }

    protected void selectByText(By locator, String text)
    {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }
}
