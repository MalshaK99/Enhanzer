import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Form {
    WebDriver driver;
    WebDriverWait wait;

    //Valid form submission with all correct inputs.

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void form() throws InterruptedException {
        // Filling out the form
        driver.findElement(By.id("firstName")).sendKeys("Malsha");
        driver.findElement(By.id("lastName")).sendKeys("Karunarathna");
        driver.findElement(By.id("userEmail")).sendKeys("mkarunaratha872@gmail.com");

        // Selecting gender
        driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();

        // Entering mobile number
        driver.findElement(By.id("userNumber")).sendKeys("0764635795");

        // Selecting date of birth
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.click();
        driver.findElement(By.cssSelector("div[aria-label='Choose Thursday, January 30th, 2025']")).click();

        // Selecting hobbies
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();

        // Uploading picture
        WebElement picUpload = driver.findElement(By.id("uploadPicture"));
        picUpload.sendKeys("C:\\Users\\User\\Pictures\\Screenshots\\CookBookie.png");

        // Entering Address
        driver.findElement(By.id("currentAddress")).sendKeys("No 531, Colombo rd, Gintota");

        //  Selecting State (Rajasthan)**
        WebElement stateDropdown = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'css-1hwfws3')]"));
        stateDropdown.click();
        WebElement rajasthanOption = driver.findElement(By.xpath("//div[contains(text(),'NCR')]"));
        rajasthanOption.click();

        //selecting city
        WebElement cityDropdown = driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
        cityDropdown.click();
        WebElement delhiOption=driver.findElement(By.xpath("//div[contains(text(),'Delhi')]"));
        delhiOption.click();

        //submit btn
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.quit();

    }
}
