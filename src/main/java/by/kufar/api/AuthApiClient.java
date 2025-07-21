package by.kufar.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class AuthApiClient {
    private final RequestSpecification request;

    public AuthApiClient(String baseUrl) {
        this.request = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .accept("application/json");
    }

    public Response login(String email, String password) {
        String requestBody = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
        return request
                .body(requestBody)
                .when()
                .post("/auth/api/v1/login");
    }
}