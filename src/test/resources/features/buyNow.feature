
@wip
Feature: Buy functionality

  Scenario: Verify if the user is asked email or phone number after clicking Buy Now

    Given user is on the homepage
    And user clicks on hamburger menu
    And user selects "Kindle" under Digital Content and Devices
    And user clicks "Kindle" under Kindle E-Reader
    Then user clicks Buy Now
    Then user is asked for email or mobile number