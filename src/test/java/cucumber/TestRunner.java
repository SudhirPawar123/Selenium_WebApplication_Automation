package cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\dell\\Desktop\\PageObjectModel\\src\\main\\resources\\cucumberlogin.feature",
        glue = "cucumber",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{
}
