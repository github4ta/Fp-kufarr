package by.kufar.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SearchApiClient {
    private final RequestSpecification request;

    public SearchApiClient(String baseUrl) {
        this.request = given()
                .baseUri(baseUrl)
                .contentType("application/json");
    }

    public Response search(String query) {
        return request
                .queryParam("query", query)
                .when()
                .get("/api/v1/search");
    }

    public Response searchWithFilters(String query, String category, double minPrice) {
        return request
                .queryParam("query", query)
                .queryParam("category", category)
                .queryParam("price_min", minPrice)
                .when()
                .get("/api/v1/search");
    }
}