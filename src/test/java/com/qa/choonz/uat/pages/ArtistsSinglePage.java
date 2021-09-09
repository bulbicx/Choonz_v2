package com.qa.choonz.uat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ArtistsSinglePage {

	public final String url = "http://localhost:8082/artistsingle.html?id=1";

	@FindBys({ @FindBy(className = "card-album") })
	private List<WebElement> coverAlbums;

	@FindBy(xpath = "//*[@id=\"album-table-body\"]/tr/td[4]")
	private WebElement genre;

	public void clickFirstAlbumCover() {
		this.coverAlbums.get(0).click();
	}

	public void clickGenreName() {
		this.genre.click();
	}

}
