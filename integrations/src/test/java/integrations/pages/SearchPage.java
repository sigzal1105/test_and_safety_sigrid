package integrations.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import integrations.util.CustomConditions;
import integrations.util.Utils;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;

        if (!driver.getTitle().equals("The Library")) {

            throw new IllegalStateException("Not on the correct page. Expected \"The Library\", but was \""
                    + driver.getTitle() + "\"");
        }
    }

    public void SeeSearchPageFormElement() {
        ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='Title']"));
    }
}