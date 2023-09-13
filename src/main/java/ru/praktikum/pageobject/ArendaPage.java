package ru.practikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArendaPage {

    WebDriver webDriver;
    public ArendaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // поле даты
    public By dateTo = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // календарь
    public By date = By.xpath(".//div[text()='23']");

    // срок аренды
    public By duration = By.xpath("//div[@class='Dropdown-root']");

    // срок аренды меню
    public By dropdownMenu = By.xpath(".//div[@class='Dropdown-menu']/div[2]");

    // цвет самоката черный
    public By blackColor = By.xpath(".//label[@for='black']");

    //цвет самоката серый
    public By greyColor = By.xpath(".//label[@for='grey']");

    // Комментарий для курьера
    public By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // кнопка Заказать
    public By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // кнопка Да
    public By yesButton = By.xpath(".//button[text()='Да']");

    //Заказ оформлен
    public By orderComplitedLabel = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");




    // выбрать дату"
    public void setDate() {
        webDriver.findElement(dateTo).click();
        webDriver.findElement(date).click();
    }

    // выбрать срок аренды
    public void setDuration() {
        webDriver.findElement(duration).click();
        webDriver.findElement(dropdownMenu).click();
    }

    // установить черный цвет
    public void setBlackColor() {
        webDriver.findElement(blackColor).click();
    }

    // установить серый цвет
    public void setGreyColor() {
        webDriver.findElement(greyColor).click();
    }

    // добавить комментарий
    public void addComment(String text) {
        webDriver.findElement(comment).sendKeys(text);
    }

    // нажать Заказать
    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }
    // нажать Да
    public void clickYesButton() {
        webDriver.findElement(yesButton).click();
    }

    // Надпись Заказ оформлен
    public boolean isOrderComplitedLabelPresent() {
        new WebDriverWait(webDriver, (5000)).until(ExpectedConditions.visibilityOfElementLocated(orderComplitedLabel));
        return webDriver.findElement(orderComplitedLabel).isEnabled();
    }


}

