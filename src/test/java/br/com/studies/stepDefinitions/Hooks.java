package br.com.studies.stepDefinitions;

import br.com.studies.enums.Browsers;
import br.com.studies.utils.AllureHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

  @After
  public void afterEachScenario(Scenario scenario) {
    AllureHelper.saveScreenshotOfScenario(scenario);
    Browsers.quitDriver();
  }
}
