Feature: My Accounts Page Feature

Background: 
Given user is already logged into the application
|username|password|
|melearningnow111@gmail.com|Practice@123|
 
Scenario: My Accounts page title
Given user is on My Accounts page
When user gets title of the page
Then page title should be "My account - My Store"

Scenario: My Accounts section names and count
Given user is on My Accounts page
Then user gets My Accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And My Accounts section count should be 5

