package br.com.studies.runner;

import br.com.studies.enums.Browsers;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources"},
    glue = {"br.com.studies.stepDefinitions"},
    plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
    tags = {"~@notImplemented"})
public class CucumberRunnerTest {

  @BeforeClass
  public static void tearUp() {
    Browsers.setWebDriver();
  }
}
