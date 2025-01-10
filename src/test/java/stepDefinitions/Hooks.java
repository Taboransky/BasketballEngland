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
        String browser = System.getenv("BROWSER");

        if (browser == null) {
            System.out.println("LOG: Hooks: Browser not specified by Environmnet, defaulting to chrome");
            browser = "chrome";
        }

        System.out.println("LOG: 1. Hooks: " + browser);
        DriverManager.launchBrowser(browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
