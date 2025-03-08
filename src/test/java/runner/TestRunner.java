package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(
        tags = "@smoke",
        features = "src/test/resources/features",   // Path to your feature files
        glue = "stepDefinitions",                   // Package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}, // Reporting formats
        monochrome = true,                          // Output to console in readable format
        dryRun = false                     // Set to true if you want to check if all steps are defined (without executing)// Fail the tests if any step is undefined
)
public class TestRunner extends AbstractTestNGCucumberTests {


    @Test
    public void runCucumber() {
        // The tests will be automatically triggered via TestNG
    }
}