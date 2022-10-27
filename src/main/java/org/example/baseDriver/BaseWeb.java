package org.example.baseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseWeb {
    public  static WebDriver driver;
    public static WebDriver selectBrowser(String browser) {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/windows/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("FireFox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/driver/windows/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/mac/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FireFox")) {
                System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/src/test/resources/driver/mac/geckodriver");
                driver = new FirefoxDriver();
            }
        }
        else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/linux/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FireFox")) {
                System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/src/test/resources/driver/linux/geckodriver");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
