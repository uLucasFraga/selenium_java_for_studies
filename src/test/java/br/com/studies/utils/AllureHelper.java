package br.com.selenium.studies.utils;

import cucumber.api.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AllureHelper {

  private static void screenShot(String status, Scenario scenario) {
    byte[] screenshotBytes = ((TakesScreenshot) Page.getDriver()).getScreenshotAs(OutputType.BYTES);
    InputStream screenshotStream = new ByteArrayInputStream(screenshotBytes);
    Allure.addAttachment(scenario.getName() + " - " + status, screenshotStream);
  }

  public static void saveScreenshotOfScenario(Scenario scenario) {
    if (!scenario.isFailed()) {
      screenShot("PASSED", scenario);

    } else {
      screenShot("FAILED", scenario);
    }
  }
}
