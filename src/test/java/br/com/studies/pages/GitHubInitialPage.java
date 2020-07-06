package br.com.studies.pages;

import br.com.studies.utils.HandleProperties;
import br.com.studies.utils.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GitHubPage extends Page {

  private static final By HOME_TEXT_RESULT = By.cssSelector("h1[class='_1sVzC']");
  private static final By INPUT_SEARCH = By.cssSelector("input[placeholder*='faça sua']");
  private static final By BUTTON_SEARCH = By.cssSelector("span[class='icon-search']");

  public void visit(String url) {
    String urlGitHub =
        System.getProperty("urlGitHub") != null
            ? System.getProperty("urlGitHub")
            : HandleProperties.getValue("url_github");
    openUrl(urlGitHub);
    isUrlContainsValue(url);
  }

  public void fillIn(String text) {
    isElementAttachedToHtml(INPUT_SEARCH);
    fillInput(text, INPUT_SEARCH);
    click(BUTTON_SEARCH);
  }

  public boolean verifySearch(String message) {
    By MESSAGE = By.xpath("//summary[contains(.,'" + message + "')]");
    isElementAttachedToHtml(MESSAGE);
    return getTextFromLabel(MESSAGE).equals(message);
  }

  public void selectSearchByTitle(String title) {
    By TEST = By.cssSelector("a[title*='" + title + "']");
    waitElement(TEST);
    isElementAttachedToHtml(HOME_TEXT_RESULT);
    List<WebElement> textList = new ArrayList<>();
    textList.addAll(getElements(HOME_TEXT_RESULT));
    for (WebElement element : textList) {
      if (title.equals(getAttributeFromLabel(TEST, "title"))) {
        element.click();
        isVisible(HOME_TEXT_RESULT);
        break;
      }
    }
  }
}