package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class SearchStepsDefinitions extends AbstractStepDefinitions{

    private HomePage homePage;

    @Given("the home page has loaded")
    public void theHomePageHasLoaded() {
        homePage = new HomePage(driver);
        waitFor(4);
    }

    @Given("the search field is filled with {string}")
    public void theSearchFieldIsFilledWithParameter(String text) {
        homePage.fillSearchBarWith(text);
    }

    @When("the Search button is clicked")
    public void theSearchButtonIsClicked() {
        homePage.clickSearchButton();
        waitFor(3);
    }

    @Then("confirm the {string} help message is shown")
    public void theMsgErrorMessageIsShown(String expectedHelpMessage) {
        String actualHelpMessage = homePage.getSearchHelpText();
        System.out.println(expectedHelpMessage +":"+ actualHelpMessage);
    }

    @And("the search result should be {string}")
    public void theResultShouldBeResult_text(String expectedResult) {
        String actualResult = homePage.getSearchResultText();
        System.out.println(expectedResult +":"+ actualResult);
    }

}
