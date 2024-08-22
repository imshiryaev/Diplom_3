import api.user.User;
import api.user.UserSteps;
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

public class MoveUserCabinetTest {
    protected WebDriver driver;
    protected String accessToken;
    UserSteps userSteps = new UserSteps();
    User user = generateUserData();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            accessToken = userSteps.loginUser(user).extract().path("accessToken");
            userSteps.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    public void testMoveInUserCabinet() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new MainPage(driver)
                .clickOnLoginButton()
                .login(user.getEmail(), user.getPassword())
                .clickOnUserCabinetButtonWithAuth()
                .checkProfilePage());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип")
    public void testMoveToConstructorOnClickLogo() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new MainPage(driver)
                .clickOnLoginButton()
                .login(user.getEmail(), user.getPassword())
                .clickOnUserCabinetButtonWithAuth()
                .clickOnLogo()
                .checkDisplayedCreateOrderButton());

    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на кнопку конструктор")
    public void testMoveToConstructorOnClickConstructorButton() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");

        Assert.assertTrue(new MainPage(driver)
                .clickOnLoginButton()
                .login(user.getEmail(), user.getPassword())
                .clickOnUserCabinetButtonWithAuth()
                .clickOnConstructorButton()
                .checkDisplayedCreateOrderButton());

    }
}
