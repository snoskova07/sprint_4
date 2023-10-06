package ru.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.MainPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ImportantQuestions {
    WebDriver webDriver;
    MainPage mainPage;

    private final String questionNumber;
    private final String answer;

    public ImportantQuestions(String questionNumber, String answer) {
        this.questionNumber = questionNumber;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        //Генерация тестовых данных
        return new Object[][] {
                { "1", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { "2", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { "3", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "4", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { "5", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { "6", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { "7", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { "8", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        mainPage = new MainPage(webDriver);
    }

    @Test
    // Проверка ответов на вопросы
    public void importantQuestionsTest() {
        mainPage.closeCookie();
        By questionXpath = mainPage.createXpathForQuestion(questionNumber);
        mainPage.scrollToQuestion(questionXpath);
        mainPage.clickByQuestion(questionXpath);
        By answerXpath = mainPage.createXpathForAnswer(questionNumber);
        assertEquals(answer, mainPage.getTextAnswer(answerXpath));
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}

