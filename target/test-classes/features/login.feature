Feature: Login into Application

Scenario Outline: Login validation
Given Initialize the browser
And Navigate to "QAClickAcademy" website
And Click on login link
When User enters <username> and <password> and logs in
Then Verify that the user has logged in successfully
And Close the browser

Examples:
|username		|password	|
|first			|first@123	|
|second			|second@123	|
|third			|third@123	|