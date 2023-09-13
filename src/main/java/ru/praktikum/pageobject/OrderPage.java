package ru.practikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    WebDriver webDriver;
    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Заголовок страницы order
    public By orderPageHeader = By.className("Order_Header__BZXOb");

    //поле Имя
    public By firstNameInput = By.xpath(".//input[@placeholder='* Имя']");

    //поле Фамилия
    public By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле Адрес
    public By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // список станций Метро
    private final By metroList = By.xpath(".//div[@class='select-search__value']");

    // Метро
    private final By metroStation = By.xpath(".//*[contains(text(), 'Красносельская')]");

    //поле Телефон
    public By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //поле кнопка Далее
    public By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // ввести имя
    public void addFirstName(String firstName) {
        webDriver.findElement(firstNameInput).sendKeys(firstName);
    }

    // ввести фамилию
    public void addLastName(String lastName) {
        webDriver.findElement(lastNameInput).sendKeys(lastName);
    }

    // ввести адрес
    public void addAddress(String address) {
        webDriver.findElement(addressInput).sendKeys(address);
    }

    // ввести метро Динамо
    public void addMetro() {
        webDriver.findElement(metroList).click();
        new WebDriverWait(webDriver, 5000).until(ExpectedConditions.visibilityOfElementLocated(metroStation));
        webDriver.findElement(metroStation).click();
    }

    // ввести номер телефона
    public void addPhoneNumber(String number) {
        webDriver.findElement(phoneNumberInput).sendKeys(number);
    }


    //Нажатие на кнопку Далее
    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    //
    public String checkHeader() {
        return webDriver.findElement(orderPageHeader).getText();
    }



}

