package com.qa.choonz.uat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GenreSinglePage {
	
	public final String url = "http://localhost:8082/genresingle.html?id=1";
	
	@FindBys( {@FindBy(className = "card")} )
	public List<WebElement> albumCovers;
	
	@FindBys( {@FindBy(xpath = "/html/body/div[2]/div[2]/table/tbody/tr/td[3]")} )
	public WebElement firstArtist;
	
	
	public void clickAlbumName() {
		albumCovers.get(0).click();
	}
	
	public void clickArtistName() {
		firstArtist.click();
	}

}
