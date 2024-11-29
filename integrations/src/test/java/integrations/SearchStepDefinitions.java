package integrations;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

import integrations.pages.*;
import integrations.util.Utils;

public class SearchStepDefinitions {
    private SearchPage searchPage;

    @When("the user navigates to the book search.")
    public void the_user_navigates_to_the_book_search() {
        searchPage = GeneralStepDefinitions.startPage.navigateToSearchPage();
    }

    @Then("they can see the search form.")
    public void they_can_see_the_search_form() {
        searchPage.SeeSearchPageFormElement();
    }

    @Given("the user is on the search page.")
    public void the_user_is_on_the_search_page() {
        StartPage startPage = Utils.openStartPage(GeneralStepDefinitions.getDriver());

        searchPage = startPage.navigateToSearchPage();
    }

    @When("the user searches for a {string} in one of the {string}.")
    public void the_user_searches_for_search_term_a_that_in_one_of_the_search_fields(String str, String searchFields) {

        searchPage.search(str, searchFields);
    }

    @Then("it will display the message {string}")
    public void it_will_display_the_message(String string) {

        searchPage.showsBooksNotFoundMessage();
    }

    @Then("the results in the corresponding {string} columns will match the {string}.")
    public void the_results_in_the_corresponding_columns_will_match_the(String searchField, String str) {

        assertThat(searchPage.showMatchingBooks(searchField)).contains(str);
    }
}
