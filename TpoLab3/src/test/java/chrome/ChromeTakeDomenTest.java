package chrome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeTakeDomenTest {
    private RemoteWebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTrains() throws InterruptedException {
        driver.get("https://wordpress.com/ru");
        driver.manage().window().setSize(new Dimension(1163, 1032));
        driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/div[1]/div[3]/div/div[2]/div[3]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"signup-email\"]")).sendKeys("qwertasdfgsh88521@mail.ru");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/form/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"search-component-search-1\"]")).sendKeys("satret");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div/div/div[2]/div[2]/button[1]")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        assertEquals(currentUrl, "https://wordpress.com/start/plans/ru");
    }
}
