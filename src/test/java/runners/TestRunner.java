package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    public static String browserName;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void defineBrowser(String browser)  {
        browserName = browser;
        //System.out.println("1. TestRunner browser: " + browserName);
        ConfigReader.setBrowserType(browserName);
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}