package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class CartStepDefinitions extends AbstractStepDefinitions{

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    ProductPage productPage = new ProductPage(driver);

    @And("cart button is clicked")
    public void cartButtonIsClicked(){
        shoppingCartPage.clickCartButton();
        waitFor(3);
    }

    @Given("the shopping cart is empty")
    public void theShoppingCartIsEmpty() {
    }

    @Then("a {string} message should be displayed.")
    public void aMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = shoppingCartPage.getMessage();
        System.out.println(expectedMessage+":"+actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Given("the user added items to the cart")
    public void theUserAddedItemsToTheCart() {
        waitFor(5);
        productPage.clickProductPageLink();
        waitFor(5);
        productPage.clickAddProductToCartButton();
        waitFor(3);
    }

    @And("proceed to checkout button is clicked")
    public void proceedToCheckoutButtonIsClicked() {
        shoppingCartPage.clickProceedToCheckOutButton();
        waitFor(3);
    }

    @Then("check the terms and conditions")
    public void checkTheTermsAndConditions() {
        shoppingCartPage.checkTermsCheckbox();
        waitFor(3);
    }

    @When("pay by check button is clicked")
    public void payByCheckButtonIsClicked() {
        shoppingCartPage.clickPayByCheckButton();
        waitFor(3);
    }

    @Then("I confirm order button should be clicked")
    public void iConfirmOrderButtonShouldBeClicked() {
        shoppingCartPage.clickIConfirmOrderButton();
        waitFor(5);
    }

    @And("{string} message should be shown.")
    public void messageShouldBeShown(String expectedMessage) {
        String actualMessage = shoppingCartPage.getOrderSuccessMessage();
        System.out.println(expectedMessage+":"+actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("the proceed button is clicked")
    public void theProceedButtonIsClicked() {
        shoppingCartPage.clickProceedButton();
        waitFor(3);
    }

    @Then("the second proceed button is clicked")
    public void theSecondProceedButtonIsClicked() {
        shoppingCartPage.clickSecondProceedButton();
        waitFor(3);
    }

    @Then("the third proceed button is clicked")
    public void theThirdProceedButtonIsClicked() {
        shoppingCartPage.clickThirdProceedButton();
        waitFor(3);
    }
}
