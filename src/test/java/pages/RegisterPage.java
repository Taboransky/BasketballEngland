package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final String pageAddress = "https://membership.basketballengland.co.uk/NewSupporterAccount";

    // Locators
    private final By byPageTitle = By.id("titleText1");
    private final By byEmailAddress = By.name("EmailAddress");
    private final By byConfirmEmail = By.name("ConfirmEmailAddress");
    private final By byTosCheckbox = By.cssSelector("label[for='sign_up_25'] > .box");
    private final By by18Checkbox = By.cssSelector("label[for='sign_up_26'] > .box");
    private final By byEthicsCheckbox = By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] > .box");
    private final By byTosCheckedIcon = By.cssSelector("input[name=TermsAccept]:checked~label>.check");
    private final By bySubmitButton = By.name("join");
    private final By byErrorSpan = By.cssSelector("span[generated='true'][for]");

    public RegisterPage() {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get(pageAddress);
    }

    public void ensurePageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPageTitle));
    }

    public void enterFieldWith(String fieldName, String value) {
        driver.findElement(By.name(fieldName)).sendKeys(value);
    }

    public void enterEmail(String email) {
        driver.findElement(byEmailAddress).sendKeys(email);
    }

    public void enterConfirmEmail(String email) {
        driver.findElement(byConfirmEmail).sendKeys(email);
    }

    public void clickTosCheckbox() {
        //driver.findElement(byTosCheckbox).click();
        wait.until(ExpectedConditions.elementToBeClickable(byTosCheckbox)).click();
    }

    public void uncheckTosCheckbox() {
        driver.findElement(byTosCheckedIcon).click();
    }

    public void click18CheckBox() {
        driver.findElement(by18Checkbox).click();
    }

    public void clickEthicsCheckbox() {
        driver.findElement(byEthicsCheckbox).click();
    }

    public boolean isTosChecked() {
        wait.until(ExpectedConditions.elementToBeClickable(byTosCheckedIcon));
        return wait.until(ExpectedConditions.attributeContains(byTosCheckedIcon, "opacity", "1"));
    }

    public void clickSubmitButton() {
        driver.findElement(bySubmitButton).click();
    }

    public void clearField(String fieldName) {
        driver.findElement(By.name(fieldName)).clear();
    }

    public String getVisibleErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byErrorSpan)).getText();
    }
}
