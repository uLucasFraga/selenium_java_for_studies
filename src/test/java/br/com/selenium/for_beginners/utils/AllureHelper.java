package br.com.selenium.for_beginners.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import io.qameta.allure.Allure;

public class AllureHelper {

    private static void screenShot(String status, Scenario scenario) {
        byte[] screenshootBytes = ((TakesScreenshot) Page.getDriver()).getScreenshotAs(OutputType.BYTES);
        InputStream screenshootStream = new ByteArrayInputStream(screenshootBytes);
        Allure.addAttachment(scenario.getName() +" - "+ status, screenshootStream);
    }

    public static void saveScreenshootOfScenario(Scenario scenario) {
        if (!scenario.isFailed()) {
            screenShot("PASSED", scenario);

        } else {
            screenShot("FAILED", scenario);
        }
    }
}