package com.qa.choonz.uat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GenresPage {

	public final String url = "http://localhost:8082/genres.html";

	@FindBys({ @FindBy(className = "card-box") })
	public List<WebElement> genreCards;

	@FindBy(xpath = "/html/body/div[3]/footer/div[2]/a[1]")
	public WebElement footerHomeBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[2]/a[2]")
	public WebElement footerArtistsBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[2]/a[3]")
	public WebElement footerAlbumsBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[2]/a[4]")
	public WebElement footerPlaylistsBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[2]/a[5]")
	public WebElement footerGenresBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[4]/ul/li[1]/a")
	public WebElement facebookBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[4]/ul/li[2]/a")
	public WebElement instagramBtn;

	@FindBy(xpath = "/html/body/div[3]/footer/div[4]/ul/li[3]/a")
	public WebElement twitterBtn;

	public void clickFirstCard() {
		this.genreCards.get(0).click();
	}

	public void clickFooterHomeBtn() {
		footerHomeBtn.click();
	}

	public void clickFooterArtistsBtn() {
		footerArtistsBtn.click();
	}

	public void clickFooterAlbumsBtn() {
		footerAlbumsBtn.click();
	}

	public void clickFooterPlaylistsBtn() {
		footerPlaylistsBtn.click();
	}

	public void clickFooterGenresBtn() {
		footerGenresBtn.click();
	}

	public void clickFacebookBtn() {
		facebookBtn.click();
	}

	public void clickInstagramBtn() {
		instagramBtn.click();
	}

	public void clickTwitterBtn() {
		twitterBtn.click();
	}

}
