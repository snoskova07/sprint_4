package ru.praktikum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.MainPage;

import java.time.Duration;

import static org.junit.Assert.*;

public class ImportantQuestions {
    WebDriver webDriver;
    MainPage mainPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(webDriver);
    }

    @Test
    // Проверка ответов на вопросы
    public void importantQuestionsTest() {
        mainPage.closeCookie();
        mainPage.scrollToElement(mainPage.questionsList);

        mainPage.clickByQuestion(mainPage.question1);
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", mainPage.getTextAnswer(MainPage.answer1));

        mainPage.clickByQuestion(mainPage.question2);
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", mainPage.getTextAnswer(MainPage.answer2));

        mainPage.clickByQuestion(mainPage.question3);
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", mainPage.getTextAnswer(MainPage.answer3));

        mainPage.clickByQuestion(mainPage.question4);
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", mainPage.getTextAnswer(MainPage.answer4));

        mainPage.clickByQuestion(mainPage.question5);
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", mainPage.getTextAnswer(MainPage.answer5));

        mainPage.clickByQuestion(mainPage.question6);
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", mainPage.getTextAnswer(MainPage.answer6));

        mainPage.clickByQuestion(mainPage.question7);
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", mainPage.getTextAnswer(MainPage.answer7));

        mainPage.scrollToElement(mainPage.question8);
        mainPage.clickByQuestion(mainPage.question8);
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", mainPage.getTextAnswer(MainPage.answer8));
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
