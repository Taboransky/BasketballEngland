# Documentation

- I tried to develop this project as close as possible to a 'real' project and not only follow the requirements in the slides.
- The project uses Cucumber, JUnit and TestNG to run all tests parallel on two browsers.
- I also wrote PoMs for RegisterPage and ConfirmationPage, to improve test readability.

<br/>
  
**Scenarios explanation:**
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

Parallel cross browser testning runs with the help of TestNG:
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="CrossBrowserTestSuite" data-provider-thread-count="4">
    <test name="TestChrome">
        <parameter name="browser" value="chrome" />
        <classes>
            <class name="runners.TestRunner"> </class>
        </classes>
    </test>
    <test name="TestEdge">
        <parameter name="browser" value="edge" />
        <classes>
            <class name="runners.TestRunner"> </class>
        </classes>
    </test>
</suite>
```
- `data-provider-thread-count="4"` sets a maximum of 4 threads running parallel
- `TestRunner.java` contains CucumberOptions + defines browser from TestNG parameter

<br/>

## Running tests
To run Cross browser testing you have to run it via the `testng.xml` file:
<br>
![image](https://github.com/user-attachments/assets/083dee95-9dd4-4ad6-bbb1-34e5178459ed)
<br>
Alternatively you can run only the Cucumber Feature file, which will default to Chrome only:
<br>
![image](https://github.com/user-attachments/assets/81c3c1ec-d66b-4d7c-b61b-12cedc9361e3)
<br>

## Final result 
```
===============================================
CrossBrowserTestSuite
Total tests run: 22, Passes: 22, Failures: 0, Skips: 0
===============================================
```
![image](https://github.com/user-attachments/assets/6bbf6305-83f7-4153-80fb-bf472e7cacb8)
