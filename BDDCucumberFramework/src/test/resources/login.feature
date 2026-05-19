Feature: Login functionality

Scenario: User logs into the application
	Given user is on the login page
	When the user enters valid credentials and then click on login button
	Then the user should be redirected to the home page of the application 
