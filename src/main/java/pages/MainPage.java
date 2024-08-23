package pages;

import base.BasePage;
import com.mifmif.common.regex.Main;
import components.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Header {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button[text() = 'Войти в аккаунт']")
    private WebElement loginButton;

    @FindBy(xpath = ".//button[text() = 'Оформить заказ']")
    private WebElement createOrderButton;

    @FindBy(xpath = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[1]")
    private WebElement tabBuns;

    @FindBy(xpath = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[2]")
    private WebElement tabSauces;

    @FindBy(xpath = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[3]")
    private WebElement tabFillings;

    @Step("Клик по кнопке логина на главной странице")
    public LoginPage clickOnLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @Step("Проверка наличия кнопки 'Оформить заказ'")
    public boolean checkDisplayedCreateOrderButton() {
        return createOrderButton.isDisplayed();
    }

    @Step("Клик по табу 'Булки'")
    public MainPage clickOnTabBuns() {
        tabBuns.click();
        return this;
    }

    @Step("Клик по табу 'Соусы'")
    public MainPage clickOnTabSauces() {
        tabSauces.click();
        return this;
    }

    @Step("Клик по табу 'Начинки'")
    public MainPage clickOnTabFillings() {
        tabFillings.click();
        return this;
    }

    @Step("Проверка наличия класса активности")
    public boolean checkIsActiveTabBuns() {
        return tabBuns.getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    @Step("Проверка наличия класса активности")
    public boolean checkIsActiveTabSauces() {
        return tabSauces.getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    @Step("Проверка наличия класса активности")
    public boolean checkIsActiveTabFillings() {
        return tabFillings.getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }


}
