package firefox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirefoxCourseMakerTest {
    private RemoteWebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchCourseMaker() throws InterruptedException {
        driver.get("https://wordpress.com/ru");
        driver.manage().window().setSize(new Dimension(1163, 1032));
        driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/div[1]/nav/ul[1]/li[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/div[1]/div[1]/div[4]/ul/li[9]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"wpcom\"]/div/div[2]/div[3]/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sensei_site_title\"]")).sendKeys("sao");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"wpcom\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[3]/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"signup-email\"]")).sendKeys("qwertasdfgsh84348234521@mail.ru");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/form/div/button")).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        assertEquals(currentUrl, "https://wordpress.com/setup/sensei/senseiDomain");
    }
}
