# Documentation

- I tried to develop this project as close as possible to a 'real' project and not only follow the requirements in the slides.
- The project uses Cucumber, JUnit and GithubActions to run all tests parallel on two browsers.
- I also wrote PoMs for RegisterPage and ConfirmationPage, to improve test readability.

<br/>

**Scenarios explained:**
```
Background: I fill in every required field in the registration
  - Fills in all fields and checks the required checkboxes

Scenario Outline: I leave every field is empty once and get correct errors
  - Empties one of the fields at a time for all fields in the registration and expects errors
    - Fullfils requirement: Spaka användare - efternamn saknas

Scenario Outline: I type invalid passwords and get correct errors
  - Types different types of invalid scenarios in the ConfirmPassword field
    - Fullfils requirement: Spaka användare - lösenord matchar inte

Scenario: I don't check the ToS checkbox and get correct error
  - Leaves the ToS unchecked
    - Fullfils requirement: Spaka användare - terms and conditions är inte godkänt

Scenario: I create a user successfully
  - Self explanatory :)
    - Fullfils requirement: Spaka användare - allt går som förväntat
```

- Every `Then` contains a JUnit assert to verify the expected behavior

<br>

Cross browser testing runs with the help of GithubActions:
```
jobs:
  test:
    name: Testing on ${{ matrix.browser }}
    runs-on: ubuntu-latest

    strategy:
      matrix:
        browser: [ chrome, edge ]

    env:
      BROWSER: ${{ matrix.browser }}

```
<br/>

## Running tests
Currently there's a Workflow that runs on every PR to Master or push to Master or `feature/**` branches.   
Alternatively you can run Cucumber tests via IntelliJ (will not run cross-browser though, only Chrome).
- Checkout the repository
- Run `mvn clean install`
- ???
- Profit!

## Final result 
```
===============================================
[INFO] Results:
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
===============================================
```
![img.png](img.png)