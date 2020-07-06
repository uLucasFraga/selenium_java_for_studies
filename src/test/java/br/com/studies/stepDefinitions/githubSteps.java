package br.com.studies.stepDefinitions;

import br.com.studies.pages.GitHubInitialPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class githubSteps {

  private static GitHubInitialPage gitHubInitialPage;

  @Before
  public static void setup() {
    gitHubInitialPage = new GitHubInitialPage();
  }

  @Given("^he accesses the page$")
  public void he_accesses_the_page() {
    gitHubInitialPage.visit("github");
  }

  @Then("^he checks the text on the initial page: \"([^\"]*)\"$")
  public void he_checks_the_text_on_the_initial_page(String text) {
    assertTrue(gitHubInitialPage.verifySearch(text));
  }
}
