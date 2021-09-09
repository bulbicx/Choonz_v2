@navpages
Feature: Footer feature
  As a user, I want to click on links positioned on the footer,
  so that I am redirected to the respective pages.

  Scenario: Footer Home Link
    Given I am on the genres page
    When I click on the footer home button
    Then I am taken to the home page

  Scenario: Footer Artist Test
    Given I am on the genres page
		When I click on the footer artist button
		Then I am taken to the artists page
		
  Scenario: Footer Album Test
    Given I am on the genres page
		When I click on the footer album button
		Then I am taken to the albums page
		
	Scenario: Footer Playlist Test
    Given I am on the genres page
		When I click on the footer playlist button
		Then I am taken to the playlists page
		
	Scenario: Footer Genre Test
    Given I am on the genres page
		When I click on the footer genre button
		Then I am taken to the genres page
		
	Scenario: Footer Facebook Test
    Given I am on the genres page
		When I click on the footer facebook button
		Then I am taken to facebook
		
	Scenario: Footer Twitter Test
    Given I am on the genres page
		When I click on the footer twitter button
		Then I am taken to twitter
		
	Scenario: Footer Instagram Test
    Given I am on the genres page
		When I click on the footer instagram button
		Then I am taken to instagram
