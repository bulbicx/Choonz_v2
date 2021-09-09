@navlinks
Feature: Header feature
  As a user, I want to navigate through pages by using links in the navbar, 
  so that i can navigate through pages.

  Scenario: Header Home Link
    Given I am on the home page
    When I click on the header home button
    Then I am taken to the home page

  Scenario: Header Artist Test
    Given I am on the home page
		When I click on the header artist button
		Then I am taken to the artists page
		
  Scenario: Header Album Test
    Given I am on the home page
		When I click on the header album button
		Then I am taken to the albums page
		
	Scenario: Header Playlist Test
    Given I am on the home page
		When I click on the header playlist button
		Then I am taken to the playlists page
		
	Scenario: Header Genre Test
    Given I am on the home page
		When I click on the header genre button
		Then I am taken to the genres page
	
	Scenario: Header Login Test
		Given I am on the home page
		When I click on the header login button
		Then I am taken to the login page
		
