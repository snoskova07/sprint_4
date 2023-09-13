package ru.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum.pageobject.MainPage;
import ru.praktikum.pageobject.OrderPage;
import ru.praktikum.pageobject.ArendaPage;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreateOrder {

    WebDriver webDriver;
    MainPage mainPage;
    OrderPage orderPage;
    ArendaPage arendaPage;

    private final int buttonNumber;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String comment;

    public CreateOrder(int buttonNumber, String firstName, String lastName, String address, String phoneNumber, String comment) {
        this.buttonNumber = buttonNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        //Генерация тестовых данных
        return new Object[][] {
                { 1, "Иван", "Иванов", "Новосибирск", "12345678900", "Быстрый"},
                { 2, "Людмила", "Петрова", "Томск", "12345678922", "Красивый"},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        mainPage = new MainPage(webDriver);
        orderPage = new OrderPage(webDriver);
        arendaPage = new ArendaPage(webDriver);
    }

    @Test
    public void addOrder() {
        mainPage.closeCookie();
        mainPage.clickOrderButton(buttonNumber);
        orderPage.addFirstName(firstName);
        orderPage.addLastName(lastName);
        orderPage.addAddress(address);
        orderPage.addMetro();

        orderPage.addPhoneNumber(phoneNumber);
        orderPage.clickNextButton();

        arendaPage.setDate();
        arendaPage.setDuration();
        arendaPage.setBlackColor();
        arendaPage.addComment(comment);
        arendaPage.clickOrderButton();
        arendaPage.clickYesButton();

        assertTrue(arendaPage.isOrderComplitedLabelPresent());
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
