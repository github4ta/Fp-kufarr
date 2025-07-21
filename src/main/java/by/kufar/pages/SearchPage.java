package by.kufar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id='header-wrapper']/div[2]/div/div/div[1]/div[2]/div/div/div/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='header-wrapper']/div[2]/div/div/div[1]/div[2]/div/div/div/button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class, 'styles_item')]")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[contains(text(), 'Ничего не найдено')]")
    private WebElement noResultsMessage;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String query) {
        searchInput.sendKeys(query);
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(productCards));
    }

    public boolean hasResults() {
        return !productCards.isEmpty();
    }

    public int getResultsCount() {
        return productCards.size();
    }

    // Новый метод
    public boolean isNoResultsDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}