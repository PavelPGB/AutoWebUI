/**
 * AutoWebUI. HomeWork-3
 * Test-2
 * @author Pavel Pulyk
 * @version 0.1 12.03.2022
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

class HomeWork3Test2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://tutti-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath(".//span[contains(.,'Авторизация')]")).click();

        WebElement auth = webDriver.findElement(By.xpath(".//*[@id='content']/div/div[2]"));
            auth.findElement(By.xpath(".//*[@id='input-email']")).sendKeys("ppulyk@mail.ru");
            auth.findElement(By.xpath(".//*[@id='input-password']")).sendKeys("12345");
            auth.findElement(By.cssSelector ("#content > div > div.col-sm-6.right > div > form > input")).click();

        Thread.sleep(5000);

        webDriver.quit();
    }
}


