package by.kufar.core;

import by.kufar.config.ConfigLoader;
import by.kufar.drivers.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseUITest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigLoader.getWaitTimeout()));
        driver.get(ConfigLoader.getBaseUrl());
        acceptCookies();
    }

    protected void acceptCookies() {
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(ConfigLoader.getCookieBannerLocator())));
            WebElement acceptButton = cookieBanner.findElement(
                    By.xpath(ConfigLoader.getCookieAcceptLocator()));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already accepted");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}