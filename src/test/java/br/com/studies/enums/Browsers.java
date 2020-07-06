package br.com.studies.enums;

import br.com.studies.utils.DriverFactory;
import br.com.studies.utils.HandleProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public enum Browsers {
  FF_LINUX("webdriver.gecko.driver", "/geckodriver_linux"),
  FF_MAC("webdriver.gecko.driver", "/geckodriver_mac"),
  FF_WINDOWS("webdriver.gecko.driver", "\\geckodriver_win.exe"),
  CHROME_LINUX("webdriver.chrome.driver", "/chromedriver_linux"),
  CHROME_MAC("webdriver.chrome.driver", "/chromedriver_mac"),
  CHROME_WINDOWS("webdriver.chrome.driver", "\\chromedriver_win.exe");

  public static WebDriver webDriver;
  private final String browserType;
  private final String executable;

  Browsers(String browserType, String executable) {
    this.browserType = browserType;
    this.executable = executable;
  }

  public static void showAvailableBrowsersOptions() {
    for (Browsers browsers : Browsers.values()) {
      System.out.println("======= ".concat(browsers.name()));
    }
  }

  public static void setWebDriver() {
    if (Boolean.parseBoolean(System.getProperty("url_github"))) {
      try {
        String urlConcrete =
            System.getProperty("urlGithub") != null
                ? System.getProperty("urlGithub")
                : HandleProperties.getValue("url_github");
        webDriver = new RemoteWebDriver(new URL(urlConcrete), new ChromeOptions());
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    } else {
      webDriver = DriverFactory.createDriver(System.getProperty("browser"));
    }
  }

  public static void quitDriver() {
    webDriver.quit();
    webDriver = null;
  }

  public String getBrowserType() {
    return browserType;
  }

  public String getExecutable() {
    return executable;
  }

  public WebDriver createDriverInstance() {
    switch (browserType) {
      case "webdriver.gecko.driver":
        return new FirefoxDriver();
      case "webdriver.chrome.driver":
        return new ChromeDriver();
      default:
        return null;
    }
  }
}
