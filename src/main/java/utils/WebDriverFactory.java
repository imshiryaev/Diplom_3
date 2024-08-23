package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    static WebDriver driver;
    public static WebDriver getWebDriver() {

        if (driver == null) {
            String browser = System.getProperty("browser", "chrome");
            switch (browser) {
                case "chrome":
                    return new ChromeDriver();
                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                    return new ChromeDriver();
                default:
                    throw new RuntimeException("Некорректный браузер");
            }
        }
        return driver;
    }
}
