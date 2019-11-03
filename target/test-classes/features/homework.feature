@web @regression @homework
Feature: Homework

  Background:
    Given

  @homework-1
  Scenario Outline: Verify email addresses
    When I enter AMIR into first name on home screen
    And I entered Sabirov into Last name on home paga
    And I enter <Emails> into Email text Field
    And I click on password text filed
    And I click on red error
    Then
    Examples:

    |Emails|
    |adada|
    |adfdf|
    |faerwfd|


  @homework-2
  Scenario:
    #Steps

  @homework-3
  Scenario:
    #Steps