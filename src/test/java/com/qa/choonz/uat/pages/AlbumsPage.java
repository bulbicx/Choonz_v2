package com.qa.choonz.uat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AlbumsPage {
	
	public final String url = "http://localhost:8082/albums.html";
	
	@FindBys( value = { @FindBy(className = "title-card") })
	private List<WebElement> albumCards;
	
	public void clickCard() {
		albumCards.get(0).click();
	}

}
