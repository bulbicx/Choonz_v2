@artist
Feature: Artists page
  As a user, I want to click on links that works,
  so that I can navigate the application easily

  Scenario: Test link artist card
    Given I am on the artists page
    When I click on the card to the first artist
    Then I am taken to the page for that artist

	Scenario: Test link cover album
		Given I am on the artist page with id 1
		When I click on the cover of the first album
		Then I am taken to the page for that album
		
	Scenario: Test link genre
		Given I am on the artist page with id 1
		When I click on the genre of the first album
		Then I am taken to the page for that genre
		
		
