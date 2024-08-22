package pages;

import components.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends Header {

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text() = 'Профиль']")
    private WebElement nameInput;

    @FindBy(xpath = ".//button[text() = 'Выход']")
    private WebElement logoutButton;


    @Step("Проверка попадания на страницу профиля")
    public Boolean checkProfilePage() {
        return nameInput.isDisplayed();
    }

    @Step("Клие по кнопке выход")
    public LoginPage clickOnLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }
}
