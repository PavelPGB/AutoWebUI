package org.example.hw6;
/** AutoWebUI. HomeWork-6
 *
 * @author Pavel Pulyk
 * @version 0.1 02.04.2022
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

class BaseTestHW6 {
    protected WebDriver webDriver;
    public final String EMAIL = "ppulyk@mail.ru";
    public final String PASSWORD = "12345";

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}