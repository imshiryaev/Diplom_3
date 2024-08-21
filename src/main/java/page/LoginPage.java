package page;

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

    @Step("Логин пользователя")
    public LoginPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public RegisterPage clickOnRegisterLink() {
        registerLink.click();
        return new RegisterPage(driver);
    }

}
