Feature: Gsd

  Scenario: Opening of the link
    Given open the link
    Then capture user information
    When OneCognizant is present or not
    Then Navigate to one cognizant

  Scenario: serching and finding of GSD
    Given clicking of serch box
    When Serching of GSD
    Then Clicking of GSD Live Support
    And Verify for successful navigation to GSD module

  Scenario: Verifying the welcome and printing the language
    Given verify if welcome message id displayed or not
    Then Print default selected language
    And Print all languages from drop down
    
  Scenario: Printng the default country and random country detailed query
    When Print the default country
    And Print the list of country
    When Print the defaulr country info
    Then Find the random number and print the list of query
