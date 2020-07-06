package br.com.selenium.studies.stepDefinitions;

import br.com.selenium.studies.pages.GitHubPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class githubSteps {

  private static GitHubPage gitHubPage;

  @Before
  public static void setup() {
    gitHubPage = new GitHubPage();
  }

  @Given("^he accesses the page$")
  public void he_accesses_the_page() {
    gitHubPage.visit("Github");
  }

  @Then("^he checks the text on the home page: \"([^\"]*)\"$")
  public void he_checks_the_text_on_the_home_page(String text) {
    assertTrue(gitHubPage.verifySearch(text));
  }
}
