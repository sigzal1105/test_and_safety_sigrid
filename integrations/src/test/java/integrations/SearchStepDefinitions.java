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

}
