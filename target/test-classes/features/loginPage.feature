Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When user gets title of the page
Then page title should be "My Store"

Scenario: Forgot Password Link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "melearningnow111@gmail.com"
And user enters password "Practice@123"
And user clicks on login button
Then user gets title of the page
And page title should be "My account - My Store" 

