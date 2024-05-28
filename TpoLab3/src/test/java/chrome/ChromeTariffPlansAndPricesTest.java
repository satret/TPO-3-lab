package chrome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeTariffPlansAndPricesTest {
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
    public void aeroexpressRedirect() {
        driver.get("https://wordpress.com/ru/");
        driver.manage().window().setSize(new Dimension(948, 1032));
        //
        driver.findElement(By.xpath("/html/body/div[1]/nav/ul[1]/li[5]/a")).click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://wordpress.com/ru/pricing/");
    }

}
