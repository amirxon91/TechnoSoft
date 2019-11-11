@web @regression @hotel
Feature:Hotels.com

    Background:
      Given I am on Hotels.com home page

@Test-1
  Scenario: I click and that's it
  Then I select room 1
  And I select room 2
  And I select room 3
  And I select room 4
  And I select room 5
  And I select room 6
  And I select room 7
  And I select room 8
  And I select room 9

  @Test-2
  Scenario Outline: Verify user can only view the result by selected property class
  Given I am on default locations search star result screen
  When  I select property class <stars>
  Then I verify system displays only <stars> hotels on search result

  Examples:

  | stars | stars |
  |5 stars|5 stars|
  |4 stars|4 stars|
  |3 stars|3 stars|

  @Test-3
  Scenario:List of all of hotel within 10 miles radius of airport or downtown
    Given I am on default locations search result screen
    Then I verify system displays all hotels within 10 miles radius of airport
    And I verify Hilton Hotel is within radius

  @Test-4
  Scenario: Verify today's deal price value
    Given Verify today's deal price value
    Then I verify today's deal is less than 200





#    @FA2-311
#      Scenario Outline:Verify room count dropdown
#      Then I select<roomNumbers> from room DropDown
#      And I verify <RoomDropDown> is displayed
#
#      Examples:
#      | roomNumbers  | RoomDropDown
#
#      | 1            | 1
#      | 2            | 2
#      | 3            | 3
#      | 4            | 4
#      | 5            | 5
#      | 6            | 6
#      | 7            | 7
#      | 8            | 8
#      | 9+           | 0




