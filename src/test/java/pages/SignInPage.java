package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInSubmitButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    private WebElement errorMessageText;

    @FindBy(className = "account")
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void fillEmailFieldWith(String text){
        emailField.sendKeys(text);
    }

    public void fillPasswordFieldWith(String text){
        passwordField.sendKeys(text);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void clickSignInSubmitButton(){signInSubmitButton.click();}

    public void clickMyAccountButton(){ myAccountButton.click();}

    public void signInUser(){
        try {
            myAccountButton.click();
        }catch (NoSuchElementException | NoSuchFrameException | TimeoutException exception){
            clickSignInButton();
            waitFor(5);
            fillEmailFieldWith("brad@gmail.com");
            fillPasswordFieldWith("12345678");
            clickSignInSubmitButton();
            waitFor(5);
        }
    }

    public void signInUser(boolean doNotOpenAccountPage){
        try {
            if (doNotOpenAccountPage){
                myAccountButton.isDisplayed();
            }
        }catch (NoSuchElementException | NoSuchFrameException | TimeoutException exception){
            clickSignInButton();
            waitFor(3);
            fillEmailFieldWith("brad@gmail.com");
            fillPasswordFieldWith("12345678");
            clickSignInSubmitButton();
            waitFor(4);
        }
    }

    private void waitFor(int seconds){
        try{Thread.sleep(seconds * 1000L);}catch (InterruptedException exception){System.out.println(exception.getMessage());}
    }

    public String getErrorMessage(){
        String text;
        try{
            text = errorMessageText.getText();
        }catch (NoSuchElementException | TimeoutException exception){
            return "No Such Element";
        }
        return text.strip();
    }
}
