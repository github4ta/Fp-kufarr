package by.kufar.ui;

import by.kufar.core.BaseUITest;
import by.kufar.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUITest extends BaseUITest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("valid@email.com", "validPassword"); // "valid@email.com" и "validPassword" скорее всего нужно заменить на зарегистрированного пользователя и тогда тест будет работать. но мы такую проверку не делаем.
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

    // и .т.д. тесты которые проверяют форму логина для незарегистрированного пользователя, или с некорректными данными, или с пустыми данными. и смотрим (проверяем) что соответствующие тексты сообщений появляются.
}