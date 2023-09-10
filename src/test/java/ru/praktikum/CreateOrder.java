package ru.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.pageobject.MainPage;
import ru.praktikum.pageobject.OrderPage;
import ru.praktikum.pageobject.ArendaPage;
import java.time.Duration;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreateOrder {

    WebDriver webDriver;
    MainPage mainPage;
    OrderPage orderPage;
    ArendaPage arendaPage;

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String comment;

    public CreateOrder(String firstName, String lastName, String address, String phoneNumber, String comment) {
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
                { "Иван", "Иванов", "Новосибирск", "12345678900", "Быстрый"},
                { "Людмила", "Петрова", "Томск", "12345678922", "Красивый"},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        mainPage = new MainPage(webDriver);
        orderPage = new OrderPage(webDriver);
        arendaPage = new ArendaPage(webDriver);
    }

    @Test
    public void addOrder() {
      mainPage.closeCookie();
      mainPage.topOrderButtonClick();
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

      assertEquals(true, arendaPage.isOrderComplitedLabelPresent());
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
