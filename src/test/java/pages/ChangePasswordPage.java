package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/ol/li")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p")
    private WebElement successMessage;

    @FindBy(id = "old_passwd")
    private WebElement oldPasswordField;

    @FindBy(id = "passwd")
    private WebElement newPasswordField;

    @FindBy(id = "confirmation")
    private WebElement confirmationField;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button")
    private WebElement saveButton;

    public ChangePasswordPage(WebDriver driver){PageFactory.initElements(driver, this);}

    public void clickSaveButton(){saveButton.click();}

    public void fillOldPasswordFieldWith(String oldPassword){ oldPasswordField.sendKeys(oldPassword);}
    public void fillNewPasswordFieldWith(String newPassword){ newPasswordField.sendKeys(newPassword);}
    public void fillConfirmationFieldWith(String confirmPassword){ confirmationField.sendKeys(confirmPassword);}

    public String getErrorMessage(){
        return errorMessage.getText().strip();
    }

    public String getSuccessMessage(){
        return successMessage.getText().strip();
    }
}
