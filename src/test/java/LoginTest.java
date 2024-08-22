import api.user.User;
import api.user.UserSteps;
import components.Header;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.time.Duration;

import static api.user.UserGenerate.generateUserData;

public class LoginTest {

    String accessToken;
    UserSteps userSteps = new UserSteps();
    User user = generateUserData();

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) userSteps.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Проверка логина через кнопку на главной странице")
    public void loginTestViaMainPageButton() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new MainPage(driver)
                .clickOnLoginButton()
                .login(user.getEmail(), user.getPassword())
                .checkDisplayedCreateOrderButton());
    }

    @Test
    @DisplayName("Проверка логина через кнопку Личный Кабинет")
    public void loginTestViaUserCabinetButton() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new Header(driver)
                .clickOnUserCabinetButtonWithoutAuth()
                .login(user.getEmail(), user.getPassword())
                .checkDisplayedCreateOrderButton());
    }

    @Test
    @DisplayName("Проверка логина через кнопку Войти на странице регистрации")
    public void loginTestViaRegistrationPageLoginButton() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new Header(driver)
                .clickOnUserCabinetButtonWithoutAuth()
                .clickOnRegisterLink()
                .clickOnLoginButton()
                .login(user.getEmail(), user.getPassword())
                .checkDisplayedCreateOrderButton());
    }

    @Test
    @DisplayName("Проверка логина через кнопку на странице восстановления пароля")
    public void loginTestViaRecoveryPageLoginButton() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new Header(driver)
                .clickOnUserCabinetButtonWithoutAuth()
                .clickOnRecoverPasswordLink()
                .clickOnLoginButton()
                .login(user.getEmail(), user.getPassword())
                .checkDisplayedCreateOrderButton());
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void logoutTest() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new Header(driver)
                .clickOnUserCabinetButtonWithoutAuth()
                .login(user.getEmail(), user.getPassword())
                .clickOnUserCabinetButtonWithAuth()
                .clickOnLogoutButton()
                .checkLoginPage());
    }

}
