package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        String browser = System.getenv("BROWSER");

        if (browser == null) {
            System.out.println("LOG: Hooks: Browser not specified by Environmnet, defaulting to chrome");
            browser = "chrome";
        }

        //System.out.println("LOG: 1. Hooks: " + browser);
        DriverManager.setBrowser(browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
