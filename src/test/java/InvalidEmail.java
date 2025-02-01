import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidEmail {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void invalidEmail() throws InterruptedException {
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        // Invalid Email 1 (No domain)
        email.sendKeys("karunarathna");
        submitButton.click();

        Thread.sleep(2000);
        // Invalid Email 2 (Incorrect domain)
        email.clear();
        email.sendKeys("karunarathna@gmail");
        submitButton.click();

        Thread.sleep(2000);

        // Valid Email
        email.clear();
        email.sendKeys("karunarathna@gmail.com");
        submitButton.click();

        driver.quit();
    }
}
