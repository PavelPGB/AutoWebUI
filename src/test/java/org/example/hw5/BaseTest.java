package org.example.hw5;

/** AutoWebUI. HomeWork-5
 *
 * @author Pavel Pulyk
 * @version 0.1 25.03.2022
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
