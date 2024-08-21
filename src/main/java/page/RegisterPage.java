package page;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//fieldset[1]/div/div/input")
    private WebElement nameInput;

    @FindBy(xpath = ".//fieldset[2]/div/div/input")
    private WebElement emailInput;

    @FindBy(xpath = ".//fieldset[3]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = ".//h2[text()='Вход']")
    private WebElement loginPageText;

    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement incorrectPasswordText;

    @Step("Регистрация")
    public RegisterPage register(String name, String email, String password) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        registerButton.click();
        return this;
    }

    @Step("Проверка отображения страницы 'Вход' после успешной регистрации")
    public boolean checkSuccessFullRegistration(){
        return loginPageText.isDisplayed();
    }

    @Step("Проверка отображения текста после ввода некорректного пароля")
    public boolean checkIncorrectPasswordText(){
        return incorrectPasswordText.isDisplayed();
    }
}
