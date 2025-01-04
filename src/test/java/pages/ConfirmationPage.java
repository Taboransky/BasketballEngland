package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class ConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String pageAddress = "https://membership.basketballengland.co.uk/Account/SignUpConfirmation";

    private final By byPageTitle = By.cssSelector("div.page-content-wrapper > div > h2");
    private final By byMembershipNumber = By.cssSelector("div.page-content-wrapper > div > div > h2");


    public ConfirmationPage() {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ensurePageLoaded() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byPageTitle));
    }

    public String getPageTitle() {
        return driver.findElement(byPageTitle).getText();
    }

    public String getMembershipNumber () {
        return driver.findElement(byMembershipNumber).getText();
    }

}
