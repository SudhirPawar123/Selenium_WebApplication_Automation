package cucumber;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCucumber {
    WebDriver driver;

    @Given("User is on login page")
    public void userLogin() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(6000);
        driver.manage().window().maximize();
    }

    @When("User Enter the Username as {string}")
    public void userEnterUsername(String uName) {
        driver.findElement(By.name("username")).sendKeys(uName);
    }

    @When("User enter Password as {string}")
    public void userEnterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("click on submit button")
    public void clickOnLoginButton() {
        driver.findElement(By.xpath("//div[@class=\"orangehrm-login-branding\"]")).click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
