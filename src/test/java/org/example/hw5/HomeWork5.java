package org.example.hw5;

/** AutoWebUI. HomeWork-5
 *
 * @author Pavel Pulyk
 * @version 0.1 25.03.2022
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class HomeWork5 extends BaseTest {

    @Test
    @DisplayName("Авторизация нового клиента в интернет-магазине")
    void authNewClientInOnlineStore() {
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        webDriver.findElement(By.xpath(".//*[@class='well']//a[text()='Продолжить']")).click();

        WebElement accountNew = webDriver.findElement(By.xpath(".//*[@id='account']"));
        accountNew.findElement(By.xpath(".//*[@id='input-firstname']")).sendKeys("Павел");
        accountNew.findElement(By.xpath(".//*[@id='input-lastname']")).sendKeys("П");
        accountNew.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
        accountNew.findElement(By.xpath(".//*[@id='input-telephone']")).sendKeys("+79788805650");

        WebElement addressNew = webDriver.findElement(By.xpath(".//*[@id='address']"));
        addressNew.findElement(By.xpath(".//*[@id='input-address-1']")).sendKeys("Симф");
        addressNew.findElement(By.xpath(".//*[@id='input-city']")).sendKeys("Симф");
        addressNew.findElement(By.xpath(".//*[@id='input-country']")).sendKeys("Грузия");

        WebElement passwordNew = webDriver.findElement(By.xpath(".//*[@class= 'form-horizontal']//fieldset[3]"));
        passwordNew.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
        passwordNew.findElement(By.xpath(".//*[@id='input-confirm']")).sendKeys("12345");

        webDriver.quit();
    }

    @Test
    @DisplayName("Проверка входа и выхода клиента в личный кабинет.")
    void loginToClientsPersonalAccount() {
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        WebElement auth = webDriver.findElement(By.xpath(".//*[@enctype='multipart/form-data']"));
        auth.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
        auth.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
        auth.findElement(By.xpath(".//input[@type= 'submit']")).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()= 'Выход']"))))
                .click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(.,'Авторизация')]")));
        webDriver.quit();
    }

    @Test
    @DisplayName("Вход в личный кабинет по неправильному паролю.")
    void incorrectPassword() {
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        WebElement auth = webDriver.findElement(By.xpath(".//*[@enctype='multipart/form-data']"));
        auth.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
        auth.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12346");
        auth.findElement(By.xpath(".//input[@type= 'submit']")).click();

        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class= 'alert alert-danger warning'] ")))
                .getText()).as("Введен неверный пароль").isEqualTo("Неправильно заполнены поле E-Mail и/или пароль!");
    }

    @Test
    @DisplayName("Проверка работы кнопки соцсети VK в хедере сайта")
    void checkButtonNetworkSocialVK() {
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        WebElement auth = webDriver.findElement(By.xpath(".//*[@enctype='multipart/form-data']"));
        auth.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
        auth.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
        auth.findElement(By.xpath(".//input[@type= 'submit']")).click();

        webDriver.findElement(By.xpath(".//*[@id='header']//a[@href='https://vk.com/tutti_crimea']")).click();
    }
}
