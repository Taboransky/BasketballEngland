package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setup() throws Throwable {
        String browser = ConfigReader.getBrowserType();
        //System.out.println("3. Hooks: " + browser);
        DriverManager.launchBrowser(browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
