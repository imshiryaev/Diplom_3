package org.example.pageobject.components;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

   private final By buttonUserCabinet = By.xpath(".//p[text() = 'Личный Кабинет']");
   private final By buttonConstructor = By.xpath(".//p[text() = 'Конструктор']");
   private final By buttonOrdersList = By.xpath(".//p[text() = Лента заказов']");


    public void clickOnButtonUserCabinet(){
        driver.findElement(buttonUserCabinet).click();
   }
}
