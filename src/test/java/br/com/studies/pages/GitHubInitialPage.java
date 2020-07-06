package br.com.studies.pages;

import br.com.studies.utils.HandleProperties;
import br.com.studies.utils.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GitHubInitialPage extends Page {

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

  public boolean verifySearch(String message) {
    By MESSAGE = By.xpath("//summary[contains(.,'" + message + "')]");
    isElementAttachedToHtml(MESSAGE);
    return getTextFromLabel(MESSAGE).equals(message);
  }
}
