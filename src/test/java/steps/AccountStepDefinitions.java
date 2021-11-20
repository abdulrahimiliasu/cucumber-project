package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.SignInPage;

public class AccountStepDefinitions extends AbstractStepDefinitions{

    SignInPage signInPage = new SignInPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @When("the go to user account button is clicked")
    public void thenClickOnTheUserAccountButton(){
        signInPage.clickMyAccountButton();
        waitFor(5);
    }

    @And("the user is signed in")
    public void theUserIsSignedIn() {
        signInPage.signInUser();
        waitFor(5);
    }

    @And("the user is already signed in")
    public void theUserIsAlreadySignedIn() {
        signInPage.signInUser(true);
        waitFor(3);
    }

    @When("the order and history detail button is clicked")
    public void theOrderAndHistoryDetailButtonIsClicked() {
        accountPage.clickOrderHistoryAndDetailsButton();
        waitFor(2);
    }

    @When("the my credit slips button is clicked")
    public void theMyCreditSlipsButtonIsClicked() {
        accountPage.clickMyCreditSlipsButton();
        waitFor(2);
    }

    @Then("the {string} message should be shown.")
    public void theMessageShouldBeShown(String expectedMessage) {
        String actualMessage = accountPage.getWarningMessage();
        System.out.println(expectedMessage+ ":" +actualMessage);
    }

    @When("the my address button is clicked")
    public void theMyAddressButtonIsClicked() {
        accountPage.clickMyAddressesButton();
        waitFor(4);
    }

    @Then("the {string} address should be there")
    public void theAddressShouldBeThere(String expectedAddress) {
        String actualAddress = accountPage.getAddress();
        System.out.println(expectedAddress+ ":" + actualAddress);
    }

    @Then("the {string} text should be shown.")
    public void theTextShouldBeShown(String expectedMessage) {
        String actualMessage = accountPage.getOrderText();
        System.out.println(expectedMessage+ ":" +actualMessage);
    }
}
