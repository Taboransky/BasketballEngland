Feature: Register

  Background: I fill in every required field in the registration
    Given I open the website
    And I fill in all fields in the registration
    And I check all checkboxes

  Scenario: I don't check the ToS checkbox and get correct error
    Given I uncheck the ToS
    When I press submit
    Then I should see the error "You must confirm that you have read and accepted our Terms and Conditions"
