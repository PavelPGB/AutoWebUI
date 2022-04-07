package org.example.hw6.pages;

/** AutoWebUI. HomeWork-6
 *
 * @author Pavel Pulyk
 * @version 0.1 02.04.2022
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage auth() {
        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();
        webDriver.findElement(By.xpath(".//*[@class='well']//a[text()='Продолжить']")).click();
        return new MainPage(webDriver);
    }

    public MainPage basicData() {
        WebElement accountNew = webDriver.findElement(By.xpath(".//*[@id='account']"));
        accountNew.findElement(By.xpath(".//*[@id='input-firstname']")).sendKeys("Павел");
        accountNew.findElement(By.xpath(".//*[@id='input-lastname']")).sendKeys("П");
        accountNew.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
        accountNew.findElement(By.xpath(".//*[@id='input-telephone']")).sendKeys("+79788805650");
        return new MainPage(webDriver);
    }

    public MainPage yourAddress() {
        WebElement addressNew = webDriver.findElement(By.xpath(".//*[@id='address']"));
        addressNew.findElement(By.xpath(".//*[@id='input-address-1']")).sendKeys("Симф");
        addressNew.findElement(By.xpath(".//*[@id='input-city']")).sendKeys("Симф");
        addressNew.findElement(By.xpath(".//*[@id='input-country']")).sendKeys("Грузия");
        return new MainPage(webDriver);
    }

    public MainPage yourPassword() {
        WebElement passwordNew = webDriver.findElement(By.xpath(".//*[@class= 'form-horizontal']//fieldset[3]"));
        passwordNew.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
        passwordNew.findElement(By.xpath(".//*[@id='input-confirm']")).sendKeys("12345");
        return new MainPage(webDriver);
    }

    public MainPage quit() {
        webDriver.quit();
        return this;
    }


    public MainPage login(String email, String password) {
        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        WebElement auth = webDriver.findElement(By.xpath(".//*[@enctype='multipart/form-data']"));
        auth.findElement(By.xpath(".//*[@id='input-email']")).sendKeys(email);
        auth.findElement(By.xpath(".//*[@id='input-password']")).sendKeys(password);
        auth.findElement(By.xpath(".//input[@type= 'submit']")).click();
        return new MainPage(webDriver);
    }

    public MainPage logout() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()= 'Выход']"))))
                .click();
        return new MainPage(webDriver);
    }

    public MainPage checkLoginButtonIsVisible() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(.,'Авторизация')]")));
        webDriver.quit();
        return this;
    }

    public MainPage checkButtonNetworkSocialVK() {
        webDriver.findElement(By.xpath(".//*[@id='header']//a[@href='https://vk.com/tutti_crimea']")).click();
        return this;
    }

    public void checkErrorIsVisible (String errorText){
        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class= 'alert alert-danger warning'] ")))
                .getText()).as("Введен неверный пароль").isEqualTo(errorText);
    }
}