package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//input[@type='text']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = ".//a[@href='/register']")
    private WebElement registerLink;

    @FindBy(xpath = ".//a[@href='/forgot-password']")
    private WebElement recoverPasswordLink;

    @FindBy(xpath = ".//h2[text()='Вход']")
    private WebElement loginText;

    @Step("Логин пользователя")
    public MainPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public RegistrationPage clickOnRegisterLink() {
        registerLink.click();
        return new RegistrationPage(driver);
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public RecoverPasswordPage clickOnRecoverPasswordLink() {
        recoverPasswordLink.click();
        return new RecoverPasswordPage(driver);
    }

    @Step("Проверка отображения страницы вход")
    public boolean checkLoginPage() {
        return loginText.isDisplayed();
    }

}
