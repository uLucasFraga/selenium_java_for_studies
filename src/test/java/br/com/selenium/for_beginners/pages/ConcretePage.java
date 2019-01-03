package br.com.selenium.for_beginners.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.selenium.for_beginners.utils.Page;
import br.com.selenium.for_beginners.utils.HandleProperties;

public class ConcretePage extends Page {

	private static final By HOME_TEXT_RESULT = By.cssSelector("h1[class='_1sVzC']");
	private static final By INPUT_SEARCH = By.cssSelector("input[placeholder*='faça sua']");
	private static final By BUTTON_SEARCH = By.cssSelector("span[class='icon-search']");
	private static final By RESULTS_FOUND = By.cssSelector("div[class='col-xs-12 col-sm-6 col-md-3']");
	private static final By LIST_OF_TITLE = By.cssSelector("div[class='col-xs-12 col-sm-6 col-md-3'] a");
	private static final By TITLE_SEARCH = By.cssSelector("h1[itemprop='headline'] div");

	public void visit(String url) {
		String urlConcrete = System.getProperty("urlConcrete") != null ? System.getProperty("urlConcrete")
				: HandleProperties.getValue("url_concrete");
		openUrl(urlConcrete);
		isUrlContainsValue(url);
	}

	public void fillIn(String text) {
		isElementAttachedToHtml(INPUT_SEARCH);
		fillInput(text, INPUT_SEARCH);
		click(BUTTON_SEARCH);
	}
	
	public boolean verifySearch(String message) {
		By MESSAGE = By.xpath("//div[@class='_byCx']//h3//div[contains(.,'" + message + "')]");
		isElementAttachedToHtml(MESSAGE);
		return getTextFromLabel(MESSAGE).equals(message);
	}
	
	public boolean verifyText(String title) {
		isElementAttachedToHtml(TITLE_SEARCH);
		return getTextFromLabel(TITLE_SEARCH).equals(title);
	}
	
	public boolean verifyHomePage(String text) {
		isElementAttachedToHtml(HOME_TEXT_RESULT);
		return getTextFromLabel(HOME_TEXT_RESULT).equals(text);
	}
	
	public void selectSearchByTitle(String title) {
		By TEST = By.cssSelector("a[title*='"+title+"']");
		waitElement(TEST);
		isElementAttachedToHtml(RESULTS_FOUND);
		List<WebElement> textList = new ArrayList<>();
		textList.addAll(getElements(LIST_OF_TITLE));
		for (WebElement element : textList) {
			if (title.equals(getAttributeFromLabel(TEST, "title"))) {
				element.click();
				isVisible(TITLE_SEARCH);
				break;
			}
		}
	}
}