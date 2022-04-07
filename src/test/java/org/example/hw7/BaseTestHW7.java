package org.example.hw7;

/** AutoWebUI. HomeWork-7
 *
 * @author Pavel Pulyk
 * @version 0.1 07.04.2022
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.hw7.listener.AllureListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.example.hw7.pojo.User;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

class BaseTestHW7 {
    protected EventFiringWebDriver webDriver;
    public final String EMAIL = "ppulyk@mail.ru";
    public final String PASSWORD = "12345";
    public final User user = new User(EMAIL, PASSWORD);

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
        webDriver.register(new AllureListener());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
    }

    @AfterEach
    void tearDown() {
        step("Логи браузера", () -> {
           webDriver.manage().logs().get(LogType.BROWSER)
                   .forEach(log -> addAttachment("logs", log.getMessage()));
        });
       webDriver.quit();
    }
/*
    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
    */
}
