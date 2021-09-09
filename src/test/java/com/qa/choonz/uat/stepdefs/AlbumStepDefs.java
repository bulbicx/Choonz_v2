package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.uat.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.AlbumSinglePage;
import com.qa.choonz.uat.pages.AlbumsPage;
import com.qa.choonz.utils.ScreenshotUtility;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlbumStepDefs {
	
	private WebDriver driver;
	private ScreenshotUtility screenshotUtils;
	private AlbumsPage albumsPage;
	private AlbumSinglePage singlePage;
	List<WebElement> albumTitleCards;
	
	public AlbumStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		screenshotUtils = new ScreenshotUtility();
		this.albumsPage = PageFactory.initElements(driver, AlbumsPage.class);
		this.singlePage = PageFactory.initElements(driver, AlbumSinglePage.class);
	}
	
	@Given("I am on the albums page")
	public void iAmOnTheAlbumsPage() {
		this.driver.get(this.albumsPage.url);

	}

	@When("I click on the card to the first album")
	public void iClickOnTheCardToTheFirstAlbum() {
	    albumsPage.clickCard();
	}

	@Then("I am taken to the page for that album")
	public void iAmTakenToThePageForThatAlbum() {
		assertEquals("Choonz - Album details", this.driver.getTitle());
	}

	@Given("I am on the album page with id {int}")
	public void iAmOnTheAlbumPageWithId(Integer int1) {
		this.driver.get("http://localhost:8082/albumsingle.html?id=1");
	}

	@When("I click on the name of the first track")
	public void iClickOnTheNameOfTheFirstTrack() {
		singlePage.clickFirstTrack();
	}

	@Then("I am taken to the page for that track")
	public void iAmTakenToThePageForThatTrack() {
		assertEquals("Choonz - Track", this.driver.getTitle());
	}
	
	@When("I click on the artist name")
	public void i_click_on_the_artist_name() {
	    singlePage.clickArtistLink();
	}

	@Then("I am taken to the artist page")
	public void i_am_taken_to_the_artist_page() {
	    assertEquals("Choonz - Artist details", this.driver.getTitle());
	}
	
	@AfterStep
	public void takeScreenshotAfterStep(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.attach(screenshotUtils.takeScreenshot(driver), "image/png", scenario.getName());
		}
	}

}
