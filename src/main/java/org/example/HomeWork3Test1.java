/**
 * AutoWebUI. HomeWork-3
 * Test-1
 * @author Pavel Pulyk
 * @version 0.1 12.03.2022
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

class HomeWork3Test1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
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

        WebElement passwordNew = webDriver.findElement(By.xpath(".//*[@id='content']/div/form/fieldset[3]"));
            passwordNew.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
            passwordNew.findElement(By.xpath(".//*[@id='input-confirm']")).sendKeys("12345");

        Thread.sleep(5000);

        webDriver.quit();
    }
}