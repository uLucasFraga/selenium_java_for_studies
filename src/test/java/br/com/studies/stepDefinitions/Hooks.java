package br.com.selenium.studies.stepDefinitions;

import br.com.selenium.studies.enums.Browsers;
import br.com.selenium.studies.utils.AllureHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

  @After
  public void afterEachScenario(Scenario scenario) {
    AllureHelper.saveScreenshotOfScenario(scenario);
    Browsers.quitDriver();
  }
}
