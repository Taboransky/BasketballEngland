package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmationPage;
import pages.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MyStepdefs {

    private final RegisterPage registerPage = new RegisterPage();
    private final ConfirmationPage confirmationPage = new ConfirmationPage();


    @Given("I open the website")
    public void iOpenTheWebsite() {
        registerPage.openPage();
        registerPage.ensurePageLoaded();
    }

    @And("I fill in Email with a new random email")
    public void iFillInEmailWithANewRandomEmail() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String newRandomEmail = "testsson" + timestamp + "@test.se";

        registerPage.enterEmail(newRandomEmail);
        registerPage.enterConfirmEmail(newRandomEmail);
    }

    @And("I fill in {string} with {string}")
    public void iFillInWith(String fieldName, String value) {
        registerPage.clearField(fieldName);
        registerPage.enterFieldWith(fieldName, value);
    }

    @And("I check all checkboxes")
    public void iCheckAllCheckboxes() {
        registerPage.clickTosCheckbox();
        registerPage.click18CheckBox();
        registerPage.clickEthicsCheckbox();
    }

    @Given("I uncheck the ToS")
    public void iUncheckTheToS() {
        if (registerPage.isTosChecked()) {
            registerPage.uncheckTosCheckbox();
        } else {
            System.out.println("!! Checkbox wasn't pressed.");
        }
    }

    @When("I press submit")
    public void iPressSubmit() {
        registerPage.clickSubmitButton();
    }

    @Given("I leave the {string} field empty")
    public void iLeaveTheFieldEmpty(String fieldName) {
        System.out.println("Clearing field: " + fieldName);
        registerPage.clearField(fieldName);
    }

    @Then("I should see the error {string}")
    public void iShouldSeeTheError(String expectedError) {
        String actualError = registerPage.getVisibleErrorMessage();
        assertEquals(expectedError, actualError);
    }

    @Then("I land on the confirmation page")
    public void iLandOnTheConfirmationPage() {
        confirmationPage.ensurePageLoaded();

        // asserts Thank you page title matches
        String expectedTitle = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actualTitle = confirmationPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);

        // asserts user got a membership number
        String membershipNumber = confirmationPage.getMembershipNumber();
        assertFalse(membershipNumber.isEmpty());

        System.out.println("Account created.\nMembership number: " + membershipNumber);
    }

    @And("I fill in all fields in the registration")
    public void iFillInAllFields() {
        String[] fieldNames = {"DateOfBirth", "Forename", "Surname", "Password", "ConfirmPassword"};
        String[] values = {"06/06/2006", "Test", "Testsson", "test1", "test1"};

        for (int i = 0; i < fieldNames.length; i++) {
            iFillInWith(fieldNames[i], values[i]);
        }

        iFillInEmailWithANewRandomEmail();
    }
}
