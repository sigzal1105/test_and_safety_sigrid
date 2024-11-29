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

    public void search(String searchTerm, String field) {

        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        final WebElement searchField = Utils.find(driver, By.cssSelector("input[placeholder='" + field + "']"));
        wait.until(CustomConditions.elementHasBeenClicked(searchField));
        searchField.sendKeys(searchTerm);

        final WebElement search = Utils.find(driver, By.cssSelector("input[value='Search']"));
        wait.until(CustomConditions.elementHasBeenClicked(search));

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//caption[text()='Matching books']")));

        } catch (Exception e) {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='No books found']")));
        }

        searchField.clear();
    }

    public void showsBooksNotFoundMessage() {
        WebElement element = driver.findElement(By.xpath("//div[text()='No books found']"));
        element.getText();
    }

    public String showMatchingBooks(String field) {
        List<WebElement> headRows = driver.findElements(By.cssSelector("table.table.w-full thead tr th"));
        List<WebElement> bodyRows = driver.findElements(By.cssSelector("table.table.w-full tbody tr td"));

        for (int i = 0; i < headRows.size(); i++) {

            String headRowText = headRows.get(i).getText();

            if (headRowText.equalsIgnoreCase(field)) {

                return bodyRows.get(i).getText();
            }
        }

        return null;
    }
}