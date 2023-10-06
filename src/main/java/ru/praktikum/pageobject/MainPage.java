package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public By topOrderButton = By.xpath(".//div[@class='Header_Header__214zg']//button[text()='Заказать']");

    //кнопка Заказать (в середине страницы)
    public By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");

    // Выбор кнопки
    public void clickOrderButton(int num) {
        if (num == 1) {
            webDriver.findElement(topOrderButton).click();
        }
        else if (num == 2) {
            webDriver.findElement(middleOrderButton).click();
        }
    }


    // Нажатие на кнопку Заказать (вверху)
    public void topOrderButtonClick() {
        webDriver.findElement(topOrderButton).click();
    }

    // Нажатие на кнопку Заказать (в середине)
    public void middleOrderButtonClick() {
        webDriver.findElement(middleOrderButton).click();
    }

    // Нажатие на вопрос
    public void clickByQuestion(By element) {
        webDriver.findElement(element).click();
    }

    //формирование xpath до вопроса
    public By createXpathForQuestion(String questionNumber) {
        String element = ".//div[@class='accordion']/div[@class='accordion__item']" + "[" + questionNumber + "]";
        By questionXpath = By.xpath(element);
        return questionXpath;
    }

    //скролл до вопросов
    public void scrollToQuestion(By question) {
        WebElement element1 = webDriver.findElement(question);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element1);
    }

    //формирование xpath до ответов
    public By createXpathForAnswer(String questionNumber) {
        String element = ".//div[@class='accordion']/div[" + questionNumber + "]/div[2]/p";
        By answerXpath = By.xpath(element);
        return answerXpath;
    }

    //закрытие сообщения про куки
    public void closeCookie() {
        webDriver.findElement(cookie).click();
    }

    //получение текста для 1 вопроса
    public String getTextAnswer(By element) {
        new WebDriverWait(webDriver,3)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return webDriver.findElement(element).getText();
    }

    public void scrollToElement(By element) {
        WebElement element1 = webDriver.findElement(element);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element1);
    }
}
