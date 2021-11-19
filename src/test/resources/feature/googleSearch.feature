Feature: Google Search Function

Scenario: Search Java
Given I launch google page
When I search Java Tutorial
Then should display Java result page
And I close the browser

Scenario: Search Cypress
Given I launch google page
When I search Cypress Tutorial
Then should display Cypress result page
And I close the browser