package chrome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeCheckTipsTest {
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
    public void searchTips() throws InterruptedException {
        driver.get("https://wordpress.com/ru");//
        driver.manage().window().setSize(new Dimension(1163, 1032));
        driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/div[1]/nav/ul[1]/li[4]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/div[1]/div[1]/div[6]/ul/li[3]/a")).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        assertEquals(currentUrl, "https://wordpress.com/go/");
    }
}
