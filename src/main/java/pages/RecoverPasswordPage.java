package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPage extends BasePage {

    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text()='Войти']")
    private WebElement loginButton;

    @Step("Клик по кнопке Войти на странице восстановления пароля")
    public LoginPage clickOnLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

}
