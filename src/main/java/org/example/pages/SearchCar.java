package org.example.pages;

import org.example.baseDriver.BaseWeb;
import org.example.browserActions.BaseWebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchCar extends BaseWeb {
    List<String> values = new ArrayList<>();

    private static class GUIMap {
        static By motors = By.xpath("//a[text()=' Motors ']");
        static By used = By.xpath("//tg-tab-heading[text()=' Used ']");
        static By Make = By.xpath("//select[@name='selectedMake']");
        static By model = By.xpath("//select[@name='searchParams.model']");
        static By bodyDropDown = By.xpath("//div[@class='tm-motors-search-bar__dropdown-multi-select']");
        static By searchButton = By.xpath("//button[text()=' Search ']");
        static By searchTextField = By.xpath("//input[@name='keyword']");

        static By searchCount = By.xpath("//tm-search-header-result-count//h3");
        //static By ClickSearchResult = By.xpath("//tg-sticker2-wrapper[@class='o-sticker2-positioner']");
        static By ClickSearchResult = By.xpath("//div[@class='tm-motors-search-card__wrapper ng-star-inserted']");
        static By getResultSize = By.xpath("//tg-tag[@class='tm-motors-vehicle-attributes__tag o-tag ng-star-inserted']//div");

        public static By validateResults(int index) {
            return By.xpath("(//tg-tag[@class='tm-motors-vehicle-attributes__tag o-tag ng-star-inserted']//div)[" + index + "]");
        }

        public static By selectBodyType(String data) {
            return By.xpath("//span[text()=' " + data + " ']");
        }
    }


    public void launchApplication() {
        driver = BaseWeb.selectBrowser("Chrome");
        BaseWebActions.enterURL("https://www.trademe.co.nz/a/");
    }

    public void navigateToMotors() throws InterruptedException {
        Thread.sleep(2000);
        BaseWebActions.clickOnWebElement(GUIMap.motors);
    }

    public void clickOnUsed() throws InterruptedException {
        Thread.sleep(2000);
        BaseWebActions.clickOnWebElement(GUIMap.used);
    }

    public void selectMake(String Value) throws InterruptedException {
        Thread.sleep(2000);
        BaseWebActions.SelectUsingValue(GUIMap.Make, Value);
    }

    public void selectModel(String Value) throws InterruptedException {
        Thread.sleep(2000);
        BaseWebActions.SelectUsingValue(GUIMap.model, Value);
    }

    public void selectBodyType(String Value) throws InterruptedException {
        Thread.sleep(2000);
        BaseWebActions.clickOnWebElement(GUIMap.bodyDropDown);
        Thread.sleep(2000);
        BaseWebActions.clickOnWebElement(GUIMap.selectBodyType(Value));
    }

    public void clickOnSearchButton() throws InterruptedException {
        BaseWebActions.clickOnWebElement(GUIMap.searchButton);
    }
    public void verifySearchCount() {
        String stringText = BaseWebActions.getTextFromWebElement(GUIMap.searchCount);
        int value = Integer.parseInt(stringText.split(" ")[1].replaceAll(",", ""));
        if (value > 0) {
            System.out.println("Number of matching cars : " + value);
        } else {
            System.out.println("No Matching cars found");
        }
    }

    public void inputSearchText(String text) throws InterruptedException {
        BaseWebActions.enterText(GUIMap.searchTextField, text);
        Thread.sleep(6000);
    }

    public void clickOnSearchResult() {
        BaseWebActions.clickOnWebElement(GUIMap.ClickSearchResult);
    }

    public void verifyCarDetailsDisplayed() {
        List<WebElement> ele = driver.findElements(GUIMap.getResultSize);
        for (int i = 1; i <= ele.size(); i++) {
            values.add(BaseWebActions.getTextFromWebElement(GUIMap.validateResults(i)).trim());
        }
    }

    public void validateResult(String KM, String NP, String body) {
        for (String data : values) {
            if (data.contains(KM)) {
                System.out.println("************ Expected Values :" + KM + "Actual Value :" + data + "********");
            } else if (data.contains(NP)) {
                System.out.println("************ Expected Values :" + NP + "Actual Value :" + data + "********");
            } else if (data.contains(body)) {
                System.out.println("************ Expected Values :" + body + "Actual Value :" + data.replaceAll("\n", "" + "********"));
            }
        }
    }

}
