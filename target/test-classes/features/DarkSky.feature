@web @regression @homework
Feature: DarkSky

  Background:
    Given I am on home Page of DarkSky

  @test-1
  Scenario: Verify invalid Login
    When I click on Dark Sky API
    And I click on Sing Up
    And I click on Register
    Then I verify that the error is displayed

  @test-2
  Scenario:Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Then I verify current temp is not greater or less then temps


  @test-3
  Scenario: Verify highest to highest and lowest to lowest
    When I scroll down to Daily Temperatures
    And I click today's temperature
    And I check is lowest is equal to lowest
    And I check is highest is equal to highest
    Then Verify Lowest Equal To Lowest
    And Verify highest equal to highest

  @test-4
  Scenario: Verify timline is displayed in correct format
    Then I verify timeline is displayed with two hours incremented
