package integrations;

import static org.junit.jupiter.api.Assertions.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import integrations.pages.StartPage;
import integrations.util.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class GeneralStepDefinitions {

    private static WebDriver driver;
    public static StartPage startPage;

    @Before("@Search")
    public static void setupWebDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),
                    options, false);
        } catch (MalformedURLException e) {
            fail(e);
        }
    }

    @After("@Search")
    public static void shutdownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Given("the user is on the start page.")
    public static void the_user_is_on_the_start_page() {
        startPage = Utils.openStartPage(driver);
    }
}
