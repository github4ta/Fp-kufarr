package by.kufar.ui;

import by.kufar.core.BaseUITest;
import by.kufar.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUITest extends BaseUITest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("valid@email.com", "validPassword");
        Assert.assertTrue(loginPage.isLoggedIn(), "Login failed");
    }

    @Test
    public void testLoginWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("");
        Assert.assertEquals("", "Заполните обязательное поле");
    }

    @Test
    public void testLoginWithEmptyEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("");
        loginPage.setPassword("");
        Assert.assertEquals("", "Заполните обязательное поле");
        Assert.assertEquals("", "Введите пароль");
    }
}