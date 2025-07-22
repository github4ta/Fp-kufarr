package by.kufar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id='header-wrapper']/div[2]/div/div/div[2]/div[3]/div/div/button")
    private WebElement loginButtonOnMainPage;

    @FindBy(xpath = "//*[@id='login']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='__next']/div[3]/div/form/div[4]/button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='__next']/div[3]")
    private WebElement loginModal;

    @FindBy(css = "div[data-name='error-message']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this); // Инициализация элементов
    }

    public void openLoginModal() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnMainPage)).click();
            wait.until(ExpectedConditions.visibilityOf(loginModal));
        } catch (Exception e) {
            throw new RuntimeException("Не удалось открыть модальное окно логина", e);
        }
    }

    public void login(String email, String password) {
        openLoginModal();
        setEmail(email);
        setPassword(password);
        clickSubmit();
    }

    public void setEmail(String email) {
        openLoginModal();
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    public void setPassword(String password) {
        openLoginModal();
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isLoggedIn() {
        try {
            return !driver.findElements(By.xpath("//*[@data-name='user-avatar']")).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }
}