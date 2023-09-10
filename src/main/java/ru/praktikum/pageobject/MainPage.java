package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Закрыть куки
    public By cookie = By.id("rcc-confirm-button");

    //Заголовок Самокат
    public By header = By.className("Header_LogoScooter__3lsAR");

    //кнопка Заказать (вверху страницы)
    public By topOrderButton = By.className("Button_Button__ra12g");

    //кнопка Заказать (в середине страницы)
    public By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public By questionsList = By.className("Home_FourPart__1uthg");

    //вопрос 1:
    public By question1 = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");

    //вопрос 2:
    public By question2 = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");

    //вопрос 3:
    public By question3 = By.xpath(".//div[text()='Как рассчитывается время аренды?']");

    //вопрос 4:
    public By question4 = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");

    //вопрос 5:
    public By question5 = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");

    //вопрос 6:
    public By question6 = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");

    //вопрос 7:
    public By question7 = By.xpath(".//div[text()='Можно ли отменить заказ?']");

    //вопрос 8:
    public By question8 = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");


    //ответ 1:
    public static By answer1 = By.xpath(".//div[@class='accordion']/div[1]/div[2]/p");

    //ответ 2:
    public static By answer2 = By.xpath(".//div[@class='accordion']/div[2]/div[2]/p");

    //ответ 3:
    public static By answer3 = By.xpath(".//div[@class='accordion']/div[3]/div[2]/p");

    //ответ 4:
    public static By answer4 = By.xpath(".//div[@class='accordion']/div[4]/div[2]/p");

    //ответ 5:
    public static By answer5 = By.xpath(".//div[@class='accordion']/div[5]/div[2]/p");

    //ответ 6:
    public static By answer6 = By.xpath(".//div[@class='accordion']/div[6]/div[2]/p");

    //ответ 7:
    public static By answer7 = By.xpath(".//div[@class='accordion']/div[7]/div[2]/p");

    //ответ 8:
    public static By answer8 = By.xpath(".//div[@class='accordion']/div[8]/div[2]/p");


    // Нажатие на кнопку Заказать (вверху)
    public void topOrderButtonClick() {
        webDriver.findElement(topOrderButton).click();
    }

    // Нажатие на вопрос
    public void clickByQuestion(By element) {
        webDriver.findElement(element).click();
    }

    //скролл до вопросов
    public void scrollToElement(By element) {
        WebElement element1 = webDriver.findElement(element);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element1);
    }

    //закрытие сообщения про куки
    public void closeCookie() {
        webDriver.findElement(cookie).click();
    }

    //получение текста для 1 вопроса
    public String getTextAnswer(By element) {
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return webDriver.findElement(element).getText();
    }
}
