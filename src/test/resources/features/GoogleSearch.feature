Feature: Google search for if.lv

  Background:
    Given User is on Google main page
      And User types "if.lv" in search box
      And User presses Google Search button
      And Search results are displayed


  Scenario: Second search result for past week
    When User taps Tools button
      And User selects Past week option in time frame selection menu
    Then Second result leads to "bta" home page
