package br.com.selenium.for_beginners.test.stepsDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import br.com.selenium.for_beginners.enums.Browsers;
import br.com.selenium.for_beginners.utils.AllureHelper;

public class Hooks {

    @After
    public void afterEachScenario(Scenario scenario) {
        AllureHelper.saveScreenshootOfScenario(scenario);
        Browsers.quitDriver();
    }
}