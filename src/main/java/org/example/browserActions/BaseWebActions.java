package org.example.browserActions;

import org.example.baseDriver.BaseWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class BaseWebActions extends BaseWeb {
    public static void enterURL(String URL) {
        driver.get(URL);
    }

    //Method for selecting the dropdown values
    public static void SelectUsingValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }


    public static void enterText(By inputWebElement, String inputText) {
        explicitWaitForElementClickable(inputWebElement).clear();
        explicitWaitForElementClickable(inputWebElement).sendKeys(inputText);
    }

    // Method to wait and click on the web element
    public static void clickOnWebElement(By clickWebElement) {
        explicitWaitForElementClickable(clickWebElement).click();
    }

    // Method to text from web element from the UI
    public static String getTextFromWebElement(By textWebElement) {
        explicitWaitForElement(textWebElement);
        WebElement txt = getElement(textWebElement);
        String actualText = txt.getText();
        return actualText;
    }
    //Method for closing open browsers
    public static void closeBrowser() {
        driver.close();
    }

    //Method for implicit wait
    public static void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //Method for explicit wait
    public static void explicitWaitForElement(By ele) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
    }

    //Method for wait for element to be  clickable and return thn web element
    public static WebElement explicitWaitForElementClickable(By ele) {
        WebElement wb;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wb = wait.until(ExpectedConditions.elementToBeClickable(ele));
        return wb;
    }
// Method to get the web element from the BY identifiers
    public static WebElement getElement(By locator) {
        if (IsElementPresentQuick(locator))
            return driver.findElement(locator);
        try {
            throw new NoSuchElementException("Element Not Found : " + locator);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static boolean IsElementPresentQuick(By locator) {
        boolean flag = driver.findElements(locator).size() >= 1;
        return flag;
    }

}
