package by.kufar.api;

import by.kufar.config.ConfigLoader;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchApiTest {
    private SearchApiClient searchApi;

    @BeforeClass
    public void setUp() {
        this.searchApi = new SearchApiClient(ConfigLoader.getBaseUrl());
    }

    @Test
    public void testSearchApiReturns200() {
        Response response = searchApi.search("ноутбук");
        assertEquals(response.getStatusCode(), 200,
                "API should return 200 for valid search");
    }

    @Test
    public void testSearchWithFilters() {
        Response response = searchApi.searchWithFilters("телевизор", "electronics", 100);
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.jsonPath().getList("items").size() > 0,
                "Search with filters should return results");
    }
}