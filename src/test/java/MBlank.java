import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MBlank {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

@Test
    public void blankTest() {
    driver.findElement(By.xpath("//button[@id='submit']")).click();
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    driver.quit();
}


}
