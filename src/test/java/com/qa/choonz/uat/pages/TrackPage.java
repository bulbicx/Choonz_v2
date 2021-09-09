package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackPage {
	
	public final String url = "http://localhost:8082/track.html?id=1";
	
	@FindBy(className = "card")
	private WebElement albumCover;
	
	@FindBy(className = "artist-name")
	public WebElement artistName;
	
	public void clickAlbumCover() {
		this.albumCover.click();
	}
	
	public void clickArtistCover() {
		artistName.click();
	}
}
