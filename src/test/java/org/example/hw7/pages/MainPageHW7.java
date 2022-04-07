package org.example.hw7.pages;

/** AutoWebUI. HomeWork-7
 *
 * @author Pavel Pulyk
 * @version 0.1 07.04.2022
 */

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.hw7.pojo.User;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageHW7 {
    private WebDriver webDriver;
    public MainPageHW7(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Регистрация нового клиента")
    public MainPageHW7 auth() {
        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();
        webDriver.findElement(By.xpath(".//*[@class='well']//a[text()='Продолжить']")).click();
        return new MainPageHW7(webDriver);
    }

    @Step("Ввод личных данных нового клиента")
    public MainPageHW7 basicData() {
        WebElement accountNew = webDriver.findElement(By.xpath(".//*[@id='account']"));
        accountNew.findElement(By.xpath(".//*[@id='input-firstname']")).sendKeys("Павел");
        accountNew.findElement(By.xpath(".//*[@id='input-lastname']")).sendKeys("П");
        accountNew.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
        accountNew.findElement(By.xpath(".//*[@id='input-telephone']")).sendKeys("+79788805650");
        return new MainPageHW7(webDriver);
    }

    @Step("Ввод адреса нового клиента")
    public MainPageHW7 yourAddress() {
        WebElement addressNew = webDriver.findElement(By.xpath(".//*[@id='address']"));
        addressNew.findElement(By.xpath(".//*[@id='input-address-1']")).sendKeys("Симф");
        addressNew.findElement(By.xpath(".//*[@id='input-city']")).sendKeys("Симф");
        addressNew.findElement(By.xpath(".//*[@id='input-country']")).sendKeys("Грузия");
        return new MainPageHW7(webDriver);
    }

    @Step("Ввод пароля нового клиента")
    public MainPageHW7 yourPassword() {
        WebElement passwordNew = webDriver.findElement(By.xpath(".//*[@class= 'form-horizontal']//fieldset[3]"));
        passwordNew.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
        passwordNew.findElement(By.xpath(".//*[@id='input-confirm']")).sendKeys("12345");
        return new MainPageHW7(webDriver);
    }

    @Step("Выйти")
    public MainPageHW7 quit() {
        webDriver.quit();
        return this;
    }

    @Step("Авторизация клиента {user.email} {user.password}")
    public MainPageHW7 login(User user) {
        return login(user.getEmail(), user.getPassword());
    }

    @Step("Авторизация клиента")
    public MainPageHW7 login(String email, String password) {
        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        WebElement auth = webDriver.findElement(By.xpath(".//*[@enctype='multipart/form-data']"));
        auth.findElement(By.xpath(".//*[@id='input-email']")).sendKeys(email);
        auth.findElement(By.xpath(".//*[@id='input-password']")).sendKeys(password);
        auth.findElement(By.xpath(".//input[@type= 'submit']")).click();
        return new MainPageHW7(webDriver);
    }

    @Step("Выход из личного кабинета")
    public MainPageHW7 logout() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()= 'Выход']"))))
                .click();
        return new MainPageHW7(webDriver);
    }

    @Step("Проверка видимости кнопки входа в систему")
    public MainPageHW7 checkLoginButtonIsVisible() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(.,'Авторизация')]")));
        webDriver.quit();
        return this;
    }

    @Step("Проверка кнопки перехода в соцсеть VK")
    public MainPageHW7 checkButtonNetworkSocialVK() {
        webDriver.findElement(By.xpath(".//*[@id='header']//a[@href='https://vk.com/tutti_crimea']")).click();
        return this;
    }

    @Step("Проверка видимости текста ошибки")
    public void checkErrorIsVisible (String errorText){
        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class= 'alert alert-danger warning'] ")))
                .getText()).as("Введен неверный пароль").isEqualTo(errorText);
    }
}
