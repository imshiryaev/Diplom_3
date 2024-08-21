package components;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LoginPage;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private WebElement buttonUserCabinet;

    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private WebElement buttonConstructor;

    @FindBy(xpath = ".//p[text() = Лента заказов']")
    private WebElement buttonOrdersList;

    public LoginPage clickOnButtonUserCabinet() {
        buttonUserCabinet.click();

        return new LoginPage(driver);
    }
}
