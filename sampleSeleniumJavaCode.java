import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Maximize Window
        driver.manage().window().maximize();

        // Open Application URL
        driver.get("https://the-internet.herokuapp.com/login");

        // -------- LOGIN SCENARIO --------

        // Enter Username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        // Enter Password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        // Click Login Button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

        Thread.sleep(2000);

        // Validate Login Success Message
        WebElement successMsg = driver.findElement(By.id("flash"));
        if(successMsg.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        // -------- LOGOUT SCENARIO --------

        WebElement logoutBtn = driver.findElement(By.cssSelector(".button.secondary.radius"));
        logoutBtn.click();

        Thread.sleep(2000);

        // Validate Logout
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("login")) {
            System.out.println("Logout Successful");
        } else {
            System.out.println("Logout Failed");
        }

        // Close Browser
        driver.quit();
    }
}
