package com.qa.choonz.uat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ArtistsPage {
	
	public final String url = "http://localhost:8082/artists.html";
	
	@FindBys( {@FindBy(className = "card-box")} )
	public List<WebElement> artistCards;
	
	public void clickFirstCard() {
		this.artistCards.get(0).click();
	}
	
	public void clickCardByInput(int num) {
		this.artistCards.get(num).click();
	}

}
