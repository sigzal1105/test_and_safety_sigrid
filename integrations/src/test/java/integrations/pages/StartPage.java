package integrations.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import integrations.util.CustomConditions;
import integrations.util.Utils;

public class StartPage {

    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;

        if (!driver.getTitle().equals("The Library")) {

            throw new IllegalStateException("Not on the correct page. Expected \"The Library\", but was \""
                    + driver.getTitle() + "\"");
        }
    }

    public SearchPage navigateToSearchPage() {

        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // final WebElement dropdown = Utils.find(driver, By.className("dropdown"));
        // wait.until(CustomConditions.elementHasBeenClicked(dropdown));

        final WebElement search = Utils.find(driver, By.linkText("Search"));
        wait.until(CustomConditions.elementHasBeenClicked(search));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='Title']")));

        return new SearchPage(driver);
    }
}
