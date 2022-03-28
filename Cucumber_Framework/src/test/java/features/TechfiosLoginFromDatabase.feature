@DBLoginFeature @Regression
Feature: Techfios login fuctionality Validation

Background:
Given User is on techfios login page

@DBScenario1 
Scenario: Login with valid credentials
When User enters "username" from techfios database
When User enters "password" from techfios database
And User clicks on signin button
Then User should land on dashboard page


