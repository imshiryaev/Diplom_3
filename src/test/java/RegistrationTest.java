import api.user.User;
import api.user.UserSteps;
import components.Header;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static api.user.UserGenerate.generateUserData;

public class RegistrationTest {
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
    @DisplayName("Проверка успешной регистрации")
    public void registrationTest() {
        Assert.assertTrue(new Header(driver)
                .clickOnButtonUserCabinet()
                .clickOnRegisterLink()
                .register(user.getName(), user.getEmail(), user.getPassword())
                .checkSuccessFullRegistration());
    }

    @Test
    @DisplayName("Проверка регистрации с некорректным паролем")
    public void registrationTestWithIncorrectPassword() {
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        Assert.assertTrue(new Header(driver)
                .clickOnButtonUserCabinet()
                .clickOnRegisterLink()
                .register(user.getName(), user.getEmail(), user.getPassword()).checkIncorrectPasswordText());
    }
}