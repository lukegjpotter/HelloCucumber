Feature: Testing on the Google Search Page
  Verifying using Selenium

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"