@links
Feature: Albums page links
  As a user, I want to click on cards and being redirected to the proper page,
  so that the application is easy to navigate

  Scenario: Test album card link
    Given I am on the albums page
    When I click on the card to the first album
    Then I am taken to the page for that album

  Scenario: Test track link
		Given I am on the album page with id 1
		When I click on the name of the first track
		Then I am taken to the page for that track
		
	Scenario: Test artist link
		Given I am on the album page with id 1
		When I click on the artist name
		Then I am taken to the artist page


