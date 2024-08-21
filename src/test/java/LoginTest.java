import api.user.User;
import api.user.UserSteps;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    @DisplayName("Проверка логина")
    public void loginTest() {
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) userSteps.deleteUser(accessToken);
    }
}
