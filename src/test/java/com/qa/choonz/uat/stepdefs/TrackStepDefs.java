package com.qa.choonz.uat.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.uat.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.TrackPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackStepDefs {

	private WebDriver driver;
	private TrackPage trackPage;

	public TrackStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.trackPage = PageFactory.initElements(driver, TrackPage.class);
	}

	@Given("I am on the first track page")
	public void iAmOnTheFirstTrackPage() {
		this.driver.get(trackPage.url);
	}

	@When("I click on the cover of the album")
	public void iClickOnTheCoverOfTheAlbum() {
		trackPage.clickAlbumCover();
	}

	@Then("I go to the page of that album")
	public void iGoToThePageOfThatAlbum()  {
		assertEquals("Choonz - Album details", this.driver.getTitle());
	}

	@When("I click on the cover of the artist")
	public void iClickOnTheCoverOfTheArtist() {
		trackPage.clickArtistCover();
	}

	@Then("I go to the page of that artist")
	public void iGoToThePageOfThatArtist() {
		assertEquals("Choonz - Artist details", this.driver.getTitle());
	}
}
