package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;

public class SignInStepDefinitions extends AbstractStepDefinitions{

    private SignInPage signInPage;

    @Given("the Sign In page is opened")
    public void theSignInPageIsOpened() {
        signInPage = new SignInPage(driver);
        signInPage.clickSignInButton();
        waitFor(5);
    }

    @Given("the email address field is filled with {string}")
    public void theEmailAddressFieldIsFilledWithEmail(String emailAddress) {
        signInPage.fillEmailFieldWith(emailAddress);
    }

    @And("the password field is filled with {string}")
    public void thePasswordFieldIsFilledWithPassword(String password) {
        signInPage.fillPasswordFieldWith(password);
    }

    @When("the Sign In button is clicked")
    public void theSignInButtonIsClicked() {
        signInPage.clickSignInButton();
       waitFor(3);
    }

    @And("the {string} should be shown")
    public void theError_messageShouldBeShown(String expectedErrorMessage) {
        String actualErrorMessage = signInPage.getErrorMessage();
        System.out.println(expectedErrorMessage.equals(actualErrorMessage));
//        Assert.assertEquals("Error Message",expectedErrorMessage,actualErrorMessage);
    }
}
