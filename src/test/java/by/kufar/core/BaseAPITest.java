package by.kufar.core;

import by.kufar.config.ConfigLoader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {
    @BeforeClass
    public void setUpApi() {
        RestAssured.baseURI = ConfigLoader.getApiBaseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}