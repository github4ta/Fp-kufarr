package by.kufar.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {}

    public static WebDriver getInstance() {
        if (instance == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            instance = new ChromeDriver(options);
        }
        return instance;
    }

    public static void resetDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}