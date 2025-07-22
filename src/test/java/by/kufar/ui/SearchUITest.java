package by.kufar.ui;

import by.kufar.core.BaseUITest;
import by.kufar.pages.SearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchUITest extends BaseUITest {

    @Test
    public void testValidSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchFor("iPhone");
        // во время поиска появляется рекалмное окно. и с ним нужно как-то сначала провзаимодействовать.

        assertTrue(searchPage.hasResults(), "No search results found");
        assertTrue(searchPage.getResultsCount() > 0, "Results count should be positive");
    }

    @Test
    public void testInvalidSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchFor("asdfghjkl123456");

        assertTrue(searchPage.isNoResultsDisplayed(),
                "No results message should be displayed");
    }
}