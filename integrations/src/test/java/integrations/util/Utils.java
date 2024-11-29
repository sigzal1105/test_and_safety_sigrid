package integrations.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import integrations.pages.SearchPage;
import integrations.pages.StartPage;

public class Utils {
    private Utils() {
    }

    public static StartPage openStartPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://frontend");
        return new StartPage(driver);
    }

    public static SearchPage openSearchPage(WebDriver driver) {
        driver.get("http://localhost:8888/search");
        return new SearchPage(driver);
    }

    public static WebElement find(WebDriver driver, By locator) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public static Select findSelect(WebDriver driver, By locator) {
        return new Select(find(driver, locator));
    }
}
