package com.qa.choonz.uat.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.uat.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.GenreSinglePage;
import com.qa.choonz.uat.pages.GenresPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenreStepDefs {

	private WebDriver driver;
	private GenresPage genresPage;
	private GenreSinglePage genreSinglePage;

	public GenreStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.genresPage = PageFactory.initElements(driver, GenresPage.class);
		this.genreSinglePage = PageFactory.initElements(driver, GenreSinglePage.class);
	}

	@Given("I am on the genres page")
	public void iAmOnTheGenresPage() {
		this.driver.get(genresPage.url);
	}

	@When("I click on the first genre")
	public void iClickOnTheFirstGenre() {
		genresPage.clickFirstCard();
	}

	@Given("I am on the genre single page")
	public void iAmOnTheGenreSinglePage() {
		this.driver.get(genresPage.url);
		genresPage.clickFirstCard();
	}

	@When("I click the name of the first album")
	public void iClickTheNameOfTheFirstAlbum() {
		genreSinglePage.clickAlbumName();
	}

	@Then("I am taken to the page of that album")
	public void iAmTakenToThePageOfThatAlbum() {
		assertEquals("Choonz - Album details", this.driver.getTitle());
	}

	@When("I click on the name of the artist")
	public void iClickOnTheNameOfTheArtist() {
		genreSinglePage.clickArtistName();
	}

	@Then("I am taken to the page of that artist")
	public void iAmTakenToThePageOfThatArtist() {
		assertEquals("Choonz - Artist details", this.driver.getTitle());
	}
}
