package by.kufar.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthApiTest {

    private static final String BASE_URL = "https://www.kufar.by";
    private static final String AUTH_ENDPOINT = "/auth/api/v1/login";

    @Test
    public void testApiAvailability() {
        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get("/");

        Assert.assertEquals(response.getStatusCode(), 200,
                "Сайт должен быть доступен");
    }

    @Test(enabled = false)
    public void testAuthApi() {
        Response response = given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body("{\"email\":\"test@example.com\",\"password\":\"test\"}")
                .when()
                .post(AUTH_ENDPOINT);

        Assert.assertNotEquals(response.getStatusCode(), 404,
                "Эндпоинт авторизации не найден");
    }
}