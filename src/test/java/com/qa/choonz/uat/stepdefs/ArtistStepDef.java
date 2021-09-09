package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.uat.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.ArtistsPage;
import com.qa.choonz.uat.pages.ArtistsSinglePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArtistStepDef {

	private WebDriver driver;
	private ArtistsPage artistsPage;
	private ArtistsSinglePage singlePage;

	public ArtistStepDef(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.artistsPage = PageFactory.initElements(driver, ArtistsPage.class);
		this.singlePage = PageFactory.initElements(driver, ArtistsSinglePage.class);
	}

	@Given("I am on the artists page")
	public void iAmOnTheArtistsPage() {
		this.driver.get(artistsPage.url);
	}

	@When("I click on the card to the first artist")
	public void iClickOnTheCardToTheFirstArtist() {
		artistsPage.clickFirstCard();
	}

	@Then("I am taken to the page for that artist")
	public void iAmTakenToThePageForThatArtist() {
		assertEquals("Choonz - Artist details", this.driver.getTitle());
	}

	@Given("I am on the artist page with id {int}")
	public void iAmOnTheArtistPageWithId(int int1) {
		this.driver.get(artistsPage.url);
		artistsPage.clickCardByInput(int1 - 1);
	}

	@When("I click on the cover of the first album")
	public void iClickOnTheCoverOfTheFirstAlbum() {
		singlePage.clickFirstAlbumCover();
	}

	@When("I click on the genre of the first album")
	public void iClickOnTheGenreOfTheFirstAlbum() {
		singlePage.clickGenreName();
	}

	@Then("I am taken to the page for that genre")
	public void iAmTakenToThePageForThatGenre() {
		assertEquals("Choonz - Genre details", this.driver.getTitle());
	}
}
