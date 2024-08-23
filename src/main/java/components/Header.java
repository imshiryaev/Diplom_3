package components;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private WebElement userCabinetButton;

    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private WebElement constructorButton;

    @FindBy(xpath = ".//p[text() = Лента заказов']")
    private WebElement ordersListButton;

    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private WebElement headerLogo;


    @Step("Клик на кнопку личного кабинета под авторизированным пользовтелем")
    public ProfilePage clickOnUserCabinetButtonWithAuth(){
        userCabinetButton.click();
        return new ProfilePage(driver);
    }
    @Step("Клик на кнопку личного кабинета без авторизации")
    public LoginPage clickOnUserCabinetButtonWithoutAuth(){
        userCabinetButton.click();
        return new LoginPage(driver);
    }

    @Step("Клик по логотипу")
    public MainPage clickOnLogo(){
        headerLogo.click();
        return new MainPage(driver);
    }

    @Step("Клик по кнопке 'Конструктор'")
    public MainPage clickOnConstructorButton(){
        constructorButton.click();
        return new MainPage(driver);
    }
}
