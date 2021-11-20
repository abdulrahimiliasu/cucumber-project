package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;

public class ProductStepDefinitions extends AbstractStepDefinitions{

    ProductPage productPage =  new ProductPage(driver);

    @When("the more button of the product is clicked")
    public void theMoreButtonOfAnyProductIsClicked(){
        productPage.clickProductPageLink();
        waitFor(3);
    }

    @Given("the product page has loaded")
    public void theProductPageHasLoaded() {
    }

    @When("send to a friend button is clicked")
    public void sendToAFriendButtonIsClicked() {
        productPage.clickSendToAFriendButton();
        waitFor(3);
    }

    @Then("fill name of friend  with {string}")
    public void fillNameOfFriendWithName(String expectedName) {
        productPage.fillNameOfFriendFieldWith(expectedName);
        waitFor(2);
    }

    @And("fill email of friend with {string}")
    public void fillEmailOfFriendWithEmail(String expectedEmail) {
        productPage.fillEmailOfFriendFieldWith(expectedEmail);
        waitFor(2);
    }

    @When("the send button is clicked")
    public void theSendButtonIsClicked() {
        productPage.clickSendMessageButton();
        waitFor(2);
    }

    @Then("the {string} message should be shown")
    public void theFeedbackMessageShouldBeShown(String expectedMessage) {
        String actualMessage = productPage.getSendToFriendErrorMessage();
        System.out.println(expectedMessage+":"+actualMessage);
    }

    @Then("write review button is clicked")
    public void writeReviewButtonIsClicked() {
        productPage.clickWriteAReviewButton();
        waitFor(5);
    }

    @Then("title field is filled with {string} and comment field is filled with {string}")
    public void titleFieldIsFilledWithTitleAndCommentFieldIsFilledWithComment(String title, String comment) {
        productPage.fillTitleOfReviewFieldWith(title);
        productPage.fillCommentOfReviewFieldWith(comment);
        waitFor(3);
    }

    @When("the send review button is clicked")
    public void theSendReviewButtonIsClicked() {
        productPage.clickSendReviewButton();
        waitFor(5);
    }

    @Then("the {string} and {string}error message should be shown")
    public void theComment_errorAndTitle_errorErrorMessageShouldBeShown(String expectedCommentMsg, String expectedTitleMsg) {
        String actualComment;
        String actualTitle;
        if (expectedCommentMsg.equals(" ")){
            actualComment = productPage.getCommentIncorrectErrorMessage();
            System.out.println(expectedTitleMsg+":"+ expectedCommentMsg+" "+ actualComment);
        }
        if (expectedTitleMsg.equals(" ")){
            actualTitle = productPage.getCommentIncorrectErrorMessage();
            System.out.println(expectedTitleMsg+":"+ expectedCommentMsg+" "+actualTitle);
        }

    }
}
