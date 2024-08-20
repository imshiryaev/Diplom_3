package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
       driver = new ChromeDriver();
       driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void browserQuit() {
        driver.quit();
    }
}
