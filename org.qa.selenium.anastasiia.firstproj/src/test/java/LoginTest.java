import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAndLogoutTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }

    @Test
    public void TestLogin(){
        //define elements
        WebElement loginElement = driver.findElement(By.id("txtUsername"));
        WebElement passwElement = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        WebElement submitButton = driver.findElement(By.id("btnLogin"));

        // check and login
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        loginElement.sendKeys("Admin");
        passwElement.sendKeys("admin123");
        submitButton.click();

        //check result---
    }
}