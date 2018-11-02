package br.com.selenium.for_beginners.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import br.com.selenium.for_beginners.enums.Browsers;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/resources/",
plugin= {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
glue = "br/com/selenium/for_beginners/test/stepsDefinitions",
tags= {"~@notImplemented"})

public class CucumberRunnerTest {

	@BeforeClass
	public static void tearUp() {
		Browsers.setWebDriver();
	}
}