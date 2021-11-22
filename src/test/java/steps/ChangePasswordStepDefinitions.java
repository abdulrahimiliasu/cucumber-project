package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.ChangePasswordPage;
import pages.SignInPage;

public class ChangePasswordStepDefinitions extends AbstractStepDefinitions{

    AccountPage accountPage = new AccountPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);

    @When("the user account button is clicked")
    public void theUserAccountButtonIsClicked(){
        signInPage.clickMyAccountButton();
        waitFor(5);
    }

    @And("then click on your personal information button")
    public void thenClickOnYourPersonalInformationButton() {
        accountPage.clickMyPersonalInformationButton();
        waitFor(5);
    }

    @Then("fill the old password with {string}")
    public void fillTheOldPasswordWithOld_password(String oldPasswordTobeFilled) {
        changePasswordPage.fillOldPasswordFieldWith(oldPasswordTobeFilled);
    }

    @And("fill the new password with {string}")
    public void fillTheNewPasswordWithNew_password(String newPasswordToBeFilled) {
        changePasswordPage.fillNewPasswordFieldWith(newPasswordToBeFilled);
    }

    @And("fill the confirmation with {string}")
    public void fillTheConfirmationWithConfirmation(String confirmationPassword) {
        changePasswordPage.fillConfirmationFieldWith(confirmationPassword);
    }

    @Then("the {string} error message should appear")
    public void theMessageErrorMessageShouldAppear(String expectedErrorMessage) {
        String actualErrorMessage = changePasswordPage.getErrorMessage();
        System.out.println(expectedErrorMessage+":"+actualErrorMessage);
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Then("the {string} success message should appear")
    public void theMessageSuccessMessageShouldAppear(String expectedSuccessMessage) {
        String actualSuccessMessage = changePasswordPage.getSuccessMessage();
        System.out.println(expectedSuccessMessage+":"+actualSuccessMessage);
        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
    }

    @When("the save button is clicked")
    public void theSaveButtonIsClicked() {
        changePasswordPage.clickSaveButton();
        waitFor(4);
    }
}
