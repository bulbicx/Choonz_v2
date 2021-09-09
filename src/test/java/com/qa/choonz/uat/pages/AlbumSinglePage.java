package com.qa.choonz.uat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AlbumSinglePage {

	public final String url = "http://localhost:8082/albumsingle.html?id=1";

	@FindBy(className = "title-section-sgl-pg")
	private WebElement titlePage;

	@FindBys({ @FindBy(className = "row-track") })
	private List<WebElement> rowsTracks;

	@FindBy(className = "artist-name")
	private WebElement artistName;

	public String getTitlePage() {
		return this.titlePage.getText();
	}

	public void clickFirstTrack() {
		this.rowsTracks.get(0).click();
	}

	public void clickArtistLink() {
		this.artistName.click();
	}

}
