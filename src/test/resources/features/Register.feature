Feature: Register

  Background: I fill in every required field in the registration
    Given I open the website
    And I fill in all fields in the registration
    And I check all checkboxes

  #Scenario Outline: I leave every field is empty once and get correct errors
  #  Given I leave the "<FieldName>" field empty
  #  When I press submit
  #  Then I should see the error "<ErrorMessage>"
  #  Examples:
  #    | FieldName           | ErrorMessage                         |
  #    | Forename            | First Name is required               |
  #    | Surname             | Last Name is required                |
  #    | EmailAddress        | Email Address is required            |
  #    | ConfirmEmailAddress | Confirm Email Address does not match |
  #    | Password        | Password is required         |
  #    | ConfirmPassword | Confirm Password is required |
#
  #Scenario Outline: I type invalid passwords and get correct errors
  #  Given I fill in "ConfirmPassword" with "<Password>"
  #  When I press submit
  #  Then I should see the error "<ErrorMessage>"
  #  Examples:
  #    | Password | ErrorMessage                                 |
  #    | test2 | Password did not match                       |
  #    |   | Confirm Password is required                 |
  #    | a | Password must be between 5 and 20 characters |
#
  Scenario: I don't check the ToS checkbox and get correct error
    Given I uncheck the ToS
    When I press submit
    Then I should see the error "You must confirm that you have read and accepted our Terms and Conditions"
#
  #Scenario: I create a user successfully
  #  When I press submit
  #  Then I land on the confirmation page
