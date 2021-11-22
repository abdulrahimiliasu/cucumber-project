package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsStepDefinitions extends AbstractStepDefinitions{

    ContactUsPage contactUsPage = new ContactUsPage(driver);
    HomePage homePage = new HomePage(driver);

    @When("contactus button is clicked")
    public void contactusButtonIsClicked() {
        homePage.clickContactUsButton();
        waitFor(4);
    }

    @Then("the {string} subject heading is selected")
    public void theSubjectSubjectHeadingIsSelected(String subjectHeading) {
        contactUsPage.selectSubjectHeading(subjectHeading);
    }

    @And("the email field is filled with {string}")
    public void theEmailFieldIsFilledWithEmail(String emailAddress) {
        contactUsPage.fillEmailFieldWith(emailAddress);
    }

    @And("the order reference field is filled with {string}")
    public void theOrderReferenceFieldIsFilledWithOrder(String orderReference) {
        contactUsPage.fillOrderReferenceWith(orderReference);
    }

    @And("the message field is filled with {string}")
    public void theMessageFieldIsFilledWithMsg(String message) {
        contactUsPage.fillMessageFieldWith(message);
    }

    @When("the Send button is clicked")
    public void theSendButtonIsClicked() {
        contactUsPage.clickSendButton();
        waitFor(5);
    }

    @Then("the {string} should be shown to user")
    public void theError_messageShouldBeShownToUser(String expectedError) {
        String actualError = contactUsPage.getErrorMessageText();
        System.out.println(expectedError.equals(actualError));
        Assert.assertEquals(expectedError,actualError);
    }

    @Then("the {string} success message should be shown to user")
    public void theSuccessMessageShouldBeShownToUser(String expectedSuccessMessage) {
        String actualSuccessMessage = contactUsPage.getSuccessMessageText();
        System.out.println(expectedSuccessMessage+":"+actualSuccessMessage+"--end");
        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
    }
}
